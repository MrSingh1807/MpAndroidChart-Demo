package com.pettracker.mpandroidchartdemo

import android.content.Context
import android.widget.TextView
import com.github.mikephil.charting.components.MarkerView
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.highlight.Highlight
import com.github.mikephil.charting.utils.MPPointF
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint

class MyMarkerView(context: Context, layoutResource: Int) :
    MarkerView(context, layoutResource) {

    private val linePaint: Paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 2f
    }

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.drawLine(
            width / 2f,
            0f,
            width / 2f,
            height.toFloat(),
            linePaint
        )
    }
    override fun refreshContent(entry: Entry, highlight: Highlight) {
//        markerTextView.text = entry.y.toString()
//        super.refreshContent(entry, highlight)
    }

    override fun getOffset(): MPPointF {
        return MPPointF((-(width / 2)).toFloat(), (-height).toFloat())
    }
}