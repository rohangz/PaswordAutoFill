package com.rinfinity.paswordautofill.view

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.autofill.AutofillManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.rinfinity.paswordautofill.R

const val REQUEST_AUTOFILL_SERVICE = 100

class PasswordAutoFillActivity : AppCompatActivity() {
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            Activity.RESULT_OK -> {
                when (requestCode) {
                    REQUEST_AUTOFILL_SERVICE -> {
                        Toast.makeText(
                            this,
                            "Sutofill Service is  now selected",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            }
            else -> {

            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_autofill)
        val service = getSystemService(AutofillManager::class.java)
        service?.let {
            if (!it.hasEnabledAutofillServices() && it.isAutofillSupported) {
                val intent = Intent()
                intent.data = Uri.parse("package:${packageName}")
                intent.action  = android.provider.Settings.ACTION_REQUEST_SET_AUTOFILL_SERVICE
                startActivityForResult(intent, REQUEST_AUTOFILL_SERVICE)
            }
        }
    }
}