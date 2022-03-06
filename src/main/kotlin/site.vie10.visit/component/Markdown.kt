package site.vie10.visit.component

import mui.markdown.MuiMarkdown
import react.*

/**
 * @author vie10
 **/
typealias MarkdownState = StateInstance<String>

val MarkdownContext = createContext<MarkdownState>()

val MarkdownModule = FC<PropsWithChildren> { props ->
    val state = useState("")
    MarkdownContext.Provider(state) {
        +props.children
    }
}

val Markdown = FC<Props> {
    val content by useContext(MarkdownContext)
    MuiMarkdown {
        + content
    }
}
