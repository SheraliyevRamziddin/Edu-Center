package uz.gita.lesson22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.lesson22.GroupsActivity
import uz.gita.lesson22.adapters.CourseAdapter
import uz.gita.lesson22.contracts.repository.Repository
import uz.gita.lesson22.database.entity.CourseEntity
import uz.gita.lesson22.database.entity.StudentEntity

class MainActivity : AppCompatActivity() {
    private lateinit var repository: Repository
    private var adpterCourse= CourseAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        repository= Repository(this)

        val  list:RecyclerView=findViewById(R.id.list)

        val btnAdd:FloatingActionButton=findViewById(R.id.btnAdd)

        list.adapter=adpterCourse.apply {
            submitItems(repository.getAll())
            OnClicListenerDelate {
                repository.delete(it)
                adpterCourse.submitItems(repository.getAll())
            }

        }
        adpterCourse.OnClicListener {
            val intent=Intent(this, GroupsActivity::class.java)
            intent.putExtra("course",it)
            startActivity(intent)

        }
        btnAdd.setOnClickListener {
            dialogAdd()
        }

    }

    fun dialogAdd(){

        val builder = AlertDialog.Builder(this,R.style.CustomAlertDialog).create()
        val view: View = layoutInflater.inflate(R.layout.add_course,null)
        val inputTitle = view.findViewById<EditText>(R.id.title_add)
//        val img = view.findViewById<ImageView>(R.id.select_img)



        val  saqlash=view.findViewById<TextView>(R.id.saqlash)
        val  bekor_qilish=view.findViewById<TextView>(R.id.bekor_qilish)

        builder.setView(view)

        saqlash.setOnClickListener {

            val title=inputTitle.text.toString()


            if (title!="") {
                repository.insert(CourseEntity(0, R.drawable.gita, title))
                adpterCourse.submitItems(repository.getAll())
                builder.cancel()
            }
            else{
                Toast.makeText(this,"can not save", Toast.LENGTH_SHORT).show()
            }

        }
        bekor_qilish.setOnClickListener {

            builder.cancel()
        }

        builder.show()


    }
}

