@file:Suppress("NOTHING_TO_INLINE")

package codeone.com.br.mobile_gym_pass.commons.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import codeone.com.br.mobile_gym_pass.application.GymPassApplication

//valores de strings e estado da net

inline fun getStrings(resourceId: Int): String {
    return GymPassApplication.appInstance.baseContext.getString(resourceId)
}

fun isNetworkAvailable(): Boolean {
    val connectivity = GymPassApplication.appInstance.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    //TODO fix deprecation
    val info = connectivity.allNetworkInfo
    info?.indices?.filter { info[it].state == NetworkInfo.State.CONNECTED }?.forEach { return true }

    return false
}