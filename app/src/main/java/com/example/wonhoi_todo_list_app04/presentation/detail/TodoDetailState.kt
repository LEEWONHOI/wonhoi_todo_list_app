package com.example.wonhoi_todo_list_app04.presentation.detail

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity

sealed class TodoDetailState {

    object UnInitialized : TodoDetailState()

    object Loding : TodoDetailState()

    data class Success(
        val todoItem : TodoEntity
    ) : TodoDetailState()

    object Delete : TodoDetailState()

    object Modify : TodoDetailState()

    object Error : TodoDetailState()

    object Write : TodoDetailState()

}