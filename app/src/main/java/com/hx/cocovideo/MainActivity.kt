package com.hx.cocovideo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.MenuItem
import com.hx.cocovideo.adapter.MainPageViewPagerAdapter
import com.hx.cocovideo.fragment.MovieFragment
import com.hx.cocovideo.fragment.TVFragment
import com.hx.cocovideo.fragment.UserCenterFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var fragmentList: MutableList<Fragment>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        fragmentList = mutableListOf()
        fragmentList.add(TVFragment())
        fragmentList.add(MovieFragment())
        fragmentList.add(UserCenterFragment())
        mainActivityViewPager.adapter = MainPageViewPagerAdapter(supportFragmentManager, fragmentList)
        mainActivityViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                mainBottomNavigationView.menu.getItem(position).isChecked = true
            }

        })
        mainBottomNavigationView.setOnNavigationItemSelectedListener(object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.tvBottomTab -> mainActivityViewPager.currentItem = 0
                    R.id.movieBottomTab -> mainActivityViewPager.currentItem = 1
                    R.id.userCenterBottomTab -> mainActivityViewPager.currentItem = 2
                }
                return false
            }

        })
    }
}
