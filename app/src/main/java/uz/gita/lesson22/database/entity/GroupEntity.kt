package uz.gita.lesson22.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import uz.gita.lesson22.database.entity.CourseEntity
import java.io.Serializable

@Entity (foreignKeys = arrayOf(ForeignKey(
    entity = CourseEntity::class,
    parentColumns = ["id"],
    childColumns = ["courseId"],
    onDelete = ForeignKey.CASCADE
)))
class GroupEntity(
    @PrimaryKey (autoGenerate = true)
    var id: Int,
    var nameGroup:String,
    var courseId:Int): Serializable