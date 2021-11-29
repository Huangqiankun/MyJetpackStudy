package com.hqk.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var button: Button? = view?.findViewById(R.id.button)
        button?.setOnClickListener {

//            var args = Bundle()
//            args.putString("userName","hqk")

            var args = HomeFragmentArgs(userName = "hqk", 18).toBundle()

            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_homeFragment_to_detailFragment, args)
        }
    }

}