package com.example.epayassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServicesAdapter(
	private var servicesList: List<Services>
) : RecyclerView.Adapter<ServicesAdapter.ServicesViewHolder>(){
	
	inner class ServicesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
	
		val icon: ImageView = itemView.findViewById(R.id.serv_rv_icon)
		val text: TextView = itemView.findViewById(R.id.serv_rv_text)
	}
	
	fun setFilteredServices(list: List<Services>){
		this.servicesList = list
		notifyDataSetChanged()
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServicesAdapter.ServicesViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.serv_item, parent, false)
		return ServicesViewHolder(view)
	}
	
	override fun getItemCount(): Int {
		return servicesList.size
	}
	
	override fun onBindViewHolder(holder: ServicesViewHolder, position: Int) {
		val service = servicesList[position]
		
		holder.icon.setImageResource(service.icon)
		holder.text.text = service.title
	}
}

data class Services (
	val icon: Int,
	val title: String,
	val category: String
)
