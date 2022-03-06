package site.vie10.visit

import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.coroutines.DelicateCoroutinesApi
import org.w3c.dom.Element
import react.FC
import react.Props
import react.create
import react.dom.render
import site.vie10.visit.component.LanguageCookie
import site.vie10.visit.component.LanguageModule
import site.vie10.visit.component.MainPage
import site.vie10.visit.content.ContentLoader
import site.vie10.visit.content.GlobalContentLoader
import site.vie10.visit.lang.ContentLangPackLoader
import site.vie10.visit.lang.LangPack
import site.vie10.visit.lang.LangPackLoader

val rootElement: Element = document.getElementById("root")!!
val contentLoader: ContentLoader = GlobalContentLoader
val langPackLoader: LangPackLoader = ContentLangPackLoader(contentLoader)

@DelicateCoroutinesApi
fun main() {
    val langCode = LanguageCookie.value ?: window.navigator.language.substringBefore("-")
    langPackLoader.loadOrDefault(langCode) {
        start(it)
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


