package com.withever.blind.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.PagerAdapter
import com.withever.blind.R
import com.withever.blind.databinding.LayoutCategoryPageBinding
import com.withever.blind.ui.posting.PostingWriteActivity

class LoungeCategoryPagerAdapter() : PagerAdapter() {
    var context: Context? = null
    var itemWidth: Int = 0

    constructor(context_: Context?) : this(){
        context = context_
    }

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, obj: Any): Boolean {
        return view == (obj as ConstraintLayout)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val binding: LayoutCategoryPageBinding = DataBindingUtil.inflate(
            LayoutInflater.from(container.context),
            R.layout.layout_category_page,
            container,
            false
        )

        binding.categoryName = container.resources.getString(PostingWriteActivity.PostingCategory.values()[position % 6].descriptionID)
        container.addView(binding.root)

        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
        container.removeView(obj as ConstraintLayout)
    }

    override fun getPageWidth(position: Int): Float {
        return 1.0f
    }
}