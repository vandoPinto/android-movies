package br.com.moviestart.flixmovies.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.moviestart.flixmovies.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        changeToLogin()
    }

    private fun changeToLogin() {
        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 5000)
    }

    //

    private fun Intent.change(){
        startActivity(this)
        finish()
    }
}
