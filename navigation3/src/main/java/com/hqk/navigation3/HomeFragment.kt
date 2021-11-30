package com.hqk.navigation3

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation


class HomeFragment : Fragment() {

    private var notificationId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val button: Button? = view?.findViewById(R.id.button)
        button?.setOnClickListener {
            sendNotification()
        }
    }

    private fun sendNotification() {
        //通知渠道
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                requireActivity().packageName,
                "MyChannel",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = "My NotificationChannel"
            val notificationManager = requireActivity().getSystemService(
                NotificationManager::class.java
            )
            notificationManager.createNotificationChannel(channel)
        }

        val notification = NotificationCompat.Builder(
            requireActivity(), requireActivity().packageName
        )
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Deep Link")
            .setContentText("点击我试试...")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(getPendingIntent())
            .build()
        val notificationManagerCompat = NotificationManagerCompat.from(
            requireActivity()
        )

        notificationManagerCompat.notify(notificationId++, notification)
    }

    private fun getPendingIntent(): PendingIntent {
        val args = Bundle()
        args.putString("name", "hqk")
        return Navigation.findNavController(requireActivity(), R.id.button)
            .createDeepLink()
            .setGraph(R.navigation.my_nav_graph)
            .setDestination(R.id.detailFragment)
            .setArguments(args)
            .createPendingIntent()
    }


}