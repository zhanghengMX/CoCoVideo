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
import kotlinx.android.synthetic.main.fragment_movie.*

class MovieFragment : Fragment(), MainPageFragmentContract.View {
    override lateinit var presenter: MainPageFragmentContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun refreshCategoryData(data: MutableList<CategoryItem>) {
        clear()
        for (category in data) {
            fragments.add(CategoryCommonFragment.newInstence(category.name))
        }
        viewPagerAdapter = CategoryViewPagerAdapter(childFragmentManager!!, fragments, data)
        movieFragmentViewPager.adapter = viewPagerAdapter
        movieFragmentTabLayout.setupWithViewPager(movieFragmentViewPager)
    }

    private fun clear() {
        movieFragmentTabLayout.removeAllTabs()
        fragments.clear()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = MainPageFragmentPresenter(this)
    }

    private var fragments = mutableListOf<Fragment>()

    private lateinit var viewPagerAdapter : CategoryViewPagerAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        movieFragmentTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("MovieFragment", "onTabReselected")
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("MovieFragment", "onTabUnselected")
            }

            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("MovieFragment", "onTabSelected   ${tab?.text}")
            }

        })
        presenter.requestCategoryData("movie")
    }
}
