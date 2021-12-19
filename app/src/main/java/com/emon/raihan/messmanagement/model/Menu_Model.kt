package com.emon.raihan.messmanagement.model

class Menu_Model(menuName: String, imageId: Int, softcode: String) {

    var menuName : String? = ""
    var imageId : Int? =0
    var softcode : String? =""

    init {
        this.menuName = menuName
        this.imageId = imageId
        this.softcode = softcode

    }

}