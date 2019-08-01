package com.lhxia.module_marquee

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.lhxia.middle_core.app.BaseActivity

@Route(path = "/marquee/main", name = "目标列表fragment")
class MarqueeMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.marquee_activity_main)
    }
}
