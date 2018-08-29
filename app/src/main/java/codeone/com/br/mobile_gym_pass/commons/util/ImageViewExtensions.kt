package codeone.com.br.mobile_gym_pass.commons.util

import android.graphics.Color
import android.widget.ImageView

fun ImageView.setColorHex(colorStr: String) {
    setColorFilter(Color.rgb(Integer.valueOf(colorStr.substring(1, 3), 16),
            Integer.valueOf(colorStr.substring(3, 5), 16),
            Integer.valueOf(colorStr.substring(5, 7), 16)))
}