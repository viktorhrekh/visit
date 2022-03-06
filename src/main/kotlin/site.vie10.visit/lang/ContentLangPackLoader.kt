package site.vie10.visit.lang

import site.vie10.visit.common.Languages
import site.vie10.visit.content.ContentLoader
import kotlinx.coroutines.launch
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import site.vie10.visit.lang.LangPackLoader.Companion.BASE_PATH_TO_LANG
import site.vie10.visit.scope

/**
 * @author vie10
 **/
class ContentLangPackLoader(
    private val contentLoader: ContentLoader
) : LangPackLoader {

    private val json = Json {
        ignoreUnknownKeys = true
    }
    private val String.withBasePathToLang: String
        get() = BASE_PATH_TO_LANG.replace("{name}", this)

    override fun loadOrDefault(langCode: String, onResult: suspend (LangPack) -> Unit) {
        scope.launch {
            loadOrDefault(langCode).onSuccess {
                onResult(it)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    private fun loadOrDefault(name: String): Result<LangPack> = runCatching {
        contentLoader.load(name.withBasePathToLang).onSuccess {
            return@runCatching json.decodeFromString(it)
        }
        val jsonStr = contentLoader.load(Languages.English.withBasePathToLang).getOrThrow()
        json.decodeFromString(jsonStr)
    }
}
