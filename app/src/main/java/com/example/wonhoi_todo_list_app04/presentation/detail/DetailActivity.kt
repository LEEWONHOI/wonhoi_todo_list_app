package com.example.wonhoi_todo_list_app04.presentation.detail

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isGone
import com.example.wonhoi_todo_list_app04.R
import com.example.wonhoi_todo_list_app04.databinding.ActivityDetailBinding
import com.example.wonhoi_todo_list_app04.presentation.BaseActivity
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

internal class DetailActivity : BaseActivity<DetailViewModel>() {

    override val viewModel: DetailViewModel by viewModel {
        parametersOf(
            intent.getSerializableExtra(DETAIL_MODE_KEY),
            intent.getLongExtra(TODO_ID_KEY, -1)
        )
    }

    companion object {
        const val TODO_ID_KEY = "ToDoId"
        const val DETAIL_MODE_KEY = "DetailMode"

        const val FETCH_REQUEST_CODE = 100

        // when (Create todoItem)
        fun getIntent(context: Context, detailMode: DetailMode) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(DETAIL_MODE_KEY, detailMode)
            }
        // when (call Detail page for modify)
        fun getIntent(context: Context, id:Long, detailMode: DetailMode) =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(TODO_ID_KEY, id)
                putExtra(DETAIL_MODE_KEY, detailMode)
            }

    }

    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setResult(Activity.RESULT_OK)   // for Refresh
    }

    override fun observeData() = viewModel.todoDetailLiveData.observe(this@DetailActivity) { todoDetailState ->
        when(todoDetailState) {
            is TodoDetailState.UnInitialized -> {
                initViews(binding)
            }
            is  TodoDetailState.Loding -> {
                handleLoadingState()
            }
            is TodoDetailState.Success -> {
                handleSuccessState(todoDetailState)
            }
            is TodoDetailState.Modify -> {
                handleModifyState()
            }
            is TodoDetailState.Delete -> {
                Toast.makeText(this, "Deleted successfully", Toast.LENGTH_SHORT).show()
                finish()
            }
            is TodoDetailState.Error -> {
                Toast.makeText(this, "An error has occurred", Toast.LENGTH_SHORT).show()
                finish()
            }
            is TodoDetailState.Write -> {
                handleWriteState()
            }
        }
    }

    private fun initViews(binding: ActivityDetailBinding) = with(binding) {
        titleInput.isEnabled = false
        descriptionInput.isEnabled = false

        deleteButton.isGone = true
        modifyButton.isGone = true
        updateButton.isGone = true

        deleteButton.setOnClickListener {
            viewModel.deleteTodoItem()
        }
        modifyButton.setOnClickListener {
            viewModel.setModifyMode()
        }
        updateButton.setOnClickListener {
            viewModel.writeTodo(
                title = titleInput.text.toString(),
                description = descriptionInput.text.toString()
            )
        }
    }

    private fun handleLoadingState() = with(binding) {
        progressBar.isGone = false
    }

    private fun handleModifyState() = with(binding) {
        titleInput.isEnabled = true
        descriptionInput.isEnabled = true

        deleteButton.isGone = true
        modifyButton.isGone = true
        updateButton.isGone = false
    }

    private fun handleWriteState() = with(binding) {
        titleInput.isEnabled = true
        descriptionInput.isEnabled = true

        updateButton.isGone = false
    }

    private fun handleSuccessState(state : TodoDetailState.Success) = with(binding) {
        progressBar.isGone = true

        titleInput.isEnabled = false
        descriptionInput.isEnabled = false

        deleteButton.isGone = false
        modifyButton.isGone = false
        updateButton.isGone = true

        val todoItem = state.todoItem
        titleInput.setText(todoItem.title)
        descriptionInput.setText(todoItem.description)

    }

}