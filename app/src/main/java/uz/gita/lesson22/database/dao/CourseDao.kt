package uz.gita.lesson22.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.gita.lesson22.database.entity.CourseEntity

@Dao
interface CourseDao {
    @Query("SELECT * FROM CourseEntity")
    fun getAll(): List<CourseEntity>

    @Insert
    fun insert(vararg data: CourseEntity)
    @Delete
    fun delete(vararg data: CourseEntity)

}