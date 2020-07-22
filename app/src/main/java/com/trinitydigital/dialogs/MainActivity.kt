package com.trinitydigital.dialogs

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.ContextThemeWrapper
import java.util.*

class MainActivity : AppCompatActivity(), DialogCLicks {

    private var btnAlertDialog: Button? = null
    private var btnCustomDialog: Button? = null
    private var tvTitleFromDialog: TextView? = null
    private var tvCount: TextView? = null
    private var etDate: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        btnAlertDialog = findViewById(R.id.btnAlertDialog)
        btnCustomDialog = findViewById(R.id.btnCustomDialog)
        tvTitleFromDialog = findViewById(R.id.tvTitleFromDialog)
        tvCount = findViewById(R.id.tvCount)
        etDate = findViewById(R.id.etDate)
    }

    private fun setupListeners() {
        btnAlertDialog?.setOnClickListener {
            createAlertDialog()
        }

        btnCustomDialog?.setOnClickListener {
            createCustomDialog()
        }

        etDate?.setOnClickListener {
            createDatePickerDialog()
        }
    }

    private fun createDatePickerDialog() {
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, dayOfMonth ->
            etDate?.setText(getString(R.string.date, dayOfMonth, month, year))

            tvTitleFromDialog?.text = getString(R.string.items, dayOfMonth, month)

            tvCount?.text = resources.getQuantityString(R.plurals.apples, dayOfMonth, dayOfMonth)
        }

        dialog.datePicker.maxDate = Date().time

        dialog.show()
    }

    private fun createCustomDialog() {
        CustomDialog(this, this).show()
    }

    private fun createAlertDialog() {
        AlertDialog.Builder(ContextThemeWrapper(this, R.style.myDialog))
            .setTitle(getString(R.string.exit))
            .setPositiveButton(getString(R.string.yes)) { dialog, which ->
                finish()
            }
            .setNegativeButton(getString(R.string.no)) { dialog, which ->
                Toast.makeText(this, "НЕТ", Toast.LENGTH_SHORT).show()
            }
            .setNeutralButton("Незнаю") { dialog, which ->
                Toast.makeText(this, "НЕЗНАЮ", Toast.LENGTH_SHORT).show()
            }
            .setIcon(R.mipmap.ic_launcher)
            .setCancelable(false)
            .show()
    }

    override fun clickDialog(isNeedCloseApp: Boolean) {
        if (isNeedCloseApp) finish()
    }

    override fun sendText(text: String) {
        tvTitleFromDialog?.text = text
    }
}