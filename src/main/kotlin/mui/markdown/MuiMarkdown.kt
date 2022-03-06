@file:JsModule("mui-markdown")
@file:JsNonModule

package mui.markdown

/**
 * @author vie10
 **/

external interface MuiMarkdownProps : react.Props {
    var children: String
}

@JsName("default")
external val MuiMarkdown: react.FC<MuiMarkdownProps>

