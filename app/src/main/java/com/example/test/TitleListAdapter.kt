package com.example.test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TitleListAdapter(var context:Context): RecyclerView.Adapter<TitleListAdapter.ViewHolder>(){

    var datalist = mutableListOf<NameResponse>()

    fun setDataTile(datalist:MutableList<NameResponse>){
        this.datalist=datalist
    }

    fun deleteListItem(){
        if(this.datalist.isNotEmpty()){
            this.datalist.removeAt(datalist.size-1)
            notifyDataSetChanged()
        }
    }

    class ViewHolder(itemview:View):RecyclerView.ViewHolder(itemview){
        var Title:TextView
        var Fname:TextView
        var Lname:TextView

        init {
            Title=itemview.findViewById(R.id.title)
            Fname = itemview.findViewById(R.id.fname)
            Lname = itemview.findViewById(R.id.lname)
        }
    }

    override fun onCreateViewHolder(parent:ViewGroup,viewType:Int): ViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.layout_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder:ViewHolder,position:Int){
        var data = datalist[position]
        holder.Title.text = data.name.title
        holder.Fname.text = data.name.first
        holder.Lname.text = data.name.last;
    }

    override fun getItemCount()=datalist.size

}