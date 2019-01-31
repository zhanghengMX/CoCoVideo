package com.henry.cocovideo.bean

import cn.bmob.v3.BmobObject

data class User(val id: String,
                val name: String,
                val telephone: String,
                val password : String,
                val icon: Any) : BmobObject()