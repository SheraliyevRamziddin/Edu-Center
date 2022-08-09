package uz.gita.lesson22.models

import android.content.ContentValues
const val EduCenter_TABLE_NAME1 = "Course"
const val EduCenter_TABLE_NAME2 = "Groups"
const val EduCenter_TABLE_NAME3 = "Student"
const val id_student="id_student"
const val id_student_group="id_student_group"
const val id_group="id_group"
const val id_group_course="id_group_course"
const val id_course="id_course"
const val firstName1="first_name"
const val lastName1="last_name"
const val group_name="group_name"
const val course_name="course_name"
const val course_image="course_image"
data class Student (var id:Int, var firstName:String, var lastName:String, var groupId:Int)
    {

        fun toContentValue(isContainId: Boolean): ContentValues {
            val cv = ContentValues()
            if (isContainId) cv.put( id_student, id)
            cv.put(firstName1,firstName)
            cv.put(lastName1, lastName1)
            cv.put(id_student_group,groupId)
            return cv
        }
    }
