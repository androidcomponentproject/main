package com.lhxia.module_marquee

import android.animation.Animator
import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.text.SpannableStringBuilder
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.TranslateAnimation
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.marginLeft
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.ktx.gone
import com.lhxia.middle_core.ktx.launch
import com.lhxia.middle_core.ktx.visible
import kotlinx.coroutines.delay
import kotlinx.coroutines.yield
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick

class MarqueeActivity : BaseActivity() {

    companion object {
        const val EXTRA_CONTENT = "extra_content"
        const val EXTRA_TEXT_COLOR = "extra_text_color"
        const val EXTRA_TEXT_SIZE = "extra_text_size"

        fun startActivity(activity: BaseActivity, content: CharSequence, textColor: Int? = null, textSize: Float? = null){
            activity.startActivity<MarqueeActivity>(
                EXTRA_CONTENT to content,
                EXTRA_TEXT_COLOR to textColor,
                EXTRA_TEXT_SIZE to textSize
            )
        }
    }


    lateinit var content: CharSequence
    lateinit var marqueeView: LinearLayout
    lateinit var marqueeContainer: HorizontalScrollView
    var textSize: Float = 10f
    var textColor: Int = Color.RED

    var animation1: ValueAnimator? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        content = intent.getCharSequenceExtra(EXTRA_CONTENT)
        textColor = intent.getIntExtra(EXTRA_TEXT_COLOR, Color.RED)
        textSize = intent.getFloatExtra(EXTRA_TEXT_SIZE, 30f)
        marqueeContainer = horizontalScrollView {
            isHorizontalScrollBarEnabled = false
            isScrollContainer = false
            isFillViewport = true
            backgroundColor = Color.WHITE

            marqueeView = linearLayout {
                orientation = LinearLayout.HORIZONTAL
                gravity = Gravity.CENTER_VERTICAL
                textView("$content"){

                    this.textColor = this@MarqueeActivity.textColor
                    this.textSize = this@MarqueeActivity.textSize
                }.lparams(-2, -2)
                onClick {
                    finish()
                }
            }.lparams(-1, -1)


        }
        launch {
            yield()
            makeAnim()
        }
    }

    private fun makeAnim(){
        animation1 = ValueAnimator.ofInt(marqueeContainer.measuredWidth, -marqueeView.measuredWidth)
//        animation2 = ValueAnimator.ofInt(marqueeContainer.measuredWidth + marqueeTextView1.measuredWidth + 300, -marqueeTextView1.measuredWidth  + marqueeTextView1.measuredWidth)

        animation1?.duration = 5000
        animation1?.repeatCount = ValueAnimator.INFINITE
        animation1?.repeatMode = ValueAnimator.RESTART
        animation1?.addUpdateListener {
            marqueeView.translationX = it.animatedValue.toString().toFloat()
        }
        animation1?.interpolator = LinearInterpolator()
        animation1?.start()

//        marqueeTextView2.translationX = marqueeContainer.measuredWidth.toFloat()
//        animation2?.duration = 5000
//        animation2?.repeatCount = ValueAnimator.INFINITE
//        animation2?.repeatMode = ValueAnimator.RESTART
//        animation2?.addUpdateListener {
//            marqueeTextView2.translationX = it.animatedValue.toString().toFloat()
//        }
//        animation2?.interpolator = LinearInterpolator()
//        animation2?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        animation1?.cancel()
    }

}
