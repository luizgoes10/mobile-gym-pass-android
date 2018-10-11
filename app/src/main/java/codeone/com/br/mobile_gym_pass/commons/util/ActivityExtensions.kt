package codeone.com.br.mobile_gym_pass.commons.util

import android.app.Activity
import android.util.Log
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.View
import android.widget.Toast

// findViewById + setOnClickListener
fun AppCompatActivity.onClick(@IdRes viewId: Int, onClick: (v: android.view.View?) -> Unit) {
    val view = findViewById<View>(viewId)
    view.setOnClickListener { onClick(it) }
}

// Mostra um toast
fun Activity.toast(message: CharSequence, length: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, length).show()

fun Activity.toast(@StringRes message: Int, length: Int = Toast.LENGTH_SHORT) =
        Toast.makeText(this, message, length).show()

fun Activity.alert(title: String, message:String) =
        AlertDialog.Builder(this).setMessage(message).setTitle(title)
                .setPositiveButton("OK"){ dialog, which ->  }.show()
// Configura a Toolbar
fun AppCompatActivity.setupToolbar(@IdRes id: Int, title: String? = null, upNavigation: Boolean = false): ActionBar {
    val toolbar = findViewById<Toolbar>(id)
    setSupportActionBar(toolbar)
    if (title != null) {
        supportActionBar?.title = title;
    }
    supportActionBar?.setDisplayHomeAsUpEnabled(upNavigation)
    Log.d("empresas", "Up nav config em $upNavigation $supportActionBar")
    return supportActionBar!!
}

// Adiciona o fragment no layout
fun AppCompatActivity.addFragment(@IdRes layoutId: Int, fragment: androidx.fragment.app.Fragment) {
    fragment.arguments = intent.extras
    val ft = supportFragmentManager.beginTransaction()
    ft.add(layoutId, fragment)
    ft.commit()
}