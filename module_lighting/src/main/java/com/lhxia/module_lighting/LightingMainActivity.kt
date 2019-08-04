package com.lhxia.module_lighting

import android.hardware.Camera
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import kotlinx.android.synthetic.main.lighting_main_activity.*
import org.jetbrains.anko.cameraManager
import org.jetbrains.anko.textView
import org.jetbrains.anko.toast
import org.jetbrains.anko.verticalLayout

@Route(path = "/lighting/main", name = "目标列表fragment")
class LightingMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.lighting_main_activity)
        verticalLayout {
            textView("我是闪光灯")


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                cameraManager.setTorchMode("0", true)
            }else {
                toast("暂不支持")
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            cameraManager.setTorchMode("0", false)
        }
    }

    fun open(){

//        CameraX.
//        Camera.Parameters parameter = camera.getCamera().getParameters();
//        parameter.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
//        camera.getCamera().setParameters(parameter);
    }
}
