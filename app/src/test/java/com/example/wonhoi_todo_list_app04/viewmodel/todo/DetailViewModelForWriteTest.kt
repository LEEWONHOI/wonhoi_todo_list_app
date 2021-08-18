package com.example.wonhoi_todo_list_app04.viewmodel.todo

import com.example.wonhoi_todo_list_app04.ViewModelTest
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailMode
import com.example.wonhoi_todo_list_app04.presentation.detail.DetailViewModel
import com.example.wonhoi_todo_list_app04.presentation.detail.TodoDetailState
import com.example.wonhoi_todo_list_app04.presentation.list.ListViewModel
import com.example.wonhoi_todo_list_app04.presentation.list.TodoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Test
import org.koin.core.parameter.parametersOf
import org.koin.test.inject

/**
 * [DetailViewModelForWriteTest]  Unit Test Class for Testing
 *
 *    1. test viewModel fetch
 *    2. test Insert todoItem
 *
 */

@ExperimentalCoroutinesApi
internal class DetailViewModelForWriteTest : ViewModelTest() {

    private val id = 0L

    private val detailViewModel by inject<DetailViewModel> {
        parametersOf(
            DetailMode.WRITE,
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

    @Test
    fun `test viewModel fetch`() = runBlockingTest {
        val testObservable = detailViewModel.todoDetailLiveData.test()

        detailViewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                TodoDetailState.UnInitialized,
                TodoDetailState.Write
            )
        )
    }

    @Test
    fun `test Insert todoItem`() = runBlockingTest {
        val detailTestObservable = detailViewModel.todoDetailLiveData.test()
        val listTestObservable = listViewModel.todoListLiveData.test()

        detailViewModel.writeTodo(
            title = todo.title,
            description = todo.description
        )

        detailTestObservable.assertValueSequence(
            listOf(
                TodoDetailState.UnInitialized,
                TodoDetailState.Loding,
                TodoDetailState.Success(todo)
            )
        )
        // When Page will be changed to Detail page
        assert(detailViewModel.detailMode == DetailMode.DETAIL)
        // and also be changed detailView.id
        assert(detailViewModel.id == id)

        // back to the page ( List )
        listViewModel.fetchData() // update fetch
        listTestObservable.assertValueSequence(
            listOf(
                TodoListState.UnInitialized,
                TodoListState.Loding,
                TodoListState.Success(listOf(
                    todo
                ))
            )
        )
    }
}







