package com.example.wonhoi_todo_list_app04.data.entity.local.db.dao

import androidx.room.*
import com.example.wonhoi_todo_list_app04.data.entity.TodoEntity

@Dao
interface TodoDao {
    @Query("SELECT * FROM TodoEntity")
    suspend fun getAll() : List<TodoEntity>

    @Query("SELECT * FROM TodoEntity WHERE id=:id")
    suspend fun getById(id:Long) : TodoEntity?

    @Insert
    suspend fun insert(todoEntity: TodoEntity) : Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todoEntity : List<TodoEntity>)

    @Query("DELETE FROM TodoEntity WHERE id=:id")
    suspend fun delete(id:Long)

    @Query("DELETE FROM TodoEntity")
    suspend fun deleteAll()

    @Update
    suspend fun update(todoEntity: TodoEntity)
}