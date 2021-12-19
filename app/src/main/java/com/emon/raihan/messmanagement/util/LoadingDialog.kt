package com.example.dreambuilders.util

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import com.emon.raihan.messmanagement.R

class LoadingDialog() {

    private var activity: Activity? = null
    private var alertDialog: AlertDialog? = null

//    fun loadingDialogm(myActivity: Activity?) {
//        activity = myActivity
//    }


    fun startDialoglog(myActivity: Activity?) {
        activity = myActivity
        val dialog = AlertDialog.Builder(activity).setCancelable(false)
        val inflater = LayoutInflater.from(activity)
        val reg_layout: View = inflater.inflate(R.layout.loging_dialog, null)
        dialog.setView(reg_layout)
        alertDialog = dialog.create()
        alertDialog!!.getWindow()!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        alertDialog!!.show()
    }

    fun dismisstDialoglog() {
        alertDialog!!.dismiss()
    }
}