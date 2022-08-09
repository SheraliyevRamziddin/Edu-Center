package uz.gita.lesson22.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data  class CourseEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var image: Int,
    var name: String
):Serializable
