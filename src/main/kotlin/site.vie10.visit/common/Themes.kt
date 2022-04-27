package site.vie10.visit.common

import kotlinx.js.jso
import mui.material.PaletteMode.dark
import mui.material.PaletteMode.light
import mui.material.styles.createTheme

/**
 * @author vie10
 **/
object Themes {
    val Light = createTheme(
        jso {
            palette = jso {
                mode = light
            }
            typography = jso {
                fontFamily = arrayOf("\"JetBrains Mono\"", "sans-serif").joinToString(",")
            }
        }
    )

    val Dark = createTheme(
        jso {
            palette = jso {
                mode = dark
            }
            typography = jso {
                fontFamily = arrayOf("\"JetBrains Mono\"", "sans-serif").joinToString(",")
            }
        }
    )
}
