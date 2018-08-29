package codeone.com.br.mobile_gym_pass.commons.util

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Build
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.clearTop
import org.jetbrains.anko.internals.AnkoInternals
import org.jetbrains.anko.newTask

inline fun <reified T: Activity> Context.startActivityTop(vararg params: Pair<String, Any>) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(AnkoInternals.createIntent(this, T::class.java, params).clearTop().newTask().clearTask())
    } else {
        startActivity(AnkoInternals.createIntent(this, T::class.java, params).clearTop().newTask())
    }
}

inline fun <reified T: Activity> Fragment.startActivityTop(vararg params: Pair<String, Any>) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        startActivity(AnkoInternals.createIntent(activity, T::class.java, params).clearTop().newTask().clearTask())
    } else {
        startActivity(AnkoInternals.createIntent(activity, T::class.java, params).clearTop().newTask())
    }
}