package br.com.leandro.grupozap.contract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.leandro.grupozap.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_Grupozap)

        setContentView(R.layout.activity_main)
    }
}