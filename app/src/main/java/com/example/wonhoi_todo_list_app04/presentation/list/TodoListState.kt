package com.example.wonhoi_todo_list_app04.presentation.list

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity

sealed class TodoListState {

    object UnInitialized : TodoListState()

    object Loding : TodoListState()

    data class Success(
        val toDoList: List<TodoEntity>
    ) : TodoListState()

    object Error: TodoListState()

}