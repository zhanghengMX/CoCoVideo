package com.henry.cocovideo.bean

import cn.bmob.v3.BmobObject

data class UserCenterFunctionItem(val name: String,
                                  val iconId: Int,
                                  val action: UserFunctionAction) : BmobObject() {
    enum class UserFunctionAction {
        OPEN_COLLECTOPN_PAGE, OPEN_PLAY_HISTORY_PAGE
    }
}