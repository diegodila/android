package br.com.fiap.app18

import android.animation.Animator
import android.animation.Animator.AnimatorListener
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import br.com.fiap.app18.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btAnimate.setOnClickListener {
            animate()
        }
    }
    private fun animate(){

        binding.llBox.fadeOut()
        binding.btAnimate.fadeOut()
//        val utils = Utils()
//        utils.fadeOut(binding.llBox)
//        fadeForever(binding.llBox)
//        fadeIn(binding.llBox)
//        fadeOut(binding.btAnimate)
//        binding.llBox.apply {
//            animate()
//                .setDuration(3000)
//                .alpha(0f)
//
////            Timer("timer",false).schedule(4000) {
////                runOnUiThread {
////                    binding.llBox.setBackgroundColor(Color.BLUE)
////                }
////            }
//        }
    }
    private fun fadeForever(view:View){
        if(view.alpha > 0){
            //fade out
            view.apply {
                animate()
                    .setDuration(1500)
                    .alpha(0f)
                    .scaleX(0.3f)
                    .scaleY(0.3f)
                    .rotationBy(360f)
                    .translationYBy(250f)
                    .setListener(object : Animator.AnimatorListener{
                        override fun onAnimationStart(p0: Animator?) {}
                        override fun onAnimationEnd(p0: Animator?) {
                            fadeForever(binding.llBox)
                        }
                        override fun onAnimationCancel(p0: Animator?) {}
                        override fun onAnimationRepeat(p0: Animator?) {}
                    })
            }
        }else {
            //fade In
            view.apply {
                animate()
                    .setDuration(1500)
                    .alpha(1f)
                    .scaleX(1f)
                    .scaleY(1f)
                    .rotationBy(360f)
                    .translationYBy(-200f)
                    .setListener(object : Animator.AnimatorListener{
                        override fun onAnimationStart(p0: Animator?) {}
                        override fun onAnimationEnd(p0: Animator?) {
                            fadeForever(binding.llBox)
                        }
                        override fun onAnimationCancel(p0: Animator?) {}
                        override fun onAnimationRepeat(p0: Animator?) {}
                    })
            }
        }
    }
//    private fun fadeOut(view: View) {
//        view.apply {
//            animate()
//                .setDuration(1500)
//                .alpha(0f)
//
//        }
//    }
//    private fun fadeIn(view: View) {
//        view.apply {
//            animate()
//                .setDuration(1500)
//                .alpha(1f)
//        }
//    }
}