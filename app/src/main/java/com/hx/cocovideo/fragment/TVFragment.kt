package com.hx.cocovideo.fragment


import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henry.cocovideo.bean.CategoryItem

import com.hx.cocovideo.R
import com.hx.cocovideo.adapter.CategoryViewPagerAdapter
import com.hx.cocovideo.contract.MainPageFragmentContract
import com.hx.cocovideo.presenter.MainPageFragmentPresenter
import kotlinx.android.synthetic.main.fragment_tv.*

class TVFragment : Fragment(), MainPageFragmentContract.View {
    override lateinit var presenter: MainPageFragmentContract.Presenter

    override fun refreshCategoryData(data: MutableList<CategoryItem>) {
        clear()
        for (category in data) {
            fragments.add(CategoryCommonFragment())
        }
        viewPagerAdapter = CategoryViewPagerAdapter(fragmentManager!!, fragments, data)
        tvFragmentViewPager.adapter = viewPagerAdapter
        tvFragmentTabLayout.setupWithViewPager(tvFragmentViewPager)
    }

    private fun clear() {
        tvFragmentTabLayout.removeAllTabs()
        fragments.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPageFragmentPresenter(this)
    }

    /**
     * UI测试数据
     */
    private var fragments = mutableListOf<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tv, container, false)
    }

    private lateinit var viewPagerAdapter : CategoryViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvFragmentTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TVFragment", "onTabReselected")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("TVFragment", "onTabUnselected")
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                presenter.requestVideoByCategoryName(tab?.text as String)
                Log.d("TVFragment", "onTabSelected   ${tab?.text}")
            }

        })

        presenter.requestCategoryData("tv")
    }
}
