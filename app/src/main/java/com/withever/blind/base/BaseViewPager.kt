package com.withever.blind.base

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Point
import android.util.AttributeSet
import android.view.View
import androidx.viewpager.widget.ViewPager
import com.withever.blind.R

class BaseViewPager(context: Context, attrs: AttributeSet): ViewPager(context, attrs) {
    private var size: Point = Point(0,0)
    private var isNeedMeasurePage: Boolean = true
    private var matchWidthTargetChildId: Int

    init{
        clipChildren = false
        var ta: TypedArray = context.obtainStyledAttributes(attrs, R.styleable.BaseViewPager)
        matchWidthTargetChildId = ta.getResourceId(R.styleable.BaseViewPager_matchWidthTargetChild, 0)
        ta.recycle()
    }

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
        val matchView = child.findViewById<View>(matchWidthTargetChildId)

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