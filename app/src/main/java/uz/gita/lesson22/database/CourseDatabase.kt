package uz.gita.lesson22.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import uz.gita.lesson22.database.dao.CourseDao
import uz.gita.lesson22.database.dao.GroupDao
import uz.gita.lesson22.database.dao.StudentDao
import uz.gita.lesson22.database.entity.CourseEntity
import uz.gita.lesson22.database.entity.GroupEntity
import uz.gita.lesson22.database.entity.StudentEntity

@Database (entities = [CourseEntity::class,
                      GroupEntity::class,
                      StudentEntity::class], version = 1)
abstract class CourseDatabase:RoomDatabase() {

    companion object{
        private var _database: CourseDatabase?=null

        fun getDatabase(context: Context): CourseDatabase {
            if (_database ==null){
                _database = Room.databaseBuilder(context, CourseDatabase::class.java,"CourseDataBase")
                    .allowMainThreadQueries()
                    .build()
            }
            return _database!!
        }


    }
    abstract  fun getCourseDao(): CourseDao

    abstract fun getGroupDao(): GroupDao
    abstract fun getStudentDao(): StudentDao
}