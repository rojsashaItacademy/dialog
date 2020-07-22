package com.trinitydigital.dialogs

interface DialogCLicks {
    fun clickDialog(isNeedCloseApp: Boolean)
    fun sendText(text: String)
}