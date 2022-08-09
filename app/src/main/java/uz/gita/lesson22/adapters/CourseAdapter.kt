package uz.gita.lesson22.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.lesson22.database.entity.CourseEntity
import uz.gita.lesson22.R


class CourseAdapter: RecyclerView.Adapter<CourseAdapter.Holder>() {

    val data = ArrayList<CourseEntity>()


   private var listener: ((CourseEntity) -> Unit)? = null
   private var listenerDelate: ((CourseEntity) -> Unit)? = null

    fun OnClicListener(l:(CourseEntity) -> Unit){
        listener=l
    }
fun OnClicListenerDelate(l:(CourseEntity) -> Unit){
        listenerDelate=l
    }

    fun submitItems(items: List<CourseEntity>) {

        data.clear()
        data.addAll(items)
        notifyDataSetChanged()
    }

    inner class Holder(view: View) : RecyclerView.ViewHolder(view) {
        init {
            val image: ImageButton = itemView.findViewById(R.id.btnDeleteC)
            image.setOnClickListener {
                listenerDelate?.invoke(data[adapterPosition])
            }
        }

        fun bind(courseData: CourseEntity) {
            val text: TextView = itemView.findViewById(R.id.couresTextView)
          //  val image: ImageView = itemView.findViewById(R.id.course_imageView)

            text.text = courseData.name
//            image.setImageResource(courseData.image)
            text.setOnClickListener {
                Log.d("h",data[adapterPosition].id.toString())
                listener?.invoke(data[adapterPosition])
            }
        }
    }

 override   fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            LayoutInflater.from(parent.context).inflate(R.layout.course_custom, parent, false)
        )
    }

override    fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(data[position])

   override fun getItemCount(): Int = data.size
}