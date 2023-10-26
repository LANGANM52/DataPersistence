package edu.farmingdale.alrajab.bcs421

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.farmingdale.alrajab.bcs421.database.DatabaseActivity
import edu.farmingdale.alrajab.bcs421.databinding.ActivityMainBinding
import edu.farmingdale.alrajab.bcs421.files.FileActivity

class MainActivity : AppCompatActivity() {

    // create binding view true - make sure to add it to the module build.gradle
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.databaseBtn.setOnClickListener {  processDatabase()}

        binding.filesBtn.setOnClickListener { processFiles() }

        binding.sharedBtn.setOnClickListener { processSharedPreferences() }

    }

    /**
     * Move to the file activity
     */
    private fun processFiles() {
        startActivity( Intent(this, FileActivity::class.java) )
    }

    /**
     * Move to the database activity
     */
    private fun processDatabase() {
        startActivity( Intent(this, DatabaseActivity::class.java) )
    }
    /**
     * Move to the Shared Preferences activity
     */
    private fun processSharedPreferences() {
        startActivity(Intent(this, SharedPreferencesActivity::class.java))
    }
}