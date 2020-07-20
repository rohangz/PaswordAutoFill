package com.rinfinity.paswordautofill.service

import android.os.CancellationSignal
import android.service.autofill.*
import android.widget.RemoteViews

class PasswordAutoFillService: AutofillService() {
    override fun onCreate() {
        super.onCreate()
    }
    override fun onFillRequest(
        request: FillRequest,
        cancellationSignal: CancellationSignal,
        callback: FillCallback
    ) {
        val context = request.fillContexts
        val structure = context[context.size-1].structure
        val userNamePresentation = RemoteViews(packageName, android.R.layout.simple_list_item_1)
        userNamePresentation.setTextViewText(android.R.id.text1, "username")
        val passwordPresentation = RemoteViews(packageName, android.R.layout.simple_list_item_1)
        passwordPresentation.setTextViewText(android.R.id.text1, "password")


    }

    override fun onSaveRequest(request: SaveRequest, callback: SaveCallback) {
    }

}