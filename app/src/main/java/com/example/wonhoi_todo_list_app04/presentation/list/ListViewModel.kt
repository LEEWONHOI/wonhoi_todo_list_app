package com.example.wonhoi_todo_list_app04.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.domain.todo.DeleteAllTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.GetTodoListUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.UpdateTodoUseCase
import com.example.wonhoi_todo_list_app04.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

/**
 *  necessary UseCase
 *  1. [GetTodoListUseCase]
 *  2. [UpdateTodoUseCase]
 *  3. [DeleteAllTodoItemUseCase]
 */
internal class ListViewModel(
    private val getTodoListUseCase: GetTodoListUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val deleteAllTodoItemUseCase: DeleteAllTodoItemUseCase

) : BaseViewModel() {

    private val _todoListLiveData = MutableLiveData<TodoListState>(TodoListState.UnInitialized)
    val todoListLiveData: LiveData<TodoListState> = _todoListLiveData

    override fun fetchData(): Job = viewModelScope.launch {
        _todoListLiveData.postValue(TodoListState.Loding)
        _todoListLiveData.postValue(TodoListState.Success(getTodoListUseCase()))
    }

    fun updateEntity(todoEntity: TodoEntity) = viewModelScope.launch {
        updateTodoUseCase(todoEntity)
    }

    fun deleteAll() = viewModelScope.launch {
        _todoListLiveData.postValue(TodoListState.Loding)
        deleteAllTodoItemUseCase()
        _todoListLiveData.postValue(TodoListState.Success(getTodoListUseCase()))
    }

}