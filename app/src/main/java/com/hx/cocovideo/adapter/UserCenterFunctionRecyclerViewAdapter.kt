package com.hx.cocovideo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.henry.cocovideo.base.RecyclerOnItemClickListener
import com.henry.cocovideo.bean.UserCenterFunctionItem
import com.hx.cocovideo.R

/**
 * author：heng.zhang
 * date：2018/12/26
 * description：
 */
class UserCenterFunctionRecyclerViewAdapter(var datas : MutableList<UserCenterFunctionItem>) : RecyclerView.Adapter<UserCenterFunctionRecyclerViewAdapter.UserCenterFunctionViewHolder>() {

    private var onclickListener : RecyclerOnItemClickListener<UserCenterFunctionItem>? = null

    fun setOnClickListener(listener : RecyclerOnItemClickListener<UserCenterFunctionItem>) {
        onclickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserCenterFunctionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_user_function_item, parent, false)
        return UserCenterFunctionViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun addVideoItems(dataList: MutableList<UserCenterFunctionItem>) {
        datas.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: UserCenterFunctionViewHolder, position: Int) {
        val function = datas[position]
        holder.functionNameTv.text = function.name
        holder.functionIconIv.setImageResource(function.iconId)
//        Glide.with(holder.itemView.context)
//                .load(function.iconId)
//                .into(holder.functionIconIv)
    }

    class UserCenterFunctionViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val functionNameTv = itemView.findViewById<TextView>(R.id.functionNameTv)
        val functionIconIv = itemView.findViewById<ImageView>(R.id.functionIconIv)
    }
}