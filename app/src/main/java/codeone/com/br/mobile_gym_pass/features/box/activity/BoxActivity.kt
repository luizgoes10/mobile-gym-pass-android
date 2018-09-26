package codeone.com.br.mobile_gym_pass.features.box.activity

import android.os.Bundle
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.activity.BaseActivity
import codeone.com.br.mobile_gym_pass.commons.util.setupToolbar
import codeone.com.br.mobile_gym_pass.features.box.domain.Box

class BoxActivity : BaseActivity() {

    private lateinit var box: Box

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_box)
        box = intent.getParcelableExtra<Box>("box")
        setupToolbar(R.id.myToolbar, box.nmBox, true)
    }
}
