package edu.farmingdale.alrajab.bcs421

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import edu.farmingdale.alrajab.bcs421.databinding.ActivitySharedPreferencesBinding

class SharedPreferencesActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveData.setOnClickListener {
            val firstName = binding.firstName.text.toString()
            val lastName = binding.lastName.text.toString()
            saveDataToSharedPreferences(firstName, lastName)
        }

        binding.loadData.setOnClickListener {
            val savedFirstName = loadDataFromSharedPreferences("firstName")
            val savedLastName = loadDataFromSharedPreferences("lastName")
            binding.displayData.text = "First Name: $savedFirstName\nLast Name: $savedLastName"
        }
    }

    private fun saveDataToSharedPreferences(firstName: String, lastName: String) {
        val sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString("firstName", firstName)
        editor.putString("lastName", lastName)
        editor.apply()
    }

    private fun loadDataFromSharedPreferences(key: String): String {
        val sharedPref = getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
        return sharedPref.getString(key, "") ?: ""
    }
}

