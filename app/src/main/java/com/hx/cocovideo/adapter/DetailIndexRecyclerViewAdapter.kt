package com.hx.cocovideo.adapter

import android.icu.text.SelectFormat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.henry.cocovideo.base.RecyclerOnItemClickListener
import com.henry.cocovideo.bean.VideoDetail
import com.henry.cocovideo.bean.VideoUrl
import com.hx.cocovideo.R

/**
 * author：heng.zhang
 * date：2018/12/26
 * description：
 */
class DetailIndexRecyclerViewAdapter(var datas : MutableList<VideoUrl>) : RecyclerView.Adapter<DetailIndexRecyclerViewAdapter.CategoryPageViewHolder>() {

    private var onclickListener : RecyclerOnItemClickListener<VideoUrl>? = null

    private var selectedPosition = 0

    fun setSelectedPosition(position: Int) {
        selectedPosition = position
    }

    fun setOnClickListener(listener : RecyclerOnItemClickListener<VideoUrl>) {
        onclickListener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryPageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_detail_index_item, parent, false)
        return CategoryPageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    fun addVideoItems(dataList: MutableList<VideoUrl>) {
        datas.addAll(dataList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CategoryPageViewHolder, position: Int) {
        val videoUrl = datas[position]
        holder.videoIndexTv.text = videoUrl.index.toString()
        holder.itemView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(itemView: View?) {
                selectedPosition = position
                notifyDataSetChanged()
                onclickListener?.onClick(videoUrl)
            }
        })
        var context = holder.videoIndexTv.context
        if (selectedPosition == position) {
            holder.itemView.background = context.getDrawable(R.drawable.detail_index_selected)
        } else {
            holder.itemView.background = context.getDrawable(R.drawable.detail_index_border)
        }
    }

    class CategoryPageViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val videoIndexTv = itemView.findViewById<TextView>(R.id.videoIndexTv)
    }
}