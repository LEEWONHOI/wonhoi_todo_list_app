package com.example.wonhoi_todo_list_app04.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.wonhoi_todo_list_app04.R
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.databinding.ViewholderTodoItemBinding

class TodoAdapter : RecyclerView.Adapter<TodoAdapter.TodoItemViewHolder>() {

    private var todoList: List<TodoEntity> = listOf()
    private lateinit var todoItemClickListener : (TodoEntity) -> Unit
    private lateinit var todoCheckListener: (TodoEntity) -> Unit

    inner class TodoItemViewHolder(
        val binding: ViewholderTodoItemBinding,
        val todoItemClickListener: (TodoEntity) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: TodoEntity) = with(binding) {
            checkBox.text = data.title
            checkTodoComplete(data.hasCompleted)
        }

        fun bindViews(data: TodoEntity) {
            binding.checkBox.setOnClickListener {
                todoCheckListener(
                    data.copy(hasCompleted = binding.checkBox.isChecked)    // true
                )
                checkTodoComplete(binding.checkBox.isChecked)   // true
            }
            binding.root.setOnClickListener {
                todoItemClickListener(data)
            }
        }

        private fun checkTodoComplete(isChecked: Boolean) = with(binding) {
            checkBox.isChecked = isChecked  // first value is false
            container.setBackgroundColor(
                ContextCompat.getColor(
                    root.context,
                    if (isChecked) {
                        R.color.gray_300
                    } else {
                        R.color.white
                    }
                )
            )
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoItemViewHolder {
        val view =
            ViewholderTodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TodoItemViewHolder(view, todoItemClickListener)
    }

    override fun onBindViewHolder(holder: TodoItemViewHolder, position: Int) {
        holder.bindData(todoList[position])
        holder.bindViews(todoList[position])
    }

    override fun getItemCount(): Int = todoList.size

    fun setTodoList(
        todoList : List<TodoEntity>,
        todoItemClickListener: (TodoEntity) -> Unit,
        todoCheckListener: (TodoEntity) -> Unit
    ) {
        this.todoList = todoList
        this.todoItemClickListener = todoItemClickListener
        this.todoCheckListener = todoCheckListener
        notifyDataSetChanged()
    }

}
