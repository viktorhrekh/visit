package site.vie10.visit.component

import csstype.Color
import csstype.TextAlign
import csstype.px
import mui.material.*
import mui.material.styles.TypographyVariant.body2
import mui.material.styles.TypographyVariant.h4
import mui.system.sx
import react.FC
import react.Props
import react.dom.html.ReactHTML.img
import site.vie10.visit.util.textFromContext

/**
 * @author vie10
 **/
val ResumeContent = FC<Props> {
    Card {
        CardMedia {
            sx {
                height = 150.px
            }
            component = img
            image = "images/kotlin-wallpaper.jpg"
        }

        CardContent {
            Typography {
                sx {
                    textAlign = TextAlign.center
                }
                gutterBottom = true
                variant = h4

                +textFromContext.kotlinDev
            }
            Divider()
            Typography {
                sx {
                    textAlign = TextAlign.center
                    color = Color("text.secondary")
                }
                gutterBottom = true
                variant = body2

                +textFromContext.firstTip
            }

            MarkdownModule {
                ContentMarkdown {
                    contentName = "resume"
                }
            }
        }
    }
}
