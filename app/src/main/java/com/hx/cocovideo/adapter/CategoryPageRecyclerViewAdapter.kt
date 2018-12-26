package com.hx.cocovideo.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.henry.cocovideo.bean.VideoDetail
import com.hx.cocovideo.R

/**
 * author：heng.zhang
 * date：2018/12/26
 * description：
 */
class CategoryPageRecyclerViewAdapter(var datas : MutableList<VideoDetail>) : RecyclerView.Adapter<CategoryPageRecyclerViewAdapter.CategoryPageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_poster_item, parent, false)
        return CategoryPageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun addVideoItems(dataList: MutableList<VideoDetail>) {
        datas.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryPageViewHolder, position: Int) {
        val video = datas[position]
        Glide.with(holder.itemView.context)
                .load(video.images["medium"])
                .into(holder.posterIv)
        holder.videoNameTv.text = video.name
    }

    class CategoryPageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val videoNameTv = itemView.findViewById<TextView>(R.id.videoNameTv)
        val posterIv = itemView.findViewById<ImageView>(R.id.videoPosterIv)
    }
}