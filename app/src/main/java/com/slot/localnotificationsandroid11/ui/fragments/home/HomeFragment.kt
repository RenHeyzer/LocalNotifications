package com.slot.localnotificationsandroid11.ui.fragments.home

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.slot.localnotificationsandroid11.databinding.FragmentHomeBinding
import com.slot.localnotificationsandroid11.ui.utils.MyNotificationService
import com.slot.localnotificationsandroid11.ui.utils.NotificationCounter

class HomeFragment : Fragment() {

    private var binding: FragmentHomeBinding? = null
    private var service: MyNotificationService? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        sendNotifications()
    }

    private fun initialize() {
        service = MyNotificationService(requireContext())
    }

    private fun sendNotifications() = binding?.apply {
        btnSendNotification.setOnClickListener {
            val description = etInputNotificationDescription.text.toString().trim()
            requireActivity().sendBroadcast(Intent("SEND_NOTIFICATION").apply {
                putExtra("ID", NotificationCounter.id)
                putExtra("DES", description)
            })
            service?.showNotification(NotificationCounter.id++, description)
        }
    }
}