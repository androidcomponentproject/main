package com.lhxia.module_marquee

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseActivity
import com.lhxia.middle_core.ktx.gone
import com.lhxia.middle_core.ktx.visible
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.sdk27.coroutines.onTouch

@Route(path = "/marquee/main", name = "目标列表fragment")
class MarqueeMainActivity : BaseActivity() {

    private lateinit var textSizeInput: EditText
    private lateinit var textColorInput: EditText
    private lateinit var textContentInput: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.marquee_activity_main)

        frameLayout {
            verticalLayout {
                textSizeInput = editText{
                    hint = "请输入文本大小"
                }
                textColorInput = editText{
                    hint = "请输入文本颜色"
                }
                textContentInput = editText{
                    hint = "请输入文本内容"
                }
                button {
                    onClick {
                        MarqueeActivity.startActivity(this@MarqueeMainActivity, textContentInput.text, Color.BLUE, textSizeInput.text.toString().toFloatOrNull())
                    }
                }
            }

        }
    }
}
