package br.com.fiap.nacandroid.utils

import android.animation.Animator
import android.view.View

fun View.fadeOut(setDuration: Int) {
    if (this.alpha > 0) {
        this.apply {
            animate()
                .setDuration(setDuration.toLong())
                .alpha(0f)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator?) {}
                    override fun onAnimationEnd(p0: Animator?) {
                        this@fadeOut
                    }
                    override fun onAnimationCancel(p0: Animator?) {}
                    override fun onAnimationRepeat(p0: Animator?) {}

                })
        }
    } else {
        this.apply {
            animate()
                .setDuration(1000)
                .alpha(1f)
                .setListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(p0: Animator?) {}
                    override fun onAnimationEnd(p0: Animator?) {
                        this@fadeOut
                    }
                    override fun onAnimationCancel(p0: Animator?) {}
                    override fun onAnimationRepeat(p0: Animator?) {}

                })
        }
    }
}
fun String.getData(): String {
    val firstData = this.substring(0, 10)
    return firstData
}