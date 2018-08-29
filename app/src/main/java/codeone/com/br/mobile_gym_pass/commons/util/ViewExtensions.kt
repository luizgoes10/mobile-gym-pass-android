package codeone.com.br.mobile_gym_pass.commons.util

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.Animation

fun View.animatedVisibilit(visibility: Int, duration: Long = 300) {
    if (visibility != this.visibility) {
        animate()
                .translationY(if (visibility == View.VISIBLE) 0.0f else height.toFloat())
                .alpha(if (visibility == View.VISIBLE) 1.0f else 0.0f)
                .setDuration(duration)
                .setListener(object : AnimatorListenerAdapter() {
                    override fun onAnimationEnd(animation: Animator) {
                        super.onAnimationEnd(animation)
                        setVisibility(visibility)
                    }
                })
    }
}

fun View.animatedVisibilitAlpha(duration: Long = 500, animationListener: Animation.AnimationListener) {
    val animation1 = AlphaAnimation(0.0f, 1.0f)
    animation1.duration = duration
    animation1.fillAfter = true
    animation1.setAnimationListener(animationListener)
    this.startAnimation(animation1)
}