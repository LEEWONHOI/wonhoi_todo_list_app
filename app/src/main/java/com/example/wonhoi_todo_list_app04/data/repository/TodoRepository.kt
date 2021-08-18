package com.example.wonhoi_todo_list_app04.data.repository

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity

/**
 *  1. insertTodoList
 *  2. getTodoList
 *  3. updateTodoItem
 */

interface TodoRepository {

    suspend fun getTodoList() : List<TodoEntity>

    suspend fun getTodoItem(itemId : Long) : TodoEntity?

    suspend fun insertTodoList(todoList : List<TodoEntity>)

    suspend fun insertTodoItem(todoItem: TodoEntity) : Long

    suspend fun updateTodoItem(todoItem : TodoEntity)

    suspend fun deleteAll()

    suspend fun deleteTodoItem(itemId:Long)




}










