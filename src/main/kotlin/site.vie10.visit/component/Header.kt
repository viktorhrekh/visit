package site.vie10.visit.component

import csstype.pct
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
external interface HeaderProps : PropsWithChildren {
    var sx: SxProps<Theme>
}

val Header = FC<HeaderProps> { props ->
    AppBar {
        position = AppBarPosition.fixed
        sx = props.sx

        Toolbar {
            sx = jso {
                height = 100.pct
            }

            +props.children
        }
    }
}
