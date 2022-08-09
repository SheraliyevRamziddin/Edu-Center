package uz.gita.lesson22.contracts.repository

import android.content.Context
import uz.gita.lesson22.database.CourseDatabase
import uz.gita.lesson22.database.entity.GroupEntity
import java.util.concurrent.Executors

class GroupRepository(context: Context) {
    val courseDatabase= CourseDatabase.getDatabase(context)
    fun getAllGroups(id: Int): List<GroupEntity> {
        val executors=Executors.newSingleThreadExecutor()
        val result=executors.run {
            courseDatabase.getGroupDao().getAll(id)
        }
        return result
    }
    fun insertGroup(dat: GroupEntity){
        val executors=Executors.newSingleThreadExecutor()
        val result=executors.run {
            courseDatabase.getGroupDao().insert(dat)

        }
        return result

    }

    fun delate(data: GroupEntity){
        val executors=Executors.newSingleThreadExecutor()
        val result=executors.run {
            courseDatabase.getGroupDao().delete(data)
        }
        return result

    }

}