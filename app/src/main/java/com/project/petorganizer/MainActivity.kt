package com.project.petorganizer

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.petorganizer.data.PetManager
import com.project.petorganizer.model.AnimalSpecies
import com.project.petorganizer.model.Pet
import com.project.petorganizer.model.Pet.Companion.createNewPet


//ADD PET ACTIVITY

class MainActivity : AppCompatActivity() {

    private lateinit var toolbar : Toolbar
    private lateinit var homeButton : FloatingActionButton
    private lateinit var addButton : Button
    private lateinit var petSpinner : Spinner
    private lateinit var petNameText : TextView
    private lateinit var petAgeText : TextView
    private lateinit var petAllergiesText : TextView
    private lateinit var petPersonalityText : TextView
    private lateinit var pets : ArrayList<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeValues()
        setSupportActionBar(toolbar)

        val petAdapter = ArrayAdapter(this,
            android.R.layout.simple_spinner_item,
            AnimalSpecies.values())
        petAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        petSpinner.adapter = petAdapter

        homeButton.setOnClickListener{
            startHomeActivity()
        }

        addButton.setOnClickListener {
            addNewPet()
        }
    }

    companion object{
        fun toTitleCase (s : String ) : String {
            return s.substring(0,1).uppercase() + s.substring(1).lowercase()
        }
    }

    private fun initializeValues(){
        toolbar = findViewById(R.id.toolbar)
        homeButton = findViewById(R.id.fab)
        addButton = findViewById(R.id.addPetButton)
        petSpinner = findViewById(R.id.petSpinner)
        petNameText = findViewById(R.id.petNameText)
        petAgeText = findViewById(R.id.petAgeText)
        petAllergiesText = findViewById(R.id.petAllergiesText)
        petPersonalityText = findViewById(R.id.petPersonalityText)
        pets = PetManager.pets
    }

    private fun startHomeActivity(){
        val newActivityIntent = Intent (this, PetOrganizerHome::class.java)
        startActivity(newActivityIntent)
    }

    private fun startAddPetActivity(){
        val newActivityIntent = Intent (this, MainActivity::class.java)
        startActivity(newActivityIntent)
    }

    private fun addNewPet(){
        val petName = petNameText.text.toString()
        val petAge = petAgeText.text.toString().toInt()
        val petAllergies = petAllergiesText.text.toString()
        val petPersonality = petPersonalityText.text.toString()
        val petSpecies  = petSpinner.selectedItem.toString()
        val newPet = createNewPet(petSpecies,petName,petAge,petAllergies,petPersonality)
        if(newPet != null){
            pets.add(newPet)
        }
        startHomeActivity()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.homeMenuItem ->{
                startHomeActivity()
                return true
            }
            R.id.addPetMenuItem ->{
                startAddPetActivity()
                return true
            }
            else-> return false
        }
    }
    
/*
    // Activity Life Cycle
    // onCreate() -> onStart() -> onResume()
    // created    -> visible   -> foreground (user can see and interact with the activity)
    //                            onPause()  (no longer in the foreground)
    //                onStop() (no longer visible)
    //                onRestart() (gets called before onStart() when activity is exiting non visible to visible state)
    // onDestroy() (activity is destroyed)

    //onSaveInstanceState() -> called when activity is destroyed with the likelihood it will be recreated
    //                         allows for values to be saved and stored into a bundle which will
    //                         be passed to the activity when onCreate() is called
    //                         (ex: activities are destroyed and recreated when the screen is rotated
    //                         although values may seem consistent since the values displayed in the views are the same
    //                         the values in backend may be reset when onCreate() method is re called

    override fun onSaveInstanceState(outState : Bundle?) {
        super.onSaveInstanceState()
        outState?.putInt(integerName, integerVal) // example of how the state would be saved when activity is destroyed and recreated
    }

    //gets called whenever invalidateOptionsMenu() is called. reprocesses menu items
    override fun onPrepareOptionsMenu(menu : Menu?) : Boolean {
        val menuItem = menu?.findItem(R.id.homeMemuItem) // safe null call, works if the item is not null
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}