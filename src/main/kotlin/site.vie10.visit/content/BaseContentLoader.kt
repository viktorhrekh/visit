package site.vie10.visit.content

/**
 * @author vie10
 **/
abstract class BaseContentLoader : ContentLoader {
    override fun load(path: String, onResult: (String) -> Unit) {
        tryLoad(path) {
            it.onSuccess(onResult).onFailure { e -> e.printStackTrace() }
        }
    }
}
