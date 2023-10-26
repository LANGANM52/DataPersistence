package edu.farmingdale.alrajab.bcs421.files

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import edu.farmingdale.alrajab.bcs421.MainActivity
import edu.farmingdale.alrajab.bcs421.database.NameRepository
import edu.farmingdale.alrajab.bcs421.database.User
import edu.farmingdale.alrajab.bcs421.databinding.ActivityFileBinding
import java.io.PrintWriter

class FileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFileBinding
    private lateinit var dbHelper: NameRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dbHelper = NameRepository.getInstance(this)
        binding = ActivityFileBinding.inflate(layoutInflater )
        setContentView(binding.root)


        binding.writeToFile.setOnClickListener { writeToInternalFile() }
        binding.readFromFile.setOnClickListener { readFromInternalFile() }

        binding.goBackBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    private fun readFromInternalFile() {
        val inputStream = openFileInput("myfile")
        val reader = inputStream.bufferedReader()

        // Read first name and last name from separate lines
        val firstName = reader.readLine()
        val lastName = reader.readLine()

        if (firstName != null && lastName != null) {
            dbHelper.addUser(User(firstName, lastName))
        }

        // Update the UI or perform other actions based on the read data
        binding.textOfFile.text = "First Name: $firstName\nLast Name: $lastName"
    }

    private fun writeToInternalFile() {
        val outputStream = openFileOutput("myfile", MODE_PRIVATE)
        val writer = PrintWriter(outputStream)

        // Get first name and last name from the user input fields
        val firstName = binding.firstName.text.toString()
        val lastName = binding.lastName.text.toString()

        // Write first name and last name on separate lines
        writer.println(firstName)
        writer.println(lastName)

        writer.close()
    }




}