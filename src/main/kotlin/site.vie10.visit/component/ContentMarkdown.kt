package site.vie10.visit.component

import react.FC
import react.Props
import react.useContext
import site.vie10.visit.contentLoader

/**
 * @author vie10
 **/

external interface ContentMarkdownProps : Props {
    var contentPath: String?
    var contentName: String
}

val ContentMarkdown = FC<ContentMarkdownProps> { props ->
    var content by useContext(MarkdownContext)
    val langPack by useContext(LanguageContext)
    Markdown()
    contentLoader.load("${props.contentPath.orEmpty()}${langPack.code}-${props.contentName}.md") {
        content = it
    }
}
