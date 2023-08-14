package com.example.retrofitresourcesofstarwars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.retrofitresourcesofstarwars.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val retrofit = Retrofit.Builder()
            .baseUrl("https://swapi.dev/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
        val starWarsApiService = retrofit.create(StarWarsApiService::class.java)

        binding.button.setOnClickListener{

            CoroutineScope(Dispatchers.IO).launch {
                val person = starWarsApiService.searchCharacters(1)
                runOnUiThread {
                    binding.name.text = person.name
                }
            }
        }




    }
}