package site.vie10.visit.component

import kotlinx.browser.window
import mui.icons.material.SvgIconComponent
import mui.material.IconButton
import mui.material.IconButtonColor
import mui.material.Tooltip
import react.FC
import react.Props
import react.ReactNode
import react.dom.aria.ariaLabel

/**
 * @author vie10
 **/
external interface LinkButtonProps : Props {
    var label: String
    var link: String
    var icon: SvgIconComponent
}

val LinkButton = FC<LinkButtonProps> { props ->
    Tooltip {
        title = ReactNode(props.label)
        ariaLabel = props.label

        IconButton {
            color = IconButtonColor.inherit
            onClick = {
                window.open(props.link, "_blank")?.focus()
            }

            props.icon()
        }
    }
}
