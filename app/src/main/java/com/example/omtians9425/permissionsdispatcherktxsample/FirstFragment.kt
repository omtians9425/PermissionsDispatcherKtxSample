package com.example.omtians9425.permissionsdispatcherktxsample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.google.android.material.button.MaterialButton

class FirstFragment : Fragment(R.layout.fragment_first) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<MaterialButton>(R.id.button).setOnClickListener {
            parentFragmentManager.commit {
                addToBackStack(null)
                replace(R.id.fragmentContainer, SecondFragment())
            }
        }
    }
}