package site.vie10.visit.content

import kotlinx.coroutines.launch
import org.w3c.xhr.XMLHttpRequest
import site.vie10.visit.scope

object GlobalContentLoader : ContentLoader {

    override fun load(path: String, onResult: suspend (String) -> Unit) {
        scope.launch {
            load(path).onSuccess {
                onResult(it)
            }.onFailure {
                it.printStackTrace()
            }
        }
    }

    override fun load(path: String): Result<String> = runCatching {
        val request = XMLHttpRequest()
        request.open("GET", path, async = false)
        request.send(null)
        val responseText = request.responseText
        if (request.status != 200.toShort()) {
            throw Exception(responseText)
        }
        responseText
    }
}
