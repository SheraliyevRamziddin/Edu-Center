package uz.gita.lesson22.database.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(foreignKeys = arrayOf(
    ForeignKey(
    entity = GroupEntity::class,
    parentColumns = ["id"],
    childColumns = ["groupId"],
    onDelete = ForeignKey.CASCADE
)
))
data class StudentEntity(
@PrimaryKey (autoGenerate = true)
    var id:Int,
    var firstName:String,
    var lastName:String,
    var image:Int,
    var groupId:Int
): Serializable