package site.vie10.visit.lang

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import site.vie10.visit.common.Languages
import site.vie10.visit.content.ContentLoader
import site.vie10.visit.lang.LangPackLoader.Companion.BASE_PATH_TO_LANG

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

    override fun loadOrDefault(langCode: String, onResult: (LangPack) -> Unit) {
        tryLoadOrDefault(langCode) {
            it.onSuccess(onResult).onFailure { e ->
                e.printStackTrace()
            }
        }
    }

    private fun tryLoadOrDefault(name: String, onResult: (Result<LangPack>) -> Unit) = runCatching {
        contentLoader.tryLoad(name.withBasePathToLang) {
            it.onSuccess { content ->
                val result: Result<LangPack> = runCatching {
                    json.decodeFromString(content)
                }
                onResult(result)
            }.onFailure {
                loadDefault { langPack ->
                    onResult(Result.success(langPack))
                }
            }
        }
    }

    private fun loadDefault(onResult: (LangPack) -> Unit) {
        contentLoader.tryLoad(Languages.English.withBasePathToLang) {
            onResult(json.decodeFromString(it.getOrThrow()))
        }
    }
}
