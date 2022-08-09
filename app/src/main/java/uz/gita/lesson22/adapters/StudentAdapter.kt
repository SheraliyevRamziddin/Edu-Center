package uz.gita.lesson22.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.lesson22.database.entity.StudentEntity
import uz.gita.lesson22.R

class StudentAdapter:RecyclerView.Adapter<StudentAdapter.Holder>() {

    private var data:ArrayList<StudentEntity> = arrayListOf()
    private var onClicListener:((StudentEntity)->Unit)?=null
    fun oncliclListener(l:(StudentEntity)->Unit){
        onClicListener=l
    }
    private var listenerDelate: ((StudentEntity) -> Unit)? = null

    fun OnClicListenerDelate(l:(StudentEntity) -> Unit){
        listenerDelate=l
    }
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(items: List<StudentEntity>) {

        data.clear()
        data.addAll(items)
        notifyDataSetChanged()

    }
    inner  class Holder(view: View): RecyclerView.ViewHolder(view) {

        init {
            val image: ImageButton = itemView.findViewById(R.id.btnDelete)
            image.setOnClickListener {
                listenerDelate?.invoke(data[adapterPosition])
            }
        }
        fun bind(){
            val name: TextView =itemView.findViewById(R.id.txtName)
            val lastName: TextView =itemView.findViewById(R.id.txtLastName)
//            val image: ImageView=itemView.findViewById(R.id.imageS)
            name.text=data[adapterPosition].firstName
            lastName.text=data[adapterPosition].lastName

//            image.setImageResource(data[adapterPosition].image)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.item_students,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int)=holder.bind()

    override fun getItemCount()=data.size
}