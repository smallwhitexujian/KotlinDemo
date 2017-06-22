package com.example.xujian.kotlindemo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var list = ArrayList<String>();
    private var adapter: TextAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message.text = "this is kotlin"
        btn.setOnClickListener { Toast.makeText(applicationContext, "kotlin", Toast.LENGTH_SHORT).show() }
        list.getData()
        adapter = TextAdapter(list, applicationContext)
        listView.adapter = adapter
        listView.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, i, l -> Toast.makeText(applicationContext, list.get(i), Toast.LENGTH_SHORT).show() }
    }

    fun ArrayList<String>.getData() {
        for (i in 0..20) {
            this.add("this is kotlin item" + i)
        }
    }

    class TextAdapter(var list: ArrayList<String>, var context: Context) : BaseAdapter() {
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var holder: TextViewHolder
            var v: View
            if (convertView == null) {
                v = View.inflate(context, R.layout.item_text, null)
                holder = TextViewHolder(v)
                v.tag = holder
            } else {
                v = convertView
                holder = v.tag as TextViewHolder
            }
            holder.str.text = list.get(position)
            return v
        }

        override fun getItem(p0: Int): Any {
            return list.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong();
        }

        override fun getCount(): Int {
            return list.size
        }

    }
}

class TextViewHolder(var viewItem: View) {
    var str: TextView = viewItem.findViewById(R.id.itemText) as TextView
}
