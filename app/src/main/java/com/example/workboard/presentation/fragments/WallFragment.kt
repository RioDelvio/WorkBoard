package com.example.workboard.presentation.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.workboard.R
import com.example.workboard.presentation.viewmodels.WallViewModel

class WallFragment : Fragment() {

    companion object {
        fun newInstance() = WallFragment()
    }

    private lateinit var viewModel: WallViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_wall, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(WallViewModel::class.java)
        // TODO: Use the ViewModel
    }

}