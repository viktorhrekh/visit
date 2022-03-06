package site.vie10.visit.component

import csstype.Auto
import csstype.pct
import csstype.px
import kotlinx.js.jso
import mui.material.AppBar
import mui.material.AppBarPosition
import mui.material.Toolbar
import mui.system.SxProps
import mui.system.Theme
import react.FC
import react.PropsWithChildren

/**
 * @author vie10
 **/
external interface FooterProps : PropsWithChildren {
    var sx: SxProps<Theme>
}

val Footer = FC<FooterProps> { props ->
    AppBar {
        position = AppBarPosition.fixed
        sx = props.sx.apply {
            bottom = 0.px
            top = Auto.auto
        }

        Toolbar {
            sx = jso {
                height = 100.pct
            }

            +props.children
        }
    }
}
