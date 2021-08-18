package com.example.wonhoi_todo_list_app04.di

import android.content.Context
import androidx.room.Room
import com.example.wonhoi_todo_list_app04.data.entity.local.db.TodoDatabase
import com.example.wonhoi_todo_list_app04.data.repository.DefualtTodoRepository
import com.example.wonhoi_todo_list_app04.data.repository.TodoRepository
import com.example.wonhoi_todo_list_app04.domain.todo.DeleteAllTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.DeleteTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.GetTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.GetTodoListUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.InsertTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.InsertTodoListUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.UpdateTodoUseCase
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailMode
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailViewModel
import com.example.wonhoi_todo_list_app04.presentation.list.ListViewModel
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val appModule = module {

    // Dispatchers
    single { Dispatchers.Main }
    single { Dispatchers.IO }

    // UseCase
    factory { GetTodoListUseCase(get()) }
    factory { InsertTodoListUseCase(get()) }
    factory { InsertTodoItemUseCase(get()) }
    factory { UpdateTodoUseCase(get()) }
    factory { GetTodoItemUseCase(get()) }
    factory { DeleteAllTodoItemUseCase(get()) }
    factory { DeleteTodoItemUseCase(get()) }

    // Repository
    single<TodoRepository> {
        DefualtTodoRepository(
            get(), get()
        )
    }

    single { provideDB(androidApplication()) }
    single { providerTodoDao(get()) }

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
}

internal fun provideDB(context: Context): TodoDatabase =
    Room.databaseBuilder(context, TodoDatabase::class.java, TodoDatabase.DB_NAME).build()

internal fun providerTodoDao(database: TodoDatabase) = database.todoDao()
