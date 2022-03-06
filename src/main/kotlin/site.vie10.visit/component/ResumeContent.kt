package site.vie10.visit.component

import csstype.Color
import csstype.TextAlign
import csstype.px
import kotlinx.js.jso
import mui.material.*
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
            sx = jso {
                height = 150.px
            }
            component = img
            image = "images/kotlin-wallpaper.jpg"
        }

        CardContent {
            Typography {
                sx = jso {
                    textAlign = TextAlign.center
                }
                gutterBottom = true
                variant = "h4"

                +textFromContext.kotlinDev
            }
            Divider()
            Typography {
                sx = jso {
                    textAlign = TextAlign.center
                    color = Color("text.secondary")
                }
                gutterBottom = true
                variant = "body2"

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
