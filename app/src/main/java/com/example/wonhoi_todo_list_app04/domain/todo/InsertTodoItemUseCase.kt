package com.example.wonhoi_todo_list_app04.domain.todo

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.data.repository.TodoRepository
import com.example.wonhoi_todo_list_app04.domain.Usecase

internal class InsertTodoItemUseCase(
    private val todoRepository: TodoRepository
)  : Usecase{

    suspend operator fun invoke(todoItem : TodoEntity) : Long {
        return todoRepository.insertTodoItem(todoItem)
    }

}