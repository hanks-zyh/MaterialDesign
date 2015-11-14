package com.hanks.coor

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by hanks on 2015/11/13.
 */
class MainActivity : AppCompatActivity() {
    private val activityInfo = ArrayList<ItemInfo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //add class
        activityInfo.add(ItemInfo(AppbarViewPager::class.java, "AppbarLayout+ViewPager", "like Android system app 'dial'"))
        activityInfo.add(ItemInfo(FabAnimateActivity::class.java, "FabRecycler", "layout like Android  app 'Inbox'"))

        //set view
        val recyclerView = RecyclerView(this)
        recyclerView.setBackgroundColor(Color.parseColor("#e5e5e5"))
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ActivityAdapter()
        setContentView(recyclerView)
    }

    internal inner class ActivityAdapter : RecyclerView.Adapter<ActivityViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list_activity, parent, false)
            return ActivityViewHolder(view)
        }

        override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
            holder?.tv_title.text = activityInfo[position].title
            holder?.tv_description.text = "description:" + activityInfo[position].description

        }

        override fun getItemCount(): Int {
            return activityInfo.size
        }
    }

    internal inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv_title: TextView
        val tv_description: TextView

        init {
            tv_title = itemView.findViewById(R.id.tv_title) as TextView
            tv_description = itemView.findViewById(R.id.tv_description) as TextView
            itemView.setOnClickListener {
                startActivity(Intent(itemView.context, activityInfo.get(adapterPosition).cls))
            }
        }
    }

    data class ItemInfo(val cls: Class<*>, val  title: String, val description: String) {

    }
}