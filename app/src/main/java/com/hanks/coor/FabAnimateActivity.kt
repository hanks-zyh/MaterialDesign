package com.hanks.coor

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.util.*

/**
 * Created by hanks on 2015/11/14.
 */
class FabAnimateActivity : AppCompatActivity() {

    var contactList = ArrayList<ContactInfo>()
    var fab: FloatingActionButton ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fabanimte)

        // add data
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))
        contactList.add(ContactInfo("", "Ali Connors", "Bruch this weekend?", "I'll be in your neighborhood doing errands and all that"))


        fab = findViewById(R.id.fab) as FloatingActionButton
        val recyclerView = findViewById(R.id.recycler_view) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ContactAdapter()
        recyclerView!!.addOnScrollListener(object : RecyclerScrollListener() {
            override fun hide() {
                hideFab()
            }

            override fun show() {
                showFab()
            }
        })
    }

    fun showFab() {
        fab?.animate()?.setDuration(300)?.translationY(0f)?.start()
    }
    fun hideFab() {
        fab?.animate()?.setDuration(300)?.translationY(400f)?.start()
    }

    inner internal class ContactAdapter : RecyclerView.Adapter<ContactViewHolder>() {
        override fun onBindViewHolder(holder: ContactViewHolder?, position: Int) {
            val contactInfo = contactList[position]
            holder?.tv_title?.text = contactInfo.name
            holder?.tv_summary?.text = contactInfo.summary
            holder?.tv_content?.text = contactInfo.content
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ContactViewHolder? {
            val view = layoutInflater.inflate(R.layout.item_list_contactinfo, parent, false)
            return ContactViewHolder(view)
        }

        override fun getItemCount() = contactList.size

    }

    inner internal class ContactViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_title: TextView
        var tv_summary: TextView
        var tv_content: TextView

        init {
            tv_title = itemView?.findViewById(R.id.tv_title) as TextView
            tv_summary = itemView?.findViewById(R.id.tv_summary) as TextView
            tv_content = itemView?.findViewById(R.id.tv_content) as TextView
        }
    }

    data class ContactInfo(var avatar: String, var name: String, var summary: String, var content: String) {

    }
}