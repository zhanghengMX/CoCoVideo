package com.hx.cocovideo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
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
        for (category in data) {
            fragments.add(CategoryCommonFragment())
            tvFragmentTabLayout.addTab(tvFragmentTabLayout.newTab())
        }
        viewPagerAdapter = CategoryViewPagerAdapter(fragmentManager!!, fragments)
        tvFragmentViewPager.adapter = viewPagerAdapter
        tvFragmentTabLayout.setupWithViewPager(tvFragmentViewPager)
        for (category in data) {
            val index = data.indexOf(category)
            tvFragmentTabLayout.getTabAt(index)?.text = category.name
        }
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

        presenter.requestCategoryData("tv")
    }
}
