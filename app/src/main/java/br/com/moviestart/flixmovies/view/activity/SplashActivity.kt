package br.com.moviestart.flixmovies.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import br.com.moviestart.flixmovies.R
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        auth = FirebaseAuth.getInstance()

        changeToLogin()
    }

    private fun changeToLogin() {
        val user = FirebaseAuth.getInstance().currentUser

        if (user != null) {
            initMain()
        } else {
            initLogin()
        }
    }

    private fun initMain() {
        val intent = Intent(this, MainActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    private  fun initLogin() {
        val intent = Intent(this, LoginActivity::class.java)

        Handler().postDelayed({
            intent.change()
        }, 2000)
    }

    private fun Intent.change(){
        startActivity(this)
        finish()
    }

    private fun updateUserInfoAndUI() {
        //start next activity
        val intent = Intent(this@SplashActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
