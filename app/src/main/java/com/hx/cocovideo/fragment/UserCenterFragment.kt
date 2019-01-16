package com.hx.cocovideo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henry.cocovideo.base.RecyclerOnItemClickListener
import com.henry.cocovideo.bean.UserCenterFunctionItem

import com.hx.cocovideo.R
import com.hx.cocovideo.adapter.UserCenterFunctionRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_user_center.*

class UserCenterFragment : Fragment() {

    private lateinit var recyclerAdapter: UserCenterFunctionRecyclerViewAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_user_center, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val functionList = mutableListOf<UserCenterFunctionItem>()
        functionList.add(UserCenterFunctionItem("收藏记录", R.mipmap.user_center_collection, UserCenterFunctionItem.UserFunctionAction.OPEN_COLLECTOPN_PAGE))
        functionList.add(UserCenterFunctionItem("播放历史", R.mipmap.user_center_history, UserCenterFunctionItem.UserFunctionAction.OPEN_PLAY_HISTORY_PAGE))
        recyclerAdapter = UserCenterFunctionRecyclerViewAdapter(functionList)
        val divider = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        divider.setDrawable(activity?.getDrawable(R.drawable.user_center_custom_divider)!!)
        userCenteRecyclerView.addItemDecoration(divider)
        userCenteRecyclerView.layoutManager = LinearLayoutManager(activity)
        userCenteRecyclerView.adapter = recyclerAdapter
        recyclerAdapter.setOnClickListener(object : RecyclerOnItemClickListener<UserCenterFunctionItem> {
            override fun onClick(t: UserCenterFunctionItem) {
            }
        })
    }
}
