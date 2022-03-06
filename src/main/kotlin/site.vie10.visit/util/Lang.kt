package site.vie10.visit.util

import site.vie10.visit.component.LanguageContext
import site.vie10.visit.lang.LangPack
import react.useContext

/**
 * @author vie10
 **/

val textFromContext: LangPack.Text
    get() = langPackFromContext.text

val wordFromContext: LangPack.Word
    get() = langPackFromContext.word

val langPackFromContext: LangPack
    get() {
        val langPack by useContext(LanguageContext)
        return langPack
    }
