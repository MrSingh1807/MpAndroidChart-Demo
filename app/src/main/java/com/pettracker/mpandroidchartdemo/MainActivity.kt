package com.pettracker.mpandroidchartdemo

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.LimitLine
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import com.pettracker.mpandroidchartdemo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            accelerationTimeGraphLineCubic.setDataInChart()
            speedTimeGraphLineCubic.setDataInChart()
            hardAccelerationPointGraphLineCubic.setDataInChart()
            hardBreakingPointGraphLineCubic.setDataInChart()
        }

        initViewListeners()
    }

    private fun initViewListeners() {

    }

    private fun LineChart.setDataInChart() {
        // Create a list of entries for the chart.
        val entries =
            arrayListOf(Entry(1f, 3f), Entry(2f, 5f), Entry(3f, 7f), Entry(4f, 6f), Entry(5f, 4f))

        // Create a LineDataSet object and set its properties.
        val lineDataSet = LineDataSet(entries, "My Line Chart")

        lineDataSet.apply {
            setColors(*ColorTemplate.COLORFUL_COLORS)
            lineWidth = 2f


//        setColors(*ColorTemplate.COLORFUL_COLORS)
            mode = LineDataSet.Mode.CUBIC_BEZIER
            setDrawValues(false)
            setDrawCircles(true)
            lineWidth = 2f
            circleRadius = 2f
            lineDataSet.color = ColorTemplate.COLORFUL_COLORS[0]

            // Set the color for the area below the line
            setDrawFilled(true)
            fillColor = ColorTemplate.COLORFUL_COLORS[1]
        }

        // Create a list of LineDataSets and add the LineDataSet to it
        val dataSets: ArrayList<ILineDataSet> = ArrayList()
        dataSets.add(lineDataSet)

        //TODO; Customize the XAxis (bottom axis)
        xAxis.apply {
            setDrawGridLines(false) // Disable drawing vertical grid lines
            setDrawAxisLine(true) // Enable drawing the bottom axis line
            setDrawLabels(true) // Enable drawing XAxis labels

            val fLabels = listOf("0", "1", "2", "3", "4", "5")
            valueFormatter = IndexAxisValueFormatter(fLabels)
            position = XAxis.XAxisPosition.BOTTOM
            textColor = Color.WHITE
        }

        //TODO; Customize the YAxis (left axis)
        val leftAxis = axisLeft
        axisLeft.apply {
            setDrawGridLines(false) // Disable drawing horizontal grid lines
            setDrawAxisLine(true) // Enable drawing the left axis line
            setDrawLabels(true) // Enable drawing YAxis labels

            // TODO: Pass value in XAxis Bottom Side
            textColor = Color.WHITE
            textColor = Color.WHITE
        }

        axisRight.apply {
            setDrawGridLines(false) // Disable drawing horizontal grid lines
            setDrawAxisLine(true) // Enable drawing the left axis line
            setDrawLabels(true) // Enable drawing YAxis labels
        }


        //todo; Set the constant value on the left side of the Y-axis
        val constantValue = 5f // Replace with your desired constant value
        val limitLine = LimitLine(constantValue, "avg")
        limitLine.textColor = Color.CYAN
        limitLine.lineWidth = 2f
        limitLine.lineColor = Color.CYAN

        axisLeft.addLimitLine(limitLine)

        description.isEnabled = false    //remove description label
        legend.isEnabled = false        //add animation
        animateY(1500)

        //TODO; Create a LineData object and add the LineDataSet to it.
        val lineData = LineData(lineDataSet)

        // Set the data for the chart.
        data = lineData

//        xAxis.position = XAxis.XAxisPosition.BOTTOM
//        xAxis.labelCount = entries.size
//        axisRight.isEnabled = false
//
//        axisLeft.setDrawGridLines(false)
//        axisLeft.axisMinimum = 0f
//        axisLeft.axisMaximum = 10f
//        axisLeft.setDrawLabels(false)
//        axisLeft.setDrawAxisLine(false)
//        axisLeft.spaceBottom = 0f
//
//
//        val marker = MyMarkerView(this@MainActivity, layoutResource = R.layout.custom_marker_view)
//        this.marker = marker

        // Invalidate the chart so that it redraws itself.
        invalidate()
    }


}

