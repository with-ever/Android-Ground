package com.withever.blind.base

import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.withever.blind.R

class BaseViewPager: ViewPager {
    private var size: Point = Point(0,0)
    private var isNeedMeasurePage: Boolean = true

    constructor(context: Context): super(context){}
    constructor(context: Context, attrs: AttributeSet?): super(context, attrs){}

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        size.set(MeasureSpec.getSize(widthMeasureSpec),
            MeasureSpec.getSize(heightMeasureSpec))

        var widthSpec = MeasureSpec.makeMeasureSpec(
            size.x,
            MeasureSpec.EXACTLY)
        var heightSpec = MeasureSpec.makeMeasureSpec(
            size.y,
            MeasureSpec.EXACTLY)

        super.onMeasure(widthSpec, heightSpec)
        onMeasurePage(widthSpec, heightSpec)
    }

    protected fun onMeasurePage(widthMeasureSpec: Int, heightMeasureSpec: Int){
        val child = getChildAt(0)
        child.measure(widthMeasureSpec, heightMeasureSpec)

        val pageWidth = child.measuredWidth
        val matchView = child.findViewById<ImageView>(R.id.imageCategoryIcon)

        if(matchView != null){
            val matchWidth = matchView.measuredWidth

            if(matchWidth > 0){
                val diff = pageWidth - matchWidth
                pageMargin = -diff

                val offScreen = Math.ceil(pageWidth.toDouble() / matchWidth.toDouble()).toInt() + 1
                offscreenPageLimit = offScreen

                requestLayout()
            }
        }

    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        isNeedMeasurePage = true
    }
}