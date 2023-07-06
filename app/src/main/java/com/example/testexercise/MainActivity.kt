package com.example.testexercise

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.testexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val list = mutableListOf<String>()
    private var itemId = 0
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)
        binding.listView.adapter = adapter

        binding.btnAdd.setOnClickListener {
            list.add(binding.etText.text.toString().trim())
            adapter.notifyDataSetChanged()
            binding.etText.text.clear()
        }

        binding.listView.setOnItemClickListener { parent, view, position, id ->
            binding.etText.setText(list[position])
            list.removeAt(position)
            adapter.notifyDataSetChanged()
//            itemId = position
//            binding.btnUpdate.visibility = View.VISIBLE
        }

        binding.listView.setOnItemLongClickListener { parent, view, position, id ->
            list.removeAt(position)
            adapter.notifyDataSetChanged()
            true
        }

//        binding.btnUpdate.setOnClickListener {
//            val text = binding.etText.text.toString().trim()
//            list[itemId] = text
//            adapter.notifyDataSetChanged()
//            binding.etText.text.clear()
//            binding.btnUpdate.visibility = View.GONE
//        }
    }
}