package com.hx.cocovideo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henry.cocovideo.bean.VideoDetail

import com.hx.cocovideo.R
import com.hx.cocovideo.adapter.CategoryPageRecyclerViewAdapter
import com.hx.cocovideo.contract.CategoryPageContentContract
import com.hx.cocovideo.presenter.CategoryPagePresenter
import kotlinx.android.synthetic.main.fragment_category_common.*

class CategoryCommonFragment : Fragment(), CategoryPageContentContract.View {

    override lateinit var presenter: CategoryPageContentContract.Presenter

    private lateinit var recyclerAdapter: CategoryPageRecyclerViewAdapter

    private lateinit var title: String

    companion object {
        fun newInstence(title : String): CategoryCommonFragment {
            val fragment = CategoryCommonFragment()
            fragment.title = title
            return fragment
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = CategoryPagePresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_category_common, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = CategoryPageRecyclerViewAdapter(mutableListOf())
        categoryPageRecyclerView.layoutManager = GridLayoutManager(activity, 2)
        categoryPageRecyclerView.adapter = recyclerAdapter
    }

    override fun refreshPageContent(data: MutableList<VideoDetail>) {
        recyclerAdapter.addVideoItems(data)
    }

    override fun onResume() {
        super.onResume()
        presenter.requestVideoByCategoryName(title)
    }
}
