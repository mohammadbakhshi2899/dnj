package com.example.daneshjoyarshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daneshjoyarshop.modle.ModleArchiveActivity
import com.example.daneshjoyarshop.presenter.PresenterArchiveActivity
import com.example.daneshjoyarshop.view.ViewArchiveActivity
import com.example.daneshjoyarshop.etc.Utitlity

class ArchiveActivity : AppCompatActivity() , Utitlity {

    private lateinit var modle : ModleArchiveActivity
    private lateinit var  presenter : PresenterArchiveActivity
    private lateinit var  view : ViewArchiveActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        view = ViewArchiveActivity(this , this)
        modle = ModleArchiveActivity(this)
        presenter = PresenterArchiveActivity(view , modle)
        setContentView(view)
        presenter.OnCreate()
    }

    override fun onFinish() {
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        //presenter.OnDestroyd()
    }
}
