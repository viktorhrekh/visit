package site.vie10.visit.content

/**
 * @author vie10
 **/
interface ContentLoader {

    fun load(path: String, onResult: (String) -> Unit)

    fun tryLoad(path: String, onResult: (Result<String>) -> Unit)
}
