package com.example.inzynieria.main.ui.main.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.inzynieria.databinding.FragmentHomeBinding
import com.example.inzynieria.main.data.repository.MagazineRepository
import com.example.inzynieria.main.di.ActivityScoped
import com.example.inzynieria.main.ui.component.adapter.MainAdapter
import com.example.inzynieria.main.ui.main.base.BaseFragment
import com.google.gson.Gson
import javax.inject.Inject




@ActivityScoped
class HomeFragment @Inject constructor() : BaseFragment() {

    companion object{
        const val HOME_DATA = "magazine_data"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var dataBinding: FragmentHomeBinding

    //private lateinit var homeAdapter: MainAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        homeViewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
       // homeAdapter = MainAdapter(MagazineRepository().getAllMagazines(),this)

        dataBinding = FragmentHomeBinding.inflate(inflater, container, false).apply {
            this.viewModel = homeViewModel
            //this.adapter = homeAdapter
        }

        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel.start()
        handleUIEvent()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homeViewModel.stop()
    }

    private fun handleUIEvent() {
        homeViewModel.onMagazinesOpenEvent.observe(this, Observer { news ->
            news?.let {
                val intent = Intent(context, MainActivity::class.java)
                intent.putExtra(HOME_DATA, Gson().toJson(it))
                startActivity(intent)
            }
        })
    }
}
//class HomeFragment : Fragment(){
//
//    @Inject
//    lateinit var homeViewModelFactory: HomeViewModelFactory
//    private lateinit var homeViewModel: HomeViewModel
//    private lateinit var adapter: MainAdapter
//
//    companion object{
//        @JvmStatic
//        fun newInstance() =
//            HomeFragment().apply {
//                arguments = Bundle().apply {
//                    // putInt(ARG_COLUMN_COUNT, columnCount)
//                }
//            }
//    }
//
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//
////        val adapter = MainAdapter(HomeRepository.getInstance().getMagazines(),this)
////        root.recyclerView.adapter = adapter
//
//        initializeUi()
//        return root
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        //adapter = MainAdapter()
////        recyclerView.adapter = adapter
//
//    }
//    private fun initializeUi(){
//        val factory = InjectorUtils.provideHomeViewModelFactory()
//        val viewModel = ViewModelProviders.of(this, factory).get(homeViewModel::class.java)
//
////        viewModel.getMagazine().observe(this, Observer{ magazines ->
////            val stringBuilder = StringBuilder()
////            magazines.forEach{magazine ->
////                stringBuilder.append("$magazine\n\n")
////            }
////            name.text = stringBuilder.toString()
////        })
//
//        name.setOnClickListener{
//            Log.i("magazineActivity", "jestem tu")
//        }
//
//    }
//}
//////////////////////////////////////////////////////////////////////////////////////////////////////



