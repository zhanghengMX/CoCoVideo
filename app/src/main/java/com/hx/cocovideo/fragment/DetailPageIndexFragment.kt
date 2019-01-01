package com.hx.cocovideo.fragment

import android.os.Bundle
import android.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henry.cocovideo.base.RecyclerOnItemClickListener
import com.henry.cocovideo.bean.VideoUrl

import com.hx.cocovideo.R
import com.hx.cocovideo.activity.VideoDetailActivity
import com.hx.cocovideo.adapter.DetailIndexRecyclerViewAdapter
import kotlinx.android.synthetic.main.fragment_detailpage_index.*

class DetailPageIndexFragment : DetailBaseFragment() {
    private lateinit var recyclerAdapter: DetailIndexRecyclerViewAdapter

    override fun refreshFragmentData(data: Any) {
        val urls = data as MutableList<VideoUrl>
        recyclerAdapter.addVideoItems(urls)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detailpage_index, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerAdapter = DetailIndexRecyclerViewAdapter(mutableListOf())
        detailIndexRecyclerView.layoutManager = GridLayoutManager(activity, 4)
        detailIndexRecyclerView.adapter = recyclerAdapter
        recyclerAdapter.setOnClickListener(object : RecyclerOnItemClickListener<VideoUrl> {
            override fun onClick(t: VideoUrl) {
                var m3u8Url = ""
                for (url in t.urls) {
                    if (url.endsWith("m3u8")) {
                        m3u8Url = url
                        break
                    }
                }
                videoDetailActivity.doPlay(t.name, m3u8Url)
            }

        })
        val videoUrls = videoDetailActivity.presenter.getLocalVideoUrls()
        refreshFragmentData(videoUrls)
    }
}
