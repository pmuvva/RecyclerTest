package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.test.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var  binding:ActivityMainBinding
    private val adapter = TitleListAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       //two buttons 1: API (Aadding user) 2. Delete last user
        //display : Title-FName-LName (MVVM)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.buttonApi.setOnClickListener { setTitleList() }
        binding.buttonDelete.setOnClickListener { deleteListItem() }

    }

    private fun deleteListItem() {
        adapter.deleteListItem()
    }

    private fun setTitleList(){

        var  titleViewModel = ViewModelProviders.of(this,
        TitleViewModelFactory(this@MainActivity))[TitleViewModel::class.java]

        binding.rvtitle.layoutManager = LinearLayoutManager(this)
        binding.rvtitle.adapter = adapter


        titleViewModel.getTitleList().observe(this){ response ->
            response?.let{

                adapter.setDataTile(response as MutableList<NameResponse>)
                adapter.notifyDataSetChanged()
            }
        }
    }
}

//dsanchez197694@gmail.com  //david