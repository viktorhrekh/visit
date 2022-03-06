package site.vie10.visit

import site.vie10.visit.component.LanguageModule
import site.vie10.visit.component.MainPage
import site.vie10.visit.content.ContentLoader
import site.vie10.visit.content.GlobalContentLoader
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.*
import site.vie10.visit.lang.ContentLangPackLoader
import site.vie10.visit.lang.LangPack
import site.vie10.visit.lang.LangPackLoader
import org.w3c.dom.Element
import react.FC
import react.Props
import react.create
import react.dom.render
import site.vie10.visit.component.LanguageCookie

val rootElement: Element = document.getElementById("root")!!
val contentLoader: ContentLoader = GlobalContentLoader
val langPackLoader: LangPackLoader = ContentLangPackLoader(contentLoader)
lateinit var scope: CoroutineScope

@DelicateCoroutinesApi
fun main() {
    scope = GlobalScope
    val langCode = LanguageCookie.value ?: window.navigator.language.substringBefore("-")
    langPackLoader.loadOrDefault(langCode) {
        withContext(Dispatchers.Main) {
            start(it)
        }
    }
}

fun start(langPack: LangPack) {
    render(FC<Props> {
        LanguageModule {
            this.langPack = langPack
            MainPage()
        }
    }.create(), rootElement)
}


