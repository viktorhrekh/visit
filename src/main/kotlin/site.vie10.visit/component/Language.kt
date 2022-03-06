package site.vie10.visit.component

import csstype.AlignItems
import csstype.Color
import csstype.JustifyContent
import csstype.pct
import kotlinx.js.jso
import mui.material.*
import react.*
import site.vie10.visit.common.Languages
import site.vie10.visit.cookie.Cookie
import site.vie10.visit.lang.LangPack
import site.vie10.visit.langPackLoader
import site.vie10.visit.util.textFromContext
import site.vie10.visit.util.wordFromContext

/**
 * @author vie10
 **/

val LanguageCookie = Cookie("visit-lang")

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

val LanguageDialog = FC<Props> {
    CloseableDialogModule {
        CloseableDialog {
            title = textFromContext.isItRight
            LanguageDialogContent()
            LanguageDialogActions()
        }
    }
}

private val LanguageDialogContent = FC<Props> {
    DialogContent {
        Container {
            LanguageSelector()
        }
    }
}

private val LanguageDialogActions = FC<Props> {
    var opened by useContext(CloseableDialogContext)

    DialogActions {
        Grid {
            sx = jso {
                alignItems = AlignItems.center
                justifyContent = JustifyContent.center
                height = 100.pct
                width = 100.pct
            }
            container = true

            Grid {
                sx = jso {
                    width = 100.pct
                }
                item = true

                Button {
                    sx = jso {
                        width = 100.pct
                    }
                    variant = ButtonVariant.text
                    size = Size.large
                    onClick = {
                        opened = false
                    }

                    +wordFromContext.yes
                }
            }
        }
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
