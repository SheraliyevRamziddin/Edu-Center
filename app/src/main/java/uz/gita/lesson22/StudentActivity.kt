package uz.gita.lesson22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import uz.gita.lesson22.adapters.StudentAdapter
import uz.gita.lesson22.contracts.repository.StudentRepository
import uz.gita.lesson22.database.entity.GroupEntity
import uz.gita.lesson22.database.entity.StudentEntity

class StudentActivity : AppCompatActivity() {
    private lateinit var repository: StudentRepository
    private val adapter1 = StudentAdapter()
    private var id: Int = 0
    private lateinit var btnAdd: FloatingActionButton
    private lateinit var list: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_groups)
        repository = StudentRepository(this)
        val bundle: Bundle? = intent.extras
        val group = bundle?.getSerializable("group") as GroupEntity
        id = group.id
        val actionBar = supportActionBar
        actionBar?.title = group.nameGroup
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
    }


    fun dialogAdd() {

        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog).create()
        val view: View = layoutInflater.inflate(R.layout.add_student, null)
        val inputTitle = view.findViewById<EditText>(R.id.title_add)
        val inputNumber = view.findViewById<EditText>(R.id.number)

//        val imageView: ImageView = view.findViewById(R.id.img_dilag)
//         val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)

        var res = 0

//        radioGroup.setOnCheckedChangeListener { g, i ->
//            when (i) {
//                R.id.male->{
//                    res=R.drawable.erkak
////                    imageView.setImageResource(res)
//                }
//                R.id.female->{
//                    res=R.drawable.ayol
////                    imageView.setImageResource(res)
//                }
//            }
//        }


        val saqlash = view.findViewById<TextView>(R.id.saqlash)
        val bekor_qilish = view.findViewById<TextView>(R.id.bekor_qilish)
        builder.setView(view)

        saqlash.setOnClickListener {

            val title = inputTitle.text.toString()
            val number = inputNumber.text.toString()
            if (title != "" && number != "") {
                repository.insertGroup(StudentEntity(0, title, number, res, id))
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