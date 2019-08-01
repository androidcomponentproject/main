package com.lhxia.module_marquee

import android.animation.ValueAnimator
import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.ktx.gone
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
    var textSize: Float = 10f
    var textColor: Int = Color.RED

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        content = intent.getCharSequenceExtra(EXTRA_CONTENT)
        textColor = intent.getIntExtra(EXTRA_TEXT_COLOR, Color.RED)
        textSize = intent.getFloatExtra(EXTRA_TEXT_SIZE, 10f)

        frameLayout {
            backgroundColor = Color.WHITE
            textView(content){
                this.textColor = this@MarqueeActivity.textColor
                this.textSize = this@MarqueeActivity.textSize
                post {
                    startAnimation(makeAnim().apply {
                        start()
                    })
                }
            }.lparams(-2, -2, Gravity.CENTER)

            onClick {
                finish()
            }
        }
    }

    private fun makeAnim(): Animation{
        val animation = TranslateAnimation(0f, 1f, 0.5f, 0.5f)
        animation.duration = 2000
        animation.repeatMode = Animation.INFINITE
        return animation
    }
}
