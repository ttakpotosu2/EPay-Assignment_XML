package com.example.epayassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GridAdapter(
	private val servicesList: List<Services>
) : RecyclerView.Adapter<GridAdapter.ServicesViewHolder>(){
	
	inner class ServicesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
	
		val icon: ImageView = itemView.findViewById(R.id.rv_grid_icon)
		val text: TextView = itemView.findViewById(R.id.rv_grid_text)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridAdapter.ServicesViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.grid_item, parent, false)
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
	val title: String
)
