package com.iortynskyi.hmsd.extensions

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView

fun TextView.string(): String = this.text.toString()

fun TextView.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {
            // no-op
        }

        override fun onTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {
            // no-op
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

fun TextView.onTextChanged(onTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {
            // no-op
        }

        override fun onTextChanged(sequence: CharSequence?, start: Int, count: Int, after: Int) {
            onTextChanged.invoke(sequence.toString())
        }

        override fun afterTextChanged(editable: Editable?) {
            // no-op
        }
    })
}
