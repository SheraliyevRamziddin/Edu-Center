package uz.gita.lesson22

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.lesson22.adapters.GroupAdapter
import uz.gita.lesson22.contracts.repository.GroupRepository
import uz.gita.lesson22.database.entity.CourseEntity
import uz.gita.lesson22.database.entity.GroupEntity

class GroupsActivity : AppCompatActivity() {
    private lateinit var repository: GroupRepository
    private val adapter1 = GroupAdapter()
    private var id: Int = 0
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)
        repository = GroupRepository(this)
        val bundle: Bundle? = intent.extras
        val course = bundle?.getSerializable("course") as CourseEntity
        id = course.id
        val actionBar = supportActionBar
        actionBar?.title = course.name
        adapter1.submitItems(repository.getAllGroups(id!!))

        btnAdd = findViewById(R.id.btnAddG)
        btnAdd.setOnClickListener {
            dialogAdd()
        }
        list = findViewById(R.id.listG)
        list.apply {

            adapter = adapter1
        }
        adapter1.apply {
            OnClicListenerDelate {
                repository.delate(it)
                adapter1.submitItems(repository.getAllGroups(id))
            }
        }
        adapter1.oncliclListener {
            val intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("group", it)
            startActivity(intent)
        }
    }


    fun dialogAdd() {

        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
        val view: View = layoutInflater.inflate(R.layout.gruops, null)
        val inputName = view.findViewById<EditText>(R.id.gruh_nomi_add)


        val saqlash = view.findViewById<TextView>(R.id.saqlash1)
        val bekor_qilish = view.findViewById<TextView>(R.id.bekor_qilish1)
        builder.setView(view)

        saqlash.setOnClickListener {

            val title = inputName.text.toString()
            if (title != "") {

                repository.insertGroup(GroupEntity(0, title, id))
                adapter1.submitItems(repository.getAllGroups(id))
                builder.cancel()
            } else {
                Toast.makeText(this, "can not save", Toast.LENGTH_SHORT).show()
            }

        }
        bekor_qilish.setOnClickListener {

            builder.cancel()
        }


        builder.show()


    }

}
