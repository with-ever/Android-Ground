package com.withever.blind.widget

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.withever.blind.R
import com.withever.blind.application.BlindApplication
import com.withever.blind.utils.SystemUtils.getDeviceDpi

class TImageView (context: Context, attrs: AttributeSet): AppCompatImageView(context, attrs) {

    private var crop: Crop = Crop.FIT_CENTER
    private var style: Style = Style.RECTANGLE

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TImageView)
        crop = getCrop(typedArray.getInt(R.styleable.TImageView_crop, 1))
        style = getStyle(typedArray.getInt(R.styleable.TImageView_style, 1))
        typedArray.recycle()
    }

    fun load(url: String, listener: ImageLoadListener? = null) {
        if (listener == null) {
            loadImage(url)
        } else {
            loadImageCallback(url, listener)
        }
    }

    /**----------------------------------------------------
     * load Image
     *----------------------------------------------------*/
    private fun loadImage(url: String) {
        when (crop) {
            Crop.FIT_CENTER -> {
                Glide.with(BlindApplication.getContext())
                    .load(url)
                    .fitCenter()
                    .dontAnimate()
                    .fallback(style.image)
                    .placeholder(style.image)
                    .error(style.image)
                    .apply(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888))
                    .override(measuredWidth, measuredHeight)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(this)
            }
            Crop.CENTER_CROP -> {
                Glide.with(BlindApplication.getContext())
                    .load(url)
                    .centerCrop()
                    .dontAnimate()
                    .fallback(style.image)
                    .placeholder(style.image)
                    .error(style.image)
                    .apply(RequestOptions().format(DecodeFormat.PREFER_ARGB_8888))
                    .override(measuredWidth, measuredHeight)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(this)
            }
        }
    }

    fun loadImageCallback(url: String, listener: ImageLoadListener?) {
        when (crop) {
            Crop.FIT_CENTER -> {
                Glide.with(BlindApplication.getContext())
                    .load(url)
                    .fitCenter()
                    .fallback(style.image)
                    .placeholder(style.image)
                    .error(style.image)
                    .dontAnimate()
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            listener?.failed()
                            return false
                        }
                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            listener?.success()
                            return false
                        }
                    })
                    .into(this)
            }
            Crop.CENTER_CROP -> {
                Glide.with(BlindApplication.getContext())
                    .load(url)
                    .centerCrop()
                    .fallback(style.image)
                    .placeholder(style.image)
                    .error(style.image)
                    .dontAnimate()
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .listener(object : RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            listener?.failed()
                            return false
                        }
                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            listener?.success()
                            return false
                        }
                    })
                    .into(this)
            }
        }
    }


    /**----------------------------------------------------
     * Enum
     *----------------------------------------------------*/
    enum class Crop(val id: Int) {
        FIT_CENTER(1),
        CENTER_CROP(2)
    }

    enum class Style(val id: Int, val image: Int) {
        RECTANGLE(1, R.drawable.ic_default_rectangle),
        SQUARE(2, R.drawable.ic_default_square),
        PROFILE(3, R.drawable.ic_default_profile)
    }

    private fun getCrop(id: Int): Crop = when (id) {
        Crop.FIT_CENTER.id -> Crop.FIT_CENTER
        Crop.CENTER_CROP.id -> Crop.CENTER_CROP
        else -> Crop.FIT_CENTER
    }

    private fun getStyle(id: Int): Style = when (id) {
        Style.RECTANGLE.id -> Style.RECTANGLE
        Style.SQUARE.id -> Style.SQUARE
        Style.PROFILE.id -> Style.PROFILE
        else -> Style.RECTANGLE
    }

}

/**----------------------------------------------------
 * Listener
 *----------------------------------------------------*/
interface ImageLoadListener {
    fun success()
    fun failed()
}


/**----------------------------------------------------
 * Utils
 *----------------------------------------------------*/
// 이미지 해상도 가져오는 메소드
// TODO - 해상도마다 이미지 해상도 지정
fun getResolutionImage(): String {
    val dpi = getDeviceDpi()
    return when {
        dpi <= 160 -> "420" // mdpi
        dpi <= 240 -> "480" // hdpi
        dpi <= 320 -> "560" // xhdpi
        dpi <= 480 -> "720" // xxhdpi
        dpi <= 640 -> "840" // xxxhdpi
        else -> "720"
    }
}