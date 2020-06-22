package com.example.daneshjoyarshop.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import com.example.daneshjoyarshop.modle.ModleMainActivity
import com.example.daneshjoyarshop.presenter.PresenterMainActivity
import com.example.daneshjoyarshop.R
import com.example.daneshjoyarshop.view.ViewMainActivity
import com.example.daneshjoyarshop.etc.Utitlity
import com.example.daneshjoyarshop.etc.setFragment
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity(), setFragment, Utitlity {

    private lateinit var presenter: PresenterMainActivity
    private val modle: ModleMainActivity by inject()
    private lateinit var mainView : ViewMainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainView = ViewMainActivity(this, this , this)

        setContentView(mainView)

        presenter = PresenterMainActivity(mainView, modle)
        presenter.OnCreate()
    }

    override fun onCreatePopUpMenu(view: View) {
        val popUpMenu = PopupMenu(this, view)
        popUpMenu
            .menuInflater
            .inflate(R.menu.main_manu, popUpMenu.menu)
        popUpMenu.setOnMenuItemClickListener(mainView)
        popUpMenu.show()
    }

    override fun addFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout_main, fragment)
            .commit()
    }

    override fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame_layout_main, fragment)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        //presenter.OnDestroyd()
    }



}
