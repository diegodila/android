package br.com.fiap.app18

import android.view.View

fun View.fadeOut() {
        this.apply {
            animate()
                .setDuration(1500)
                .alpha(0f)

        }
}

fun View.fadeIn() {
        this.apply {
            animate()
                .setDuration(1500)
                .alpha(1f)
        }
}
fun String.getData():String {
    val firstData = this.substring(1,5)
    return firstData
}