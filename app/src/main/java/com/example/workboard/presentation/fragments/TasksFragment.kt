package com.example.workboard.presentation.fragments

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.DialogInterface.OnClickListener
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.workboard.R
import com.example.workboard.databinding.FragmentTasksBinding
import com.example.workboard.presentation.WorkBoardApp
import com.example.workboard.presentation.recyclerviews.TasksListAdapter
import com.example.workboard.presentation.viewmodels.TasksViewModel
import com.example.workboard.presentation.viewmodels.ViewModelFactory
import javax.inject.Inject

class TasksFragment : Fragment() {


    private lateinit var viewModel: TasksViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    private var _binding: FragmentTasksBinding? = null
    private val binding: FragmentTasksBinding
        get() = _binding ?: throw RuntimeException("FragmentTasksBinding is null")

    private val component by lazy {
        (requireActivity().application as WorkBoardApp).component
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        component.inject(this)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTasksBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this, viewModelFactory)[TasksViewModel::class.java]
        val listAdapter = TasksListAdapter()
        binding.tasksRecyclerView.adapter = listAdapter
        with(listAdapter) {
            viewModel.getTaskList.observe(viewLifecycleOwner) {
                submitList(it)
            }
            onChangeCompletedStatus = {
                viewModel.changeCompleteState(it)
            }
            onLongTaskClickListener = {
                createDialog(it.id)
            }
            onTaskClickListener= {
               findNavController().navigate(
                   TasksFragmentDirections.actionTasksFragmentToCreateTaskFragment(it.id)
               )
            }
        }
        binding.floatingActionButtonNewTask.setOnClickListener {
            findNavController().navigate(
                TasksFragmentDirections.actionTasksFragmentToCreateTaskFragment()
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun createDialog(taskId: Int) {
        AlertDialog.Builder(this.context)
            .setTitle(R.string.dialog_title)
            .setMessage(R.string.dialog_message)
            .setPositiveButton(R.string.dialog_delete) { _, _ -> viewModel.deleteTask(taskId) }
            .setNegativeButton(R.string.dialog_abort,
                OnClickListener { _, _ -> return@OnClickListener })
            .create().show()
    }

}