package uz.gita.lesson22.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.gita.lesson22.database.entity.GroupEntity
import uz.gita.lesson22.R


class GroupAdapter: RecyclerView.Adapter<GroupAdapter.Holder>() {
    private var data:ArrayList<GroupEntity> = arrayListOf()
    private var onClicListener:((GroupEntity)->Unit)?=null
    fun oncliclListener(l:(GroupEntity)->Unit){
        onClicListener=l
    }

    private var listenerDelate: ((GroupEntity) -> Unit)? = null

    fun OnClicListenerDelate(l:(GroupEntity) -> Unit){
        listenerDelate=l
    }
    @SuppressLint("NotifyDataSetChanged")
    fun submitItems(items: List<GroupEntity>) {

        data.clear()
        data.addAll(items)

        notifyDataSetChanged()
    }
    inner  class Holder(view:View):RecyclerView.ViewHolder(view) {

        init {
            val image: ImageButton = itemView.findViewById(R.id.btnDeleteG)
            image.setOnClickListener {
                listenerDelate?.invoke(data[adapterPosition])
            }
        }
        fun bind(){
            val name:TextView=itemView.findViewById(R.id.nameGruop)
            name.text=data[adapterPosition].nameGroup
            name.setOnClickListener {
                onClicListener?.invoke(data[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {

        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.gruop_items,parent,false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int)=holder.bind()

    override fun getItemCount()=data.size
}