package com.hx.cocovideo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MainPageViewPagerAdapter(fm: FragmentManager, private val fragmrntList : MutableList<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
       return fragmrntList.size
    }

    override fun getItem(position: Int): Fragment {
        return fragmrntList[position]
    }
}