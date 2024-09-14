package com.example.epayassignment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.epayassignment.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
	
	private lateinit var binding: ActivityMainBinding
	private lateinit var categoriesRV: RecyclerView
	private lateinit var servicesRV: RecyclerView
	
	private lateinit var servicesAdapter: FindServiceAdapter
	private lateinit var categoriesAdapter: GridAdapter
	
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
		
		val services = listOf(
			Services(
				title = "MTN",
				icon = R.drawable.mtn,
			),
			Services(
				icon = R.drawable.ecg,
				title = "Electricity"
			),
			Services(
				icon = R.drawable.dstv,
				title = "DStv"
			),
			Services(
				title = "GOtv",
				icon = R.drawable.gotv,
			),
			Services(
				icon = R.drawable.at_logo,
				title = "Airtel Tigo"
			),
			Services(
				icon = R.drawable.voda,
				title = "Vodafone"
			),
			Services(
				title = "MTN",
				icon = R.drawable.mtn,
			),
			Services(
				icon = R.drawable.ecg,
				title = "Electricity"
			),
			Services(
				icon = R.drawable.dstv,
				title = "DStv"
			),
			Services(
				title = "GOtv",
				icon = R.drawable.gotv,
			),
			Services(
				icon = R.drawable.at_logo,
				title = "Airtel Tigo"
			),
			Services(
				icon = R.drawable.voda,
				title = "Vodafone"
			),
			Services(
				title = "MTN",
				icon = R.drawable.mtn,
			),
			Services(
				icon = R.drawable.ecg,
				title = "Electricity"
			),
			Services(
				icon = R.drawable.dstv,
				title = "DStv"
			),
			Services(
				title = "GOtv",
				icon = R.drawable.gotv,
			),
			Services(
				icon = R.drawable.at_logo,
				title = "Airtel Tigo"
			),
			Services(
				icon = R.drawable.voda,
				title = "Vodafone"
			),
			Services(
				title = "MTN",
				icon = R.drawable.mtn,
			),
			Services(
				icon = R.drawable.ecg,
				title = "Electricity"
			),
			Services(
				icon = R.drawable.dstv,
				title = "DStv"
			),
			Services(
				title = "GOtv",
				icon = R.drawable.gotv,
			),
			Services(
				icon = R.drawable.at_logo,
				title = "Airtel Tigo"
			),
			Services(
				icon = R.drawable.voda,
				title = "Vodafone"
			),
		)
		
		val categories = listOf(
			Categories(
				title = "All"
			),
			Categories(
				icon = R.drawable.group_2928,
				title = "Airtime Top"
			),
			Categories(
				icon = R.drawable.internet,
				title = "Internet"
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
		
		servicesRV = findViewById(R.id.row_rv)
		servicesAdapter = FindServiceAdapter(categories)
		servicesRV.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
		servicesRV.adapter = servicesAdapter
		
		categoriesRV = findViewById(R.id.grid_rv)
		categoriesAdapter = GridAdapter(services)
		categoriesRV.layoutManager = GridLayoutManager(this, 3)
		categoriesRV.adapter = categoriesAdapter
		
	}
}