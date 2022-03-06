package site.vie10.visit.content

import org.w3c.xhr.XMLHttpRequest

object GlobalContentLoader : BaseContentLoader() {

    private val XMLHttpRequest.loaded: Boolean
        get() = readyState == 4.toShort()
    private val XMLHttpRequest.ok: Boolean
        get() = status == 200.toShort()

    override fun tryLoad(path: String, onResult: (Result<String>) -> Unit) {
        runCatching {
            val request = XMLHttpRequest()
            request.open("GET", path, async = true)
            request.onload = {
                if (request.loaded) {
                    val responseText = request.responseText
                    val result: Result<String> = runCatching {
                        if (request.ok) {
                            responseText
                        } else {
                            throw Exception(responseText)
                        }
                    }
                    onResult(result)
                }
            }
            request.send(null)
        }
    }
}
