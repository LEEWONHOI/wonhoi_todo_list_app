package com.example.wonhoi_todo_list_app04.di

import android.widget.ListView
import com.example.wonhoi_todo_list_app04.data.repository.TestTodoRepository
import com.example.wonhoi_todo_list_app04.data.repository.TodoRepository
import com.example.wonhoi_todo_list_app04.domain.todo.*
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailMode
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailViewModel
import com.example.wonhoi_todo_list_app04.presentation.list.ListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appTestModule = module {

    // ViewModel
    viewModel { ListViewModel(get(), get(), get()) }
    viewModel { (detailMode: DetailMode, id: Long) ->
        DetailViewModel(
            detailMode = detailMode,
            id = id,
            get(),
            get(),
            get(),
            get()
        )
    }


    // UseCase
    factory { GetTodoListUseCase(get()) }
    factory { InsertTodoListUseCase(get()) }
    factory { InsertTodoItemUseCase(get()) }
    factory { UpdateTodoUseCase(get()) }
    factory { GetTodoItemUseCase(get()) }
    factory { DeleteAllTodoItemUseCase(get()) }
    factory { DeleteTodoItemUseCase(get()) }

    // Repository
    single<TodoRepository> { TestTodoRepository() }

}