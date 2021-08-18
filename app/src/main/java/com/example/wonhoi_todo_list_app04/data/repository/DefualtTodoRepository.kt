package com.example.wonhoi_todo_list_app04.data.repository

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.data.entity.local.db.dao.TodoDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class DefualtTodoRepository(
    private val todoDao: TodoDao,
    private val ioDispatcher : CoroutineDispatcher
) : TodoRepository {

    override suspend fun getTodoList(): List<TodoEntity> = withContext(ioDispatcher) {
        todoDao.getAll()
    }

    override suspend fun getTodoItem(itemId: Long): TodoEntity? = withContext(ioDispatcher) {
        todoDao.getById(itemId)
    }

    override suspend fun insertTodoList(todoList: List<TodoEntity>) = withContext(ioDispatcher) {
        todoDao.insert(todoList)
    }

    override suspend fun insertTodoItem(todoItem: TodoEntity) : Long = withContext(ioDispatcher) {
        todoDao.insert(todoItem)
    }

    override suspend fun updateTodoItem(todoItem: TodoEntity) = withContext(ioDispatcher) {
        todoDao.update(todoItem)
    }

    override suspend fun deleteAll() {
        todoDao.deleteAll()
    }

    override suspend fun deleteTodoItem(itemId: Long) = withContext(ioDispatcher) {
        todoDao.delete(itemId)
    }
}