package com.trinitydigital.dialogs

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class CustomDialog(
    context: Context,
    private val listener: DialogCLicks
) : Dialog(context) {

    private var btnInput: Button? = null
    private var btnExit: Button? = null
    private var etInput: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_custom)
        window?.setBackgroundDrawableResource(R.drawable.bg_dialog)
        setCancelable(false)
        setupViews()
        setupListeners()
    }

    private fun setupListeners() {
        btnInput?.setOnClickListener {
            listener.sendText(etInput?.text.toString())
            dismiss()

        }
        btnExit?.setOnClickListener {
            listener.sendText(etInput?.text.toString())
            dismiss()
        }
    }

    private fun setupViews() {
        btnInput = findViewById(R.id.btnInput)
        btnExit = findViewById(R.id.btnExit)
        etInput = findViewById(R.id.etInput)
    }
}