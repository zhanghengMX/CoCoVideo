package com.hx.cocovideo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.henry.cocovideo.bean.CategoryItem

/**
 * Copyright (c) 2018, 北京视达科科技有限责任公司 All rights reserved.
 * author：heng.zhang
 * date：2018/12/24
 * description：
 */
open class CategoryViewPagerAdapter(fm: FragmentManager, private val fragmrntList : MutableList<Fragment>) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
        return fragmrntList[position]
    }

    override fun getCount(): Int {
        return fragmrntList.size
    }

    fun addCatrgorys(list : MutableList<Fragment>) {
        fragmrntList.addAll(list)
        notifyDataSetChanged()
    }
}