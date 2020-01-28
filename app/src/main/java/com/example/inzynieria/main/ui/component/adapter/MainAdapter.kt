package com.example.inzynieria.main.ui.component.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.inzynieria.R
import com.example.inzynieria.main.data.Model
import com.example.inzynieria.main.data.local.room.MagazinesEntity
import io.reactivex.Flowable

class MainAdapter(val magazines: Flowable<List<MagazinesEntity>>, val listener: (MagazinesEntity) -> Unit): RecyclerView.Adapter<MainAdapter.MagazineViewHolder>() {


    class MagazineViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(magazine: MagazinesEntity, listener: (MagazinesEntity) -> Unit) = with(itemView){
            //name.text = magazine.title
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MagazineViewHolder {
        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return MagazineViewHolder(
            rootView
        )
    }


    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) {
       // holder.bind(magazines.get(position), listener)


        holder.itemView.setOnClickListener{
//            val item = taskList[position]
//            val intent = Intent(holder.itemView.context, UpdateTaskActivity::class.java)
//            intent.putExtra(MainActivity.TASK_ID, item.id)
//            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //override fun getItemCount() = magazines.size()
}

////////////////////////////////
/**
 * Adapter for the [RecyclerView] in [LegoThemeFragment].
 */
//class LegoThemeAdapter : ListAdapter<LegoTheme, LegoThemeAdapter.ViewHolder>(DiffCallback()) {
////
////    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
////        val legoTheme = getItem(position)
////        holder.apply {
////            bind(createOnClickListener(legoTheme.id, legoTheme.name), legoTheme)
////            itemView.tag = legoTheme
////        }
////    }
////
////    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
////        return ViewHolder(ListItemThemeBinding.inflate(
////            LayoutInflater.from(parent.context), parent, false))
////    }
////
////    private fun createOnClickListener(id: Int, name: String): View.OnClickListener {
////        return View.OnClickListener {
////            val direction = LegoThemeFragmentDirections.actionThemeFragmentToSetsFragment(id, name)
////            it.findNavController().navigate(direction)
////        }
////    }
////
////    class ViewHolder(
////        private val binding: ListItemThemeBinding
////    ) : RecyclerView.ViewHolder(binding.root) {
////
////        fun bind(listener: View.OnClickListener, item: LegoTheme) {
////            binding.apply {
////                clickListener = listener
////                legoTheme = item
////                executePendingBindings()
////            }
////        }
////    }
////}

private class DiffCallback : DiffUtil.ItemCallback<MagazinesEntity>() {

    override fun areItemsTheSame(oldItem: MagazinesEntity, newItem: MagazinesEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MagazinesEntity, newItem: MagazinesEntity): Boolean {
        return oldItem == newItem
    }
}