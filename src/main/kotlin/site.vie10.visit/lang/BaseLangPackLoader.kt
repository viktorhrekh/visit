package site.vie10.visit.lang

/**
 * @author vie10
 **/
abstract class BaseLangPackLoader : LangPackLoader {

    override fun loadOrDefault(langCode: String, onResult: (LangPack) -> Unit) {
        tryLoadOrDefault(langCode) {
            it.onSuccess(onResult).onFailure { e -> e.printStackTrace() }
        }
    }

    protected abstract fun tryLoadOrDefault(langCode: String, onResult: (Result<LangPack>) -> Unit)
}
