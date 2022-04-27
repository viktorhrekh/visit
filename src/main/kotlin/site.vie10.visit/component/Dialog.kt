package site.vie10.visit.component

import csstype.TextAlign
import csstype.integer
import mui.material.Dialog
import mui.material.DialogTitle
import mui.system.sx
import react.*

/**
 * @author vie10
 **/

external interface DialogProps : PropsWithChildren {
    var title: String?
}

typealias CloseableDialogState = StateInstance<Boolean>

val CloseableDialogContext = createContext<CloseableDialogState>()

val CloseableDialogModule = FC<PropsWithChildren> { props ->
    val state = useState(true)
    CloseableDialogContext.Provider(state) {
        +props.children
    }
}

val CloseableDialog = FC<DialogProps> { props ->
    var opened by useContext(CloseableDialogContext)
    Dialog {
        sx {
            zIndex = integer(1_1000)
            textAlign = TextAlign.center
        }
        open = opened
        onClose = { _, _ ->
            opened = false
        }

        DialogTitle {
            +props.title.orEmpty()
        }
        +props.children
    }
}
