package com.example.core.ui.views

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.StringRes
import com.example.core.R
import java.io.IOException
import java.io.InterruptedIOException
import java.io.PipedReader
import java.io.PipedWriter

class SearchTextView : LinearLayout {

    constructor(context: Context) : super(context) {
        View.inflate(context, R.layout.search_text_view, this)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        View.inflate(context, R.layout.search_text_view, this)
    }

    private val r: PipedReader
    val w: PipedWriter
    private val workerThread: Thread

    init {
        this.alpha = 0F
        r = PipedReader(1024 * 4)
        w = PipedWriter()
        try {
            w.connect(r)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        workerThread = Thread(TextHandlerTask(r))
        workerThread.start()
    }

    override fun onFinishInflate() {
        super.onFinishInflate()
        this.animate().alpha(1F).apply {
            duration = 200L
            start()
        }
    }

    fun setHint(@StringRes title: Int) {
        val searchView = findViewById<TextView>(R.id.searchEditText)
        searchView.hint = context.getText(title)
    }


    fun listenText(listener: (String) -> Unit) {
        val searchView = findViewById<TextView>(R.id.searchEditText)
        searchView.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (count > before) {
                    w.write(s?.subSequence(before, count).toString())
                }
            }

            override fun afterTextChanged(s: Editable?) {
                listener.invoke(s.toString())
            }
        })
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        workerThread.interrupt()
        try {
            r.close()
            w.close()
        } catch (e: IOException) {}
    }

    inner class TextHandlerTask(private val reader: PipedReader) : Runnable {
        override fun run() {
            while (!Thread.currentThread().isInterrupted) {
                try {
                    var i: Int
                    i = reader.read()
                    while (i != -1) {
                        println("run: ${i.toChar()}, ${Thread.currentThread().name}, ${Thread.activeCount()}")
                        i = reader.read()
                    }
                } catch (e: IOException) {}
            }
        }
    }

}