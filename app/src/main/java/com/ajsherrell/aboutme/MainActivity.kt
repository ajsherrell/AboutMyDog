package com.ajsherrell.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var nickNameTextView: TextView
    private lateinit var doneButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.nickname_edit)
        nickNameTextView = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        doneButton.setOnClickListener {
            addNickName(it)
        }

        nickNameTextView.setOnClickListener {
            updateNickname(it)
        }
    }

    private fun addNickName(view: View) {
        nickNameTextView.text = editText.text
        editText.visibility = View.GONE
        nickNameTextView.visibility = View.VISIBLE
        view.visibility = View.GONE

        // Hide the keyboard.
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View) {
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE
        editText.requestFocus()

        // Show the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}
