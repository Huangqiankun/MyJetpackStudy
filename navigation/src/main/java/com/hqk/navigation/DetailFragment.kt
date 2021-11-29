package com.hqk.navigation

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.NavController
import androidx.navigation.Navigation


class DetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        var args = arguments
//        var userName: String? = args?.getString("userName")
////        args?.getInt("userName")
//        Log.d("hqk", "userName is $userName")


        val args = HomeFragmentArgs.fromBundle(requireArguments())
        val userName = args.userName
        val age = args.age
        Log.d("hqk", "$userName,$age")


        val button: Button? = view?.findViewById(R.id.button2)
        button?.setOnClickListener {
            val navController = Navigation.findNavController(it)
            navController.navigate(R.id.action_detailFragment_to_homeFragment)
        }
    }

}