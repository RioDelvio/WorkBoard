package com.example.workboard.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.workboard.databinding.FragmentCreateTaskBinding
import com.example.workboard.domain.entities.Task
import com.example.workboard.presentation.WorkBoardApp
import com.example.workboard.presentation.viewmodels.CreateTaskViewModel
import com.example.workboard.presentation.viewmodels.ViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class CreateTaskFragment : Fragment() {

    private val args by navArgs<CreateTaskFragmentArgs>()


    private val component by lazy {
        (requireActivity().application as WorkBoardApp).component
    }

    private lateinit var viewModel: CreateTaskViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentCreateTaskBinding? = null
    private val binding: FragmentCreateTaskBinding
        get() = _binding ?: throw RuntimeException("FragmentCreateTaskBinding is null")

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        screenModeStart()

    }

    private fun screenModeStart() {
        viewModel = ViewModelProvider(this, viewModelFactory)[CreateTaskViewModel::class.java]
        viewModel.task.observe(viewLifecycleOwner){
            binding.editTextTask.setText(it.title)
        }
        val screenMode = args.taskId
        binding.floatingActionButtonAddTask.setOnClickListener {
            val text = binding.editTextTask.text
            if (text.isEmpty()) {
                Toast.makeText(requireContext(), "Введите текст", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.addTask(Task(title = text.toString()))
                findNavController().popBackStack()
            }

        }
        if (screenMode != ADD_SCREEN_MODE) {
            viewModel.getTask(screenMode)
        }


    }


    companion object {
        private const val ADD_SCREEN_MODE = 0
    }

}