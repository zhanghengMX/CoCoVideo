package com.hx.cocovideo.fragment

import android.app.Fragment

abstract class DetailBaseFragment : Fragment() {
    abstract fun refreshFragmentData(data: Any)
}
