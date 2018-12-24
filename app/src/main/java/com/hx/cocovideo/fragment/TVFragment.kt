package com.hx.cocovideo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.hx.cocovideo.R
import kotlinx.android.synthetic.main.fragment_tv.*

class TVFragment : Fragment() {
    /**
     * UI测试数据
     */
    private val tabList = mutableListOf("栏目01","栏目02","栏目03","栏目04","栏目05","栏目06")
    private var fragments = mutableListOf<Fragment>()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        for (tab in tabList) {
            tvFragmentTabLayout.addTab(tvFragmentTabLayout.newTab().setText(tab))
            fragments.add(CategoryCommonFragment())
        }
        tvFragmentViewPager
    }
}
