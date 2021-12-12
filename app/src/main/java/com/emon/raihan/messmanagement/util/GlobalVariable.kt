package com.emon.raihan.messmanagement.util

import android.app.Application

import java.util.*

class GlobalVariable : Application() {
    var cusomerCode: String? = ""
    var identifyBanking: String? = ""
    var sessionId: String? = ""
    var mailId: String? = ""
    var companycode: String? = ""
    var outCode: String? = ""
    var OutMessage: String? = ""

    var imei: String? = ""
    var permissioncode: String? = "1"

    //var languageCode: String? = "ENG"
    var languageCode: String? = ""
    var fcmToken: String? = "ENG"
    var pauseTime:Long = 0L

    var sourceAccountList: ArrayList<String>? = null
    var sourceAccountStatementList: ArrayList<String>? = null
    //var operatorList: ArrayList<OperatorAdapterModel>? = null
   // var statusList: ArrayList<CodeDesOptions>? = null
   // var payoneerMenuList: ArrayList<Menu_Model> = ArrayList<Menu_Model>()

    var userId: String? = ""
    var creditCardType: String? = ""

    var username: String? = ""
    var isCalledUser:Boolean = false;

    //var atmList: ArrayList<AtmRoomModel>? = null
   // var branchList: ArrayList<BranchRoomModel>? = null




}