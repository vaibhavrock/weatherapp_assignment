package com.mobiquity.weatherapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.*
import com.mobiquity.weatherapp.R
import com.mobiquity.weatherapp.ui.adapter.RecyclerAdapter
import com.mobiquity.weatherapp.ui.adapter.SwipeToDeleteCallback
import com.mobiquity.weatherapp.ui.interfaces.RecycleOnClickInterface
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : BaseFragment(), RecycleOnClickInterface {

    lateinit var myAdapter: RecyclerAdapter
    private val locationCityName = ArrayList<String>()
    var listener:RecycleOnClickInterface = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        myAdapter = RecyclerAdapter(locationCityName,listener)

         recycler_view.apply {
            adapter = myAdapter
            layoutManager = LinearLayoutManager(activity)
            itemAnimator = DefaultItemAnimator()
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
        }

        // delete item by swipe function
        //start
        val swipeHandler = object : SwipeToDeleteCallback(context!!) {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val adapter = recycler_view.adapter as RecyclerAdapter
                adapter.removeAt(viewHolder.adapterPosition)
            }
        }
        val itemTouchHelper = ItemTouchHelper(swipeHandler)
        itemTouchHelper.attachToRecyclerView(recycler_view)
        // end

        // add some dummy city
        locationCityName.add("Noida")
        locationCityName.add("Delhi")
        locationCityName.add("Agra")
        locationCityName.add("Aligarh")
        myAdapter.notifyDataSetChanged()


    }

    override fun itemCLickPerform(cityName: String) {
        changeInnerFragment(CityFragment(cityName),R.id.mainContainer,null)
    }


}