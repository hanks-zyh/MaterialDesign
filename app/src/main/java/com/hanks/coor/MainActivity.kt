package com.hanks.coor

import android.content.Intent
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
    private val activityList = ArrayList<Class<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityList.add(AppbarViewPager::class.java)

        val recyclerView = RecyclerView(this)
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
            holder?.tv_activity.text = activityList[position].toString()
            holder?.tv_activity.setOnClickListener {
                startActivity(Intent(holder?.tv_activity.context, activityList[position] ))
            }
        }

        override fun getItemCount(): Int {
            return activityList.size
        }
    }

    internal inner class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tv_activity: TextView

        init {
            tv_activity = itemView.findViewById(R.id.tv_activity) as TextView
        }
    }
}