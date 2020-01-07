package com.example.inzynieria.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inzynieria.R
import com.example.inzynieria.main.data.Magazine
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter(val magazines: ArrayList<Magazine>, val listener: (Magazine) -> Unit): RecyclerView.Adapter<MainAdapter.MagazineViewHolder>() {


    class MagazineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(magazine: Magazine, listener: (Magazine) -> Unit) = with(itemView){
            name.text = magazine.title
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return MagazineViewHolder(
            rootView
        )
    }


    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
        holder.bind(magazines.get(position), listener)


        holder.itemView.setOnClickListener{
//            val item = taskList[position]
//            val intent = Intent(holder.itemView.context, UpdateTaskActivity::class.java)
//            intent.putExtra(MainActivity.TASK_ID, item.id)
//            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = magazines.size
}
