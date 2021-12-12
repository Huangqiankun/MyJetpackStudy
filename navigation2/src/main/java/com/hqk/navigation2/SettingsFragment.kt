package com.hqk.navigation2

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hqk.navigation2.viewmodel.SettingsFragmentViewModel
import java.lang.String


class SettingsFragment : Fragment() {

    private var viewModel: SettingsFragmentViewModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //这句代码和下面onCreateOptionsMenu相互对应，当为true时，将会调用onCreateOptionsMenu方法
        setHasOptionsMenu(true)
        Log.d("hqk", "SettingsFragment   onCreateView")
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        val textView: TextView = view.findViewById(R.id.textView)

        viewModel = ViewModelProvider(this)[SettingsFragmentViewModel::class.java]

        viewModel!!.getLinkNumber()!!.observe(requireActivity(), Observer {
            textView.text = String.valueOf(it)
        })

        view.findViewById<ImageView>(R.id.imageView).setOnClickListener {
            viewModel!!.addLinkedNumber(1)
        }

        view.findViewById<ImageView>(R.id.imageView2).setOnClickListener {
            viewModel!!.addLinkedNumber(-1)
        }

        return view


    }

//    fun reduce(view: View) {
//        viewModel!!.addLinkedNumber(-1)
//    }
//
//    fun add(view: View) {
//        viewModel!!.addLinkedNumber(1)
//    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        //当加载这个Fragment时，对应菜单消失
        menu.clear()
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("hqk", "SettingsFragment   onViewCreated")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("hqk", "SettingsFragment   onCreate")
    }

}