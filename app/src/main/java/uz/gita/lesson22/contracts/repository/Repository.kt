package uz.gita.lesson22.contracts.repository

import android.content.Context
import uz.gita.lesson22.database.CourseDatabase
import uz.gita.lesson22.database.entity.CourseEntity
import java.util.concurrent.Executors

class Repository(context: Context) {
    val courseDatabase= CourseDatabase.getDatabase(context)
    fun getAll():List<CourseEntity>{
        val executors= Executors.newSingleThreadExecutor()
        val result=executors.run {

            courseDatabase.getCourseDao().getAll()
        }
        return result

    }

    fun insert(data: CourseEntity){
        val executors=Executors.newSingleThreadExecutor()
        val result=executors.run {

            courseDatabase.getCourseDao().insert(data)
        }
        return result

    }

    fun delete(data: CourseEntity){
        val executors=Executors.newSingleThreadExecutor()
        val result=executors.run {
            courseDatabase.getCourseDao().delete(data)

        }
        return result

    }
}