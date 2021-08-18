package com.example.wonhoi_todo_list_app04.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.domain.todo.DeleteTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.GetTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.InsertTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.UpdateTodoUseCase
import com.example.wonhoi_todo_list_app04.presentation.BaseViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.lang.Exception

internal class DetailViewModel(
    var detailMode: DetailMode,
    var id: Long = -1,
    private val getTodoItemUseCase: GetTodoItemUseCase,
    private val deleteTodoItemUseCase: DeleteTodoItemUseCase,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val insertTodoItemUseCase: InsertTodoItemUseCase
) : BaseViewModel() {

    private var _todoDetailLiveData =
        MutableLiveData<TodoDetailState>(TodoDetailState.UnInitialized)
    val todoDetailLiveData: LiveData<TodoDetailState> = _todoDetailLiveData

    // todo 기능 체크
    override fun fetchData(): Job = viewModelScope.launch {
        when (detailMode) {
            DetailMode.WRITE -> { //  WriteMode at Detail Page
                _todoDetailLiveData.postValue(TodoDetailState.Write)
            }
            DetailMode.DETAIL -> { // Show Detail Page
                _todoDetailLiveData.postValue(TodoDetailState.Loding)
                try {
                    getTodoItemUseCase(id)?.let { getTodoEntity ->
                        // not null
                        _todoDetailLiveData.postValue(TodoDetailState.Success(getTodoEntity))
                    } ?: kotlin.run {
                        // null
                        _todoDetailLiveData.postValue(TodoDetailState.Error)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    _todoDetailLiveData.postValue(TodoDetailState.Error)
                }
            }
        }
    }

    fun deleteTodoItem() = viewModelScope.launch {
        _todoDetailLiveData.postValue(TodoDetailState.Loding)
        try {
            deleteTodoItemUseCase(id)
            _todoDetailLiveData.postValue(TodoDetailState.Delete)
        } catch (e: Exception) {
            e.printStackTrace()
            _todoDetailLiveData.postValue(TodoDetailState.Error)
        }
    }

    fun setModifyMode() = viewModelScope.launch {
        _todoDetailLiveData.postValue(TodoDetailState.Modify)
    }

    fun writeTodo(title: String, description: String) = viewModelScope.launch {
        _todoDetailLiveData.postValue(TodoDetailState.Loding)
        when (detailMode) {
            DetailMode.WRITE -> {   // insert
                try {
                     val todoEntity = TodoEntity(
                         title = title,
                         description = description
                     )
                    id = insertTodoItemUseCase(todoEntity)  // need to check Page changing ( write -> detail page)
                    _todoDetailLiveData.postValue(TodoDetailState.Success(todoEntity))
                    detailMode = DetailMode.DETAIL   // back to the DetailPage
                } catch (e:Exception) {
                    e.printStackTrace()
                    _todoDetailLiveData.postValue(TodoDetailState.Error)
                }
            }
            DetailMode.DETAIL -> {  // Update Detail Page
                try {
                    getTodoItemUseCase(id)?.let { getTodoEntity->
                        val updateTodoEntity = getTodoEntity.copy(
                            title = title,
                            description = description
                        )
                        updateTodoUseCase(updateTodoEntity)
                        _todoDetailLiveData.postValue(TodoDetailState.Success(updateTodoEntity))
                    } ?: kotlin.run {
                        _todoDetailLiveData.postValue(TodoDetailState.Error)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                    _todoDetailLiveData.postValue(TodoDetailState.Error)
                }

            }

        }
    }

}