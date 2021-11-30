package com.hqk.navigation2

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //这句代码和下面onCreateOptionsMenu相互对应，当为true时，将会调用onCreateOptionsMenu方法
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //当加载这个Fragment时，对应菜单消失
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }
}