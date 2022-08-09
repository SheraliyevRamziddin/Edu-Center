package uz.gita.lesson22.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import uz.gita.lesson22.database.entity.StudentEntity

@Dao
interface StudentDao {
    @Query("SELECT * FROM StudentEntity where groupId=:id")
    fun getAll(id:Int ): List<StudentEntity>

    @Insert
    fun insert(vararg data: StudentEntity)

    @Delete
    fun delete(vararg data: StudentEntity)


}