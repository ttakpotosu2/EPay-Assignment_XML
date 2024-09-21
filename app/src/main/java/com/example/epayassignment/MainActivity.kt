package com.example.epayassignment

import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epayassignment.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {
	
	private val services = listOf(
		Services(
			title = "MTN",
			icon = R.drawable.mtn,
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.ecg,
			title = "Electricity",
			category = "Utilities"
		),
		Services(
			icon = R.drawable.dstv,
			title = "DStv",
			category = "Streaming"
		),
		Services(
			title = "GOtv",
			icon = R.drawable.gotv,
			category = "Streaming"
		),
		Services(
			icon = R.drawable.at_logo,
			title = "Airtel Tigo",
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.voda,
			title = "Vodafone",
			category = "Airtime-Top"
		),
		Services(
			title = "MTN",
			icon = R.drawable.mtn,
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.ecg,
			title = "Electricity",
			category = "Utilities"
		),
		Services(
			icon = R.drawable.dstv,
			title = "DStv",
			category = "Streaming"
		),
		Services(
			title = "GOtv",
			icon = R.drawable.gotv,
			category = "Streaming"
		),
		Services(
			icon = R.drawable.at_logo,
			title = "Airtel Tigo",
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.voda,
			title = "Vodafone",
			category = "Airtime-Top"
		),
		Services(
			title = "MTN",
			icon = R.drawable.mtn,
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.ecg,
			title = "Electricity",
			category = "Utilities"
		),
		Services(
			icon = R.drawable.dstv,
			title = "DStv",
			category = "Streaming"
		),
		Services(
			title = "GOtv",
			icon = R.drawable.gotv,
			category = "Streaming"
		),
		Services(
			icon = R.drawable.at_logo,
			title = "Airtel Tigo",
			category = "Airtime-Top"
		),
		Services(
			icon = R.drawable.voda,
			title = "Vodafone",
			category = "Airtime-Top"
		)
	)
	private val categories = listOf(
		Categories(
			title = "All"
		),
		Categories(
			icon = R.drawable.group_2928,
			title = "Airtime-Top"
		),
		Categories(
			icon = R.drawable.internet,
			title = "Streaming"
		),
		Categories(
			icon = R.drawable.sent_money,
			title = "Send Money"
		),
		Categories(
			icon = R.drawable.utilites,
			title = "Utilities"
		),
	)
	
//	private var selectedCategory: String = "All"
	
	private lateinit var binding: ActivityMainBinding
	
	private lateinit var servicesRecyclerView: RecyclerView
	private lateinit var categoriesRecyclerView: RecyclerView
	private lateinit var searchView: SearchView
	
	private lateinit var categoriesAdapter: CategoriesAdapter
	private lateinit var servicesAdapter: ServicesAdapter
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		enableEdgeToEdge()
		binding = ActivityMainBinding.inflate(layoutInflater)
		setContentView(binding.root)
		ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
			val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
			v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
			insets
		}
		
		searchView = findViewById(R.id.searchView)
		searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
			override fun onQueryTextSubmit(query: String?): Boolean {
				return false
			}
			
			override fun onQueryTextChange(newText: String?): Boolean {
				filterList(newText)
				return true
			}
		})
		
		categoriesRecyclerView = findViewById(R.id.cat_rv)
		
		categoriesAdapter = CategoriesAdapter(categories = categories, context = this){ category ->
//			selectedCategory = category
			filterServicesItems(category)
		}
		categoriesRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
		categoriesRecyclerView.adapter = categoriesAdapter
		
		servicesRecyclerView = findViewById(R.id.serv_rv)
		servicesAdapter = ServicesAdapter(services)
		servicesRecyclerView.layoutManager = GridLayoutManager(this, 3)
		servicesRecyclerView.adapter = servicesAdapter
	}
	
	private fun filterList(cat: String?){
		if (cat != null){
			val filteredServices = ArrayList<Services>()
			for (service in services){
				if (service.title.lowercase(Locale.ROOT).contains(cat.lowercase())){
					filteredServices.add(service)
				}
			}
			servicesAdapter.setFilteredServices(filteredServices)
		}
	}
	
	private fun filterServicesItems(selectedCategory: String) {
		val filteredItems = if (selectedCategory == "All") {
			services
		} else {
			services.filter { it.category == selectedCategory }
		}
		servicesAdapter = ServicesAdapter(filteredItems)
		servicesRecyclerView.adapter = servicesAdapter
	}
}