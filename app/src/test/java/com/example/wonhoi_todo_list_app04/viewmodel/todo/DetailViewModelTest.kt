package com.example.wonhoi_todo_list_app04.viewmodel.todo

import com.example.wonhoi_todo_list_app04.ViewModelTest
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.domain.todo.InsertTodoItemUseCase
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailMode
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailViewModel
import com.example.wonhoi_todo_list_app04.presentation.detail.TodoDetailState
import com.example.wonhoi_todo_list_app04.presentation.list.ListViewModel
import com.example.wonhoi_todo_list_app04.presentation.list.TodoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

/**
 * [DetailViewModel]  Unit Test Class for Testing
 *
 *    1. initData()
 *    2. test viewModel fetch
 *    3. test Delete todoItem
 *    4. test Update todoItem
 */

@ExperimentalCoroutinesApi
internal class DetailViewModelTest : ViewModelTest() {

    private val id = 1L

    private val insertTodoItemUseCase: InsertTodoItemUseCase by inject()

    private val detailViewModel by inject<DetailViewModel> {
        parametersOf(
            DetailMode.DETAIL,
            id
        )
    }

    private val listViewModel by inject<ListViewModel>()

    private val todo = TodoEntity(
        id = id,
        title = "title $id",
        description = "description $id",
        hasCompleted = false
    )

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlockingTest {
        insertTodoItemUseCase(todo)
    }

    @Test
    fun `test viewModel fetch`() = runBlockingTest {
        val testObservable = detailViewModel.todoDetailLiveData.test()

        detailViewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                TodoDetailState.UnInitialized,
                TodoDetailState.Loding,
                TodoDetailState.Success(todo)
            )
        )
    }

    @Test
    fun `test Delete todoItem`() = runBlockingTest {
        val detailTestObservable = detailViewModel.todoDetailLiveData.test()
        detailViewModel.deleteTodoItem()

        detailTestObservable.assertValueSequence(
            listOf(
                TodoDetailState.UnInitialized,
                TodoDetailState.Loding,
                TodoDetailState.Delete
            )
        )
        // expected result
        val listTestObservable = listViewModel.todoListLiveData.test()
        listViewModel.fetchData()

        listTestObservable.assertValueSequence(
            listOf(
                TodoListState.UnInitialized,
                TodoListState.Loding,
                TodoListState.Success(listOf())
            )
        )
    }

    @Test
    fun `test Update todoItem`() = runBlockingTest {
        val testObservable = detailViewModel.todoDetailLiveData.test()

        val updateTitle = "title 1 update"
        val updateDescription = "description 1 update"

        val updateTodo = todo.copy(
            title = updateTitle,
            description = updateDescription
        )

        detailViewModel.writeTodo(
            title = updateTitle,
            description = updateDescription
        )

        testObservable.assertValueSequence(
            listOf(
                TodoDetailState.UnInitialized,
                TodoDetailState.Loding,
                TodoDetailState.Success(updateTodo)
            )
        )

    }


}










