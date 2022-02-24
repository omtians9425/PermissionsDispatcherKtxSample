package com.example.omtians9425.permissionsdispatcherktxsample

import android.Manifest
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import permissions.dispatcher.ktx.PermissionsRequester
import permissions.dispatcher.ktx.constructPermissionsRequest

class SecondFragment : Fragment(R.layout.fragment_second) {

    private lateinit var permissionsRequester: PermissionsRequester

    override fun onAttach(context: Context) {
        super.onAttach(context)

        permissionsRequester = constructPermissionsRequest(
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            onShowRationale = null,
            onNeverAskAgain = null,
            onPermissionDenied = { Toast.makeText(requireContext(), "Denied.", Toast.LENGTH_SHORT).show() },
            requiresPermission = { Toast.makeText(requireContext(), "Granted.", Toast.LENGTH_SHORT).show() },
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireView().findViewById<MaterialButton>(R.id.button).setOnClickListener {
            permissionsRequester.launch()
        }
    }
}