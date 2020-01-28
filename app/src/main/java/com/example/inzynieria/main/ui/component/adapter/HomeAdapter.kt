package com.example.inzynieria.main.ui.component.adapter

//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.inzynieria.R
//import com.example.inzynieria.main.data.local.room.MagazinesEntity
//import com.example.inzynieria.main.ui.main.home.HomeViewModel
//
//class HomeAdapter(
//    private var magazines: List<MagazinesEntity>,
//    private val homeViewModel: HomeViewModel
//): RecyclerView.Adapter<HomeAdapter.MagazineViewHolder>() {
//
//    //    override fun onCreateViewHolder(
//////        parent: ViewGroup,
//////        viewType: Int
//////    ): HomeAdapter.MagazineViewHolder {
//////        val binding = DataBindingUtil.inflate<ItemMagazineBinding>(
//////                LayoutInflater.from(parent.context),
//////                R.layout.item_home, parent,false
//////        )
//////
//////        return MagazineViewHolder(binding)
//////    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MagazineViewHolder {
//        val rootView = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
//        return HomeAdapter.MagazineViewHolder(
//            rootView
//        )
//    }
//
//    override fun getItemCount() = magazines.size
//
//    override fun onBindViewHolder(holder: MagazineViewHolder, position: Int) = holder.bind(magazines[position])
//
//    class MagazineViewHolder(private val binding: ItemMagazineBinding) : RecyclerView.ViewHolder(binding.root){
//        fun bind(magazinesEntity: MagazinesEntity){
//            with(binding)
//            {
//                magazine = magazinesEntity
//                executePendingBindings()
//            }
//        }
//    }
//
//    fun setData(magazines: List<MagazinesEntity>){
//        this.magazines = magazines
//        notifyDataSetChanged()
//    }
//}