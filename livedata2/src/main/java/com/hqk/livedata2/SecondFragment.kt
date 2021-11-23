package com.hqk.livedata2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider


class SecondFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_second, container, false)

        var seekBar = rootView.findViewById<SeekBar>(R.id.seekBar)
        val viewModel = ViewModelProvider(
            requireActivity(), ViewModelProvider.AndroidViewModelFactory(
                requireActivity().application
            )
        )[MyViewModel::class.java]

        viewModel.getProgress()!!.observe(requireActivity(), Observer {
            seekBar.progress = it
        })

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                viewModel.getProgress()!!.setValue(progress)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        return rootView
    }


}