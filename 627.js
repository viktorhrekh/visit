"use strict";(this.webpackChunkvisit=this.webpackChunkvisit||[]).push([[627],{8627:(e,n,o)=>{o.r(n),o.d(n,{default:()=>g,getLinkUtilityClass:()=>h,linkClasses:()=>Z});var r=o(5559),t=o(984),i=o(6204),a=o(3583),s=o(9672),l=o(4860),u=o(3330),c=o(118),d=o(9278),p=o(7369),m=o(1323),b=o(1597),y=o(13),v=o(7776);function h(e){return(0,v.Z)("MuiLink",e)}const Z=(0,o(5288).Z)("MuiLink",["root","underlineNone","underlineHover","underlineAlways","button","focusVisible"]);var f=o(3188);const k=["className","color","component","onBlur","onFocus","TypographyClasses","underline","variant"],x={primary:"primary.main",textPrimary:"text.primary",secondary:"secondary.main",textSecondary:"text.secondary",error:"error.main"},C=(0,d.ZP)(y.Z,{name:"MuiLink",slot:"Root",overridesResolver:(e,n)=>{const{ownerState:o}=e;return[n.root,n[`underline${(0,c.Z)(o.underline)}`],"button"===o.component&&n.button]}})((({theme:e,ownerState:n})=>{const o=(0,l.D)(e,`palette.${(e=>x[e]||e)(n.color)}`)||n.color;return(0,t.Z)({},"none"===n.underline&&{textDecoration:"none"},"hover"===n.underline&&{textDecoration:"none","&:hover":{textDecoration:"underline"}},"always"===n.underline&&{textDecoration:"underline",textDecorationColor:"inherit"!==o?(0,u.Fq)(o,.4):void 0,"&:hover":{textDecorationColor:"inherit"}},"button"===n.component&&{position:"relative",WebkitTapHighlightColor:"transparent",backgroundColor:"transparent",outline:0,border:0,margin:0,borderRadius:0,padding:0,cursor:"pointer",userSelect:"none",verticalAlign:"middle",MozAppearance:"none",WebkitAppearance:"none","&::-moz-focus-inner":{borderStyle:"none"},[`&.${Z.focusVisible}`]:{outline:"auto"}})})),g=i.forwardRef((function(e,n){const o=(0,p.Z)({props:e,name:"MuiLink"}),{className:l,color:u="primary",component:d="a",onBlur:y,onFocus:v,TypographyClasses:Z,underline:x="always",variant:g="inherit"}=o,w=(0,r.Z)(o,k),{isFocusVisibleRef:D,onBlur:S,onFocus:F,ref:V}=(0,m.Z)(),[L,M]=i.useState(!1),R=(0,b.Z)(n,V),A=(0,t.Z)({},o,{color:u,component:d,focusVisible:L,underline:x,variant:g}),B=(e=>{const{classes:n,component:o,focusVisible:r,underline:t}=e,i={root:["root",`underline${(0,c.Z)(t)}`,"button"===o&&"button",r&&"focusVisible"]};return(0,s.Z)(i,h,n)})(A);return(0,f.jsx)(C,(0,t.Z)({className:(0,a.Z)(B.root,l),classes:Z,color:u,component:d,onBlur:e=>{S(e),!1===D.current&&M(!1),y&&y(e)},onFocus:e=>{F(e),!0===D.current&&M(!0),v&&v(e)},ref:R,ownerState:A,variant:g},w))}))}}]);
//# sourceMappingURL=627.js.map