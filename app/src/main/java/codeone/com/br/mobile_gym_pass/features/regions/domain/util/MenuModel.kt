package codeone.com.br.mobile_gym_pass.features.regions.domain.util

open class MenuModel(menuName:String, isGroup:Boolean, hasChildren:Boolean, url:String) {

    var menuName = menuName
    var isGroup:Boolean = isGroup
    var hasChildren:Boolean = hasChildren
    var url = url
}