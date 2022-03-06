package site.vie10.visit.component

import csstype.Color
import kotlinx.js.jso
import mui.material.List
import mui.material.ListItemButton
import mui.material.Typography
import react.*
import site.vie10.visit.common.Languages
import site.vie10.visit.cookie.Cookie
import site.vie10.visit.lang.LangPack
import site.vie10.visit.langPackLoader
import site.vie10.visit.util.wordFromContext

/**
 * @author vie10
 **/
typealias LanguageState = StateInstance<LangPack>

external interface LocalizationProps : PropsWithChildren {
    var langPack: LangPack
}

val LanguageContext = createContext<LanguageState>()

val LanguageModule = FC<LocalizationProps> { props ->
    val state = useState(props.langPack)
    LanguageContext.Provider(state) {
        +props.children
    }
}

val LanguageSelector = FC<Props> {
    var langPack by useContext(LanguageContext)
    LanguageCookie.value = langPack.code

    Typography {
        sx = jso {
            color = Color("text.secondary")
        }
        variant = "caption"
        gutterBottom = true

        +wordFromContext.language.uppercase()
    }
    List {
        ListItemButton {
            val langCode = Languages.English
            divider = true
            selected = langPack.code == langCode
            onClick = {
                langPackLoader.loadOrDefault(langCode) {
                    langPack = it
                }
            }

            +wordFromContext.english
        }

        ListItemButton {
            val langCode = Languages.Ukrainian
            selected = langPack.code == langCode
            onClick = {
                langPackLoader.loadOrDefault(langCode) {
                    langPack = it
                }
            }

            +wordFromContext.ukrainian
        }
    }
}

val LanguageCookie = Cookie("visit-lang")
