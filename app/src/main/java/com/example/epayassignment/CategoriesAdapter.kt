package com.example.epayassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class CategoriesAdapter(
	private val categories: List<Categories>,
	private val context: Context,
	private val onCategoryClick: (String) -> Unit
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>(){
	
	private var selectedPosition = 0
	
	inner class CategoriesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
	
		val icon: ImageView = itemView.findViewById(R.id.category_item_icon)
		val text: TextView = itemView.findViewById(R.id.category_item_text)
	}
	
	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
		val view = LayoutInflater.from(parent.context).inflate(R.layout.cat_item, parent, false)
		return CategoriesViewHolder(view)
	}
	
	override fun getItemCount(): Int {
		return categories.size
	}
	
	override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
		val category = categories[position]
		
		category.icon?.let { holder.icon.setImageResource(it) }
		holder.text.text = category.title
		holder.icon.visibility = if (category.icon == null) View.GONE else View.VISIBLE
		holder.itemView.isSelected = position == selectedPosition
		
		if (position == selectedPosition) {
			holder.text.setTextColor(ContextCompat.getColor(context, R.color.bg_blue))
			holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.bg_blue))
			
		} else {
			holder.text.setTextColor(ContextCompat.getColor(context, R.color.white))
			holder.icon.setColorFilter(ContextCompat.getColor(context, R.color.white))
		}
		
		holder.itemView.setOnClickListener {
			val temp = selectedPosition
			selectedPosition = holder.adapterPosition
			onCategoryClick(category.title)
			notifyItemChanged(temp)
			notifyItemChanged(position)
		}
	}
}

data class Categories (
	val icon: Int? = null,
	val title: String
)