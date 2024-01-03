package com.project.petorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.petorganizer.data.EXTRA_PET_POSITION
import com.project.petorganizer.data.PetManager

class PetOrganizerHome : AppCompatActivity() {

    private lateinit var toolbar : Toolbar
    private lateinit var addPetButton : FloatingActionButton
    private lateinit var petsList : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_organizer_home)
        initializeValues()
        setSupportActionBar(toolbar)

        addPetButton.setOnClickListener{
            startAddPetActivity()
        }

        petsList.adapter = ArrayAdapter(this,
            android.R.layout.simple_expandable_list_item_1,
            PetManager.pets)

        petsList.setOnItemClickListener{ _, _, position, _ ->
            startViewPetActivity(position)
        }
    }

    private fun initializeValues(){
        toolbar = findViewById(R.id.homeToolbar)
        addPetButton = findViewById(R.id.newPetButton)
        petsList = findViewById(R.id.petsList)
    }

    private fun startAddPetActivity(){
        val newActivityIntent = Intent (this, MainActivity::class.java)
        startActivity(newActivityIntent)
    }


    private fun startViewPetActivity(position : Int){
        val startViewActivityIntent = Intent(this, ViewPetActivity::class.java)
        startViewActivityIntent.putExtra(EXTRA_PET_POSITION, position)
        startActivity(startViewActivityIntent)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.addPetMenuItem ->{
                startAddPetActivity()
                return true
            }
            else-> return false
        }
    }
}