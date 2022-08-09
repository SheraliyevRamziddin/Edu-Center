package uz.gita.lesson22.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

import uz.gita.lesson22.database.entity.GroupEntity

@Dao
interface GroupDao {
    @Query("SELECT * FROM GroupEntity where courseId=:id")
    fun getAll(id:Int ): List<GroupEntity>

    @Insert
    fun insert(vararg data: GroupEntity)

    @Delete
    fun delete(vararg data: GroupEntity)

}