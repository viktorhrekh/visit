package site.vie10.visit.component

import site.vie10.visit.common.GridAreas
import site.vie10.visit.common.Sizes.Footer
import site.vie10.visit.common.Sizes.Header
import csstype.*
import csstype.Auto.auto
import kotlinx.browser.window
import kotlinx.js.jso
import mui.icons.material.GitHub
import mui.icons.material.LinkedIn
import mui.icons.material.PictureAsPdf
import mui.icons.material.Telegram
import mui.material.*
import react.FC
import react.Props
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

                IconButton {
                    color = IconButtonColor.inherit
                    onClick = {
                        window.open("etc/version.pdf", "_blank")?.focus()
                    }

                    PictureAsPdf()
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
