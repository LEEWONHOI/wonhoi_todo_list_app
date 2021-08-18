package com.example.wonhoi_todo_list_app04.data.repository

import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity

class TestTodoRepository : TodoRepository {
    // for test List
    private val toDoList: MutableList<TodoEntity> = mutableListOf()

    override suspend fun getTodoList(): List<TodoEntity> {
        return toDoList
    }

    override suspend fun getTodoItem(itemId: Long): TodoEntity? {
        return toDoList.find {
            it.id == itemId
        }
    }

    override suspend fun insertTodoList(todoList: List<TodoEntity>) {
        this.toDoList.addAll(todoList)
    }

    override suspend fun insertTodoItem(todoItem: TodoEntity) : Long {
        this.toDoList.add(todoItem)
        return todoItem.id
    }

    override suspend fun updateTodoItem(todoItem: TodoEntity) {
        val foundTodoEntity = toDoList.find {  it.id == todoItem.id }
        this.toDoList[toDoList.indexOf(foundTodoEntity)] = todoItem
//        return if (foundTodoEntity == null) {
//            false
//        } else {
//            this.toDoList[toDoList.indexOf(foundTodoEntity)] = todoItem
//            true
//        }
    }

    override suspend fun deleteAll() {
        toDoList.clear()
    }

    override suspend fun deleteTodoItem(itemId: Long) {
        val foundTodoEntity = toDoList.find {
            it.id == itemId
        }
        this.toDoList.removeAt(toDoList.indexOf(foundTodoEntity))
    }
}