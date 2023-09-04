package com.example.customdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var resetbutton : Button = findViewById(R.id.buttonreset)

        resetbutton.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            var customlay : View = layoutInflater.inflate(R.layout.customdialog,null)
            builder.setView(customlay)


            builder.setTitle("please reset password")
            builder.setPositiveButton("OK") { dialog: DialogInterface?, which: Int ->
                // send data from the AlertDialog to the Activity
                val editText = customlay.findViewById<EditText>(R.id.edtpass)
                sendDialogDataToActivity(editText.text.toString())
            }
        }
    }

    private fun sendDialogDataToActivity(data: String) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show()

    }
}