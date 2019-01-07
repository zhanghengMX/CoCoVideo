package com.hx.cocovideo.fragment


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.henry.cocovideo.bean.VideoDetail

import com.hx.cocovideo.R
import kotlinx.android.synthetic.main.fragment_detail_page_desc.*

class DetailPageDescFragment : DetailBaseFragment() {

    override fun refreshFragmentData(data: Any) {
        val detail = data as VideoDetail
        var directorNames = ""
        for (director in detail.directors) {
            directorNames += director["director_name"]
            directorNames += " "
        }
        var actorNames = ""
        for (director in detail.casts) {
            actorNames += director["actor_name"]
            actorNames += " "
        }

        detailDirectorTv.text = directorNames
        detailActorTv.text = actorNames
        detailYearTv.text = detail.year
        detailAreaTv.text = replaceBrackets(detail.countries.toString())
        detailTypeTv.text = replaceBrackets(detail.genres.toString())
        detailDescTv.text = detail.summary
    }

    private fun replaceBrackets(data: String): String {
        return data.replace("[","").replace("]","")
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_detail_page_desc, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        detailDescTv.movementMethod = ScrollingMovementMethod.getInstance()
    }
}
