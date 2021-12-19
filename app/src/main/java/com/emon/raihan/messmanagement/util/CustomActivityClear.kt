package eraapps.bankasia.bdinternetbanking.apps.util

import android.app.Activity
import android.content.Intent
import android.util.Log


class CustomActivityClear {
    companion object {

        fun doClearActivity(intent: Intent, activity: Activity) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            activity.startActivity(intent)
            activity.finish()


        }


        fun logoutExpireTime(intent: Intent, activity: Activity,diffInMs:Long,logoutTime:Int) {

            //Log.e("erra logoutExpireTime","indie****")
           // Log.e("idl exeper **","logout****"+ logoutTime)
          //  Log.e("idl diffInMs-->",diffInMs.toString())

            if(diffInMs> logoutTime){

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                activity.startActivity(intent)
                activity.finish()

            }



        }
    }
}