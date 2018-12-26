package com.hx.cocovideo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.util.DisplayMetrics
import android.util.Log
import android.view.MenuItem
import android.view.WindowManager
import com.henry.cocovideo.bean.CategoryItem
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
//        bmobTestFun()
        getAndroiodScreenProperty()
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

    fun getAndroiodScreenProperty() {
        val wm = getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val dm = DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        val width = dm.widthPixels // 屏幕宽度（像素）
        val height = dm.heightPixels // 屏幕高度（像素）
        val density = dm.density //屏幕密度（0.75 / 1.0 / 1.5）
        val densityDpi = dm.densityDpi //屏幕密度dpi（120 / 160 / 240）
        //屏幕宽度算法:屏幕宽度（像素）/屏幕密度
        val screenWidth =(width/density) //屏幕宽度(dp)
        val screenHeight =(height/density) //屏幕高度(dp)
        Log.e("MainActivity", "$screenWidth======$screenHeight")
    }

    fun bmobTestFun() {
        CategoryItem("动作","movie").save()
        CategoryItem("喜剧","movie").save()
        CategoryItem("犯罪","movie").save()
        CategoryItem("战争","movie").save()
        CategoryItem("动画","movie").save()
        CategoryItem("爱情","movie").save()
        CategoryItem("科幻","movie").save()
        CategoryItem("悬疑","movie").save()
        CategoryItem("恐怖","movie").save()
        CategoryItem("冒险","movie").save()
        CategoryItem("剧情","movie").save()
        CategoryItem("喜剧","tv").save()
        CategoryItem("爱情","tv").save()
    }
}
