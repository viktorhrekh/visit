package site.vie10.visit.component

import csstype.*
import kotlinx.browser.window
import mui.icons.material.Close
import mui.icons.material.Settings
import mui.material.*
import mui.material.styles.TypographyVariant.body1
import mui.material.styles.TypographyVariant.body2
import mui.system.responsive
import mui.system.sx
import react.*
import react.dom.aria.ariaLabel
import site.vie10.visit.util.textFromContext
import site.vie10.visit.util.wordFromContext

/**
 * @author vie10
 **/

typealias SettingsState = StateInstance<Boolean>

val SettingsContext = createContext<SettingsState>()

val SettingsModule = FC<PropsWithChildren> { props ->
    val state = useState(false)

    SettingsContext.Provider(state) {
        +props.children
    }
}

val SettingsTooltip = FC<Props> {
    var settingsOpen by useContext(SettingsContext)

    Tooltip {
        title = ReactNode(wordFromContext.settings)
        ariaLabel = wordFromContext.settings

        IconButton {
            color = IconButtonColor.inherit
            onClick = {
                settingsOpen = true
            }

            Settings()
        }
    }
}

val SettingsDrawer = FC<Props> {
    var opened by useContext(SettingsContext)

    SwipeableDrawer {
        sx {
            zIndex = integer(1_1000)
        }

        anchor = DrawerAnchor.right
        open = opened
        onOpen = {
            opened = true
        }
        onClose = {
            opened = false
        }

        Grid {
            sx {
                height = 100.pct
                width = if (window.innerWidth > 600) 360.px else 310.px
                justifyContent = JustifyContent.spaceBetween
            }
            direction = responsive(GridDirection.column)
            container = true

            Grid {
                item = true

                SettingsContent()
            }

            Grid {
                item = true

                SettingsFooter()
            }
        }
    }
}

private val SettingsFooter = FC<Props> {
    Box {
        sx {
            padding = 20.px
            textAlign = TextAlign.center
        }

        Typography {
            sx {
                color = Color("text.secondary")
            }
            variant = body2

            +textFromContext.devLabel
        }
    }
}

private val SettingsContent = FC<Props> {
    Box {
        sx {
            padding = 20.px
        }

        Box {
            sx {
                marginBottom = 15.px
            }
            SettingsHeader()
        }
        Divider()
        Box {
            sx {
                marginTop = 15.px
            }

            ModeToggle()
        }

        Box {
            sx {
                marginTop = 15.px
            }

            LanguageSelector()
        }
    }
}

private val SettingsHeader = FC<Props> {
    var opened by useContext(SettingsContext)

    Grid {
        sx {
            justifyContent = JustifyContent.spaceBetween
            alignItems = AlignItems.center
            textAlign = TextAlign.center
        }
        container = true

        Grid {
            item = true

            Typography {
                sx {
                    textDecoration = TextDecoration.solid
                }
                variant = body1

                +wordFromContext.settings
            }
        }

        Grid {
            item = true

            IconButton {
                edge = IconButtonEdge.end
                onClick = {
                    opened = false
                }

                Close()
            }
        }
    }
}
