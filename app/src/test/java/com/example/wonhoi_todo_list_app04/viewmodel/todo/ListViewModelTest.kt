package com.example.wonhoi_todo_list_app04.viewmodel.todo

import com.example.wonhoi_todo_list_app04.ViewModelTest
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.domain.todo.GetTodoItemUseCase
import com.example.wonhoi_todo_list_app04.domain.todo.InsertTodoListUseCase
import com.example.wonhoi_todo_list_app04.presentation.list.ListViewModel
import com.example.wonhoi_todo_list_app04.presentation.list.TodoListState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test
import org.koin.test.inject

/**
 * [ListViewModel]  Unit Test Class for Testing
 *
 *    1. initData()
 *    2. test viewModel fetch
 *    3. test Item Update
 *    4. test Item Delete All
 */

@ExperimentalCoroutinesApi
internal class ListViewModelTest : ViewModelTest() {

    private val viewModel : ListViewModel by inject()

    private val insertTodoListUseCase : InsertTodoListUseCase by inject()
    private val getTodoItemUseCase : GetTodoItemUseCase by inject()

    private val mockList = (0 until 10).map {
        TodoEntity(
            id = it.toLong(),
            title = "title $it",
            description = "description $it",
            hasCompleted = false
        )
    }

    /** Necessary UseCase
     *    1. InsertTodoListUseCase ?? ListViewModel 에는?
     *    2. GetTodoItemUseCase
     */

    @Before
    fun init() {
        initData()
    }

    private fun initData() = runBlocking {
        insertTodoListUseCase(mockList)
    }

    // Test : Verify the entered data.
    @Test
    fun `test viewModel fetch`() : Unit = runBlockingTest {
        val testObservable = viewModel.todoListLiveData.test()

        viewModel.fetchData()

        testObservable.assertValueSequence(
            listOf(
                TodoListState.UnInitialized,
                TodoListState.Loding,
                TodoListState.Success(mockList)
            )
        )
    }

    // Test : Does the data update reflect well?
    @Test
    fun `test Item Update`() : Unit = runBlockingTest {
        val todo = TodoEntity(
            id = 1,
            title = "title 1",
            description = "description $1",
            hasCompleted = true
        )
        viewModel.updateEntity(todo)
        assert(getTodoItemUseCase(todo.id)?.hasCompleted ?: false == todo.hasCompleted)
    }

    // Test : Does it appear empty when data is deleted?
    @Test
    fun `test Item Delete All`() : Unit = runBlockingTest {
        val testObservable = viewModel.todoListLiveData.test()
        viewModel.deleteAll()
        testObservable.assertValueSequence(
            listOf(
                TodoListState.UnInitialized,
                TodoListState.Loding,
                TodoListState.Success(listOf())
            )
        )
    }

}









