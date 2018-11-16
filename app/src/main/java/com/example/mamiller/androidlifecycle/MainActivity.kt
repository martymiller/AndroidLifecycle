package com.example.mamiller.androidlifecycle

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import android.content.DialogInterface
import android.content.DialogInterface.BUTTON_NEUTRAL
import android.support.v7.app.AlertDialog


class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showCallback("onCreate", Color.GREEN)
    }

    override fun onPause() {
        super.onPause()
        showCallback("onPause", Color.RED)
    }

    override fun onResume() {
        super.onResume()
        showCallback("onResume", Color.CYAN)
    }

    override fun onDestroy() {
        super.onDestroy()
        showCallback("onDestroy", Color.RED)
    }

    override fun onRestart() {
        super.onRestart()
        showCallback("onRestart", Color.LTGRAY)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        showCallback("onRestoreInstance", Color.YELLOW)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Toast.makeText(this, "Saved Instance", Toast.LENGTH_SHORT).show()
        showCallback("onSavedInstance", Color.YELLOW)
    }

    override fun onStop() {
        super.onStop()
        showCallback("onStop", Color.MAGENTA)
    }

    override fun onStart() {
        super.onStart()
        showCallback("onStart", Color.LTGRAY)
    }

    fun showCallback(callback: String, color: Int) {
        val callbackText = TextView(this)
        callbackText.text = "${++count} $callback"
        val textViewPadding: Int = resources.getDimension(R.dimen.textviewPadding).toInt()
        callbackText.setPadding(textViewPadding, textViewPadding, textViewPadding, textViewPadding)
        callbackText.setTextSize(0, resources.getDimension(R.dimen.textviewSize))
        callbackText.setBackgroundColor(color)
        callbackLayout.addView(callbackText)
        callbackScrollView.post({callbackScrollView.fullScroll(View.FOCUS_DOWN) })
        callbackText.setOnClickListener {
            showAlert()
        }
    }

    fun showAlert() {
        val alertDialog = AlertDialog.Builder(this@MainActivity).create()
        alertDialog.setTitle("Alert")
        alertDialog.setMessage("Alert message to be shown")
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                { dialog, which -> dialog.dismiss() })
        alertDialog.show()
    }
}
