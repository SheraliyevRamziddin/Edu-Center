package uz.gita.lesson22.models

import android.content.ContentValues

data class Group(var id: Int,var name:String, var courseId:Int)
{
    fun toContentValue(isContainId: Boolean): ContentValues {
        val cv = ContentValues()
        if (isContainId) cv.put( id_group, id)
        cv.put(group_name,name)
        cv.put(id_group_course,courseId)
        return cv
    }
}