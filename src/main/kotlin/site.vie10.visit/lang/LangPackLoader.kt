package site.vie10.visit.lang

/**
 * @author vie10
 **/
interface LangPackLoader {

    fun loadOrDefault(langCode: String, onResult: (LangPack) -> Unit)

    companion object {

        const val BASE_PATH_TO_LANG = "lang/{name}.json"
    }
}
