package site.vie10.visit.content

/**
 * @author vie10
 **/
interface ContentLoader {

    fun load(path: String, onResult: suspend (String) -> Unit)

    fun load(path: String): Result<String>
}
