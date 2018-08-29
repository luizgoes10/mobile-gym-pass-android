package com.example.livetouch.efeso.common.util

import android.content.Context
import codeone.com.br.mobile_gym_pass.application.GymPassApplication

/**
 * Created by João Goulart on 08/03/18.
 */
open class PrefsUtils {

    companion object {
        private val prefsKey: String
            get() {
                return "GymPassSharedPreferences"
            }

        private val baseContext: Context
            get() {
                return GymPassApplication.appInstance.baseContext
            }

        fun setString(flag: String, valor: String) {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            val editor = pref.edit()
            editor.putString(flag, valor)
            editor.apply()
        }

        fun getString(flag: String, defaultValue: String = ""): String {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            return pref.getString(flag, defaultValue)
        }

        @JvmOverloads
        fun getBoolean(flag: String, defaultValue: Boolean = false): Boolean {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            return pref.getBoolean(flag, defaultValue)
        }

        fun setBoolean(flag: String, b: Boolean) {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            val editor = pref.edit()
            editor.putBoolean(flag, b)
            editor.apply()
        }

        fun getLong(flag: String, defaultValue: Long = 0): Long {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            return pref.getLong(flag, defaultValue)
        }

        fun getInt(flag: String, defaultValue: Int = 0): Int {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            return pref.getInt(flag, defaultValue)
        }

        fun setInt(flag: String, i: Int) {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            val editor = pref.edit()
            editor.putInt(flag, i)
            editor.apply()
        }

        fun setLong(flag: String, i: Long) {
            val pref = baseContext.getSharedPreferences(prefsKey, 0)
            val editor = pref.edit()
            editor.putLong(flag, i)
            editor.apply()
        }
    }
}