package com.example.epayassignment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FindServiceAdapter(
	private val categories: List<Categories>
) : RecyclerView.Adapter<FindServiceAdapter.CategoriesViewHolder>(){
	
	inner class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
	
		val icon: ImageView = itemView.findViewById(R.id.rv_row_icon)
		val text: TextView = itemView.findViewById(R.id.rv_row_text)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.row_rv_item, parent, false)
		return CategoriesViewHolder(view)
	}
	
	override fun getItemCount(): Int {
		return categories.size
	}
	
	override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
		val categories = categories[position]
		
		categories.icon?.let { holder.icon.setImageResource(it) }
		holder.text.text = categories.title
		holder.icon.visibility = if (categories.icon == null) View.GONE else View.VISIBLE
	}
}

data class Categories (
	val icon: Int? = null,
	val title: String
)
