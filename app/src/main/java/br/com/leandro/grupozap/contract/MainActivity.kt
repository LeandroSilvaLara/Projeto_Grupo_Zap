package br.com.leandro.grupozap.contract

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ProgressBar
import br.com.leandro.grupozap.R
import br.com.leandro.grupozap.viewmodel.Interactor

class MainActivity : AppCompatActivity() {

    lateinit var tilVivaReal: ImageButton
    lateinit var tilZap: ImageButton
    lateinit var interactor: Interactor
    lateinit var tilLoading: ProgressBar

    val grupZap = 1
    val vivaReal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_Grupozap)

        setContentView(R.layout.activity_main)

        Configuration.INSTANCE.setCleanArchitecture(this)
    }
}