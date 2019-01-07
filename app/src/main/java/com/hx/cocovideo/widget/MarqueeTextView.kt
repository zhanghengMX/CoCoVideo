package com.hx.cocovideo.widget

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.widget.TextView
import java.util.jar.Attributes

/**
 * author：heng.zhang
 * date：2019/1/4
 * description：
 */
class MarqueeTextView : TextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, style: Int) : super(context, attrs, style)

    override fun isFocused(): Boolean {
        return true
    }

}