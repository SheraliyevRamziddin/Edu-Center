package uz.gita.lesson22.contracts.repository

import android.content.Context
import uz.gita.lesson22.database.CourseDatabase

import uz.gita.lesson22.database.entity.StudentEntity

class StudentRepository (context: Context) {
        val courseDatabase= CourseDatabase.getDatabase(context)
        fun getAllGroups(id: Int): List<StudentEntity> {
            return courseDatabase.getStudentDao().getAll(id)
        }
        fun insertGroup(dat: StudentEntity){
            courseDatabase.getStudentDao().insert(dat)
        }
    fun delate(data: StudentEntity){
        courseDatabase.getStudentDao().delete(data)
    }

}