package com.example.wonhoi_todo_list_app04.data.entity.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity
import com.example.wonhoi_todo_list_app04.data.entity.local.db.dao.TodoDao


@Database(
    entities = [TodoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDatabase : RoomDatabase() {

    companion object {
        const val DB_NAME = "TodoDataBase.db"
    }

    abstract fun todoDao(): TodoDao

}