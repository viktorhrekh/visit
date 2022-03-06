package site.vie10.visit.component

import csstype.*
import csstype.Auto.auto
import kotlinx.js.jso
import mui.icons.material.GitHub
import mui.icons.material.LinkedIn
import mui.icons.material.PictureAsPdf
import mui.icons.material.Telegram
import mui.material.Box
import mui.material.Container
import mui.material.Grid
import mui.material.Typography
import react.FC
import react.Props
import site.vie10.visit.common.GridAreas
import site.vie10.visit.common.Sizes.Footer
import site.vie10.visit.common.Sizes.Header
import site.vie10.visit.util.textFromContext
import site.vie10.visit.util.wordFromContext

/**
 * @author vie10
 **/
val MainPage = FC<Props> {
    ThemeModule {
        SettingsModule {
            Box {
                sx = jso {
                    display = Display.grid
                    gridTemplateRows = array(
                        Header.Height,
                        auto,
                        Footer.Height
                    )
                    gridTemplateColumns = array(
                        auto,
                    )
                    gridTemplateAreas = GridTemplateAreas(
                        ident(GridAreas.Header),
                        ident(GridAreas.Content),
                        ident(GridAreas.Footer),
                    )
                }

                PageContent()
            }
        }
    }
}

private val PageContent = FC<Props> {
    PageHeader()
    Container {
        sx = jso {
            gridArea = ident(GridAreas.Content)
            padding = 15.px
        }

        ResumeContent()
    }
    PageFooter()
    SettingsDrawer()
    if (LanguageCookie.value == null) {
        CloseableDialogModule {
            LanguageDialog()
        }
    }
}

private val PageHeader = FC<Props> {
    Header {
        sx = jso {
            gridArea = ident(GridAreas.Header)
            zIndex = integer(1_500)
            height = Header.Height
        }

        Grid {
            sx = jso {
                alignItems = AlignItems.center
                justifyContent = JustifyContent.spaceBetween
            }
            container = true

            Grid {
                item = true

                Typography {
                    variant = "h5"

                    +textFromContext.fullName
                }
            }
            Grid {
                item = true

                LinkButton {
                    label = wordFromContext.pdf
                    icon = PictureAsPdf
                    link = "etc/version.pdf"
                }
                SettingsTooltip()
            }
        }
    }
}

private val PageFooter = FC<Props> {
    Footer {
        sx = jso {
            gridArea = ident(GridAreas.Footer)
            zIndex = integer(1_500)
            height = Footer.Height
        }

        SocialNetworkButtons()
    }
}

private val SocialNetworkButtons = FC<Props> {
    Grid {
        sx = jso {
            alignItems = AlignItems.center
            justifyContent = JustifyContent.spaceEvenly
        }
        container = true

        Grid {
            item = true

            LinkButton {
                label = wordFromContext.telegram
                icon = Telegram
                link = textFromContext.telegramLink
            }
        }
        Grid {
            item = true

            LinkButton {
                label = wordFromContext.gitHub
                icon = GitHub
                link = textFromContext.gitHubLink
            }
        }
        Grid {
            item = true

            LinkButton {
                label = wordFromContext.linkedIn
                icon = LinkedIn
                link = textFromContext.linkedInLink
            }
        }
    }
}
