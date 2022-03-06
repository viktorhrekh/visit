package site.vie10.visit.cookie

import kotlinx.browser.document

/**
 * @author vie10
 **/

data class Cookie(
    val name: String
) {

    var value: String?
        get() {
            val values = document.cookie.split(";")
            for (value in values) {
                val tempValue = value.trimStart()
                if (tempValue.startsWith(name)) return tempValue.substringAfter("=")
            }
            return null
        }
        set(value) {
            document.cookie = if (value == null) {
                "$name=; Path=/; Expires=Thu, 01 Jan 1970 00:00:01 GMT;"
            } else {
                "$name=$value; path=/"
            }
        }
}
