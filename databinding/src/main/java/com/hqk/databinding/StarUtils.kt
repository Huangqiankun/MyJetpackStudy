package com.hqk.databinding

open class StarUtils {

    companion object {

        @JvmStatic
        fun getStar(star: Int): String? {
            when (star) {
                1 -> return "一星"
                2 -> return "二星"
                3 -> return "三星"
                4 -> return "四星"
                5 -> return "五星"
            }
            return ""
        }
    }



}