package com.project.petorganizer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.petorganizer.data.DEFAULT_PET_POSITION
import com.project.petorganizer.data.EXTRA_PET_POSITION
import com.project.petorganizer.data.PetManager
import com.project.petorganizer.model.AnimalSpecies

class ViewPetActivity : AppCompatActivity() {

    private var petPosition = DEFAULT_PET_POSITION
    private val pets = PetManager.pets
    private lateinit var toolbar : Toolbar
    private lateinit var editPetButton : Button
    private lateinit var deletePetButton : Button
    private lateinit var homeButton : FloatingActionButton
    private lateinit var petSpinner : Spinner
    private lateinit var petNameText : TextView
    private lateinit var petAgeText : TextView
    private lateinit var petAllergiesText : TextView
    private lateinit var petPersonalityText : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pet)
        initializeValues()
        setSupportActionBar(toolbar)

        homeButton.setOnClickListener{
            startHomeActivity()
        }

        petPosition = intent.getIntExtra(EXTRA_PET_POSITION, DEFAULT_PET_POSITION)
        displayPetInfo()

        editPetButton.setOnClickListener{
            editPet()
        }

        deletePetButton.setOnClickListener{
            deletePet()
        }
    }

    private fun startHomeActivity(){
        val goToHomeIntent = Intent(this,PetOrganizerHome::class.java)
        startActivity(goToHomeIntent)
    }

    private fun startAddPetActivity(){
        val newActivityIntent = Intent (this, MainActivity::class.java)
        startActivity(newActivityIntent)
    }

    private fun initializeValues() {
        toolbar = findViewById(R.id.viewPetToolbar)
        homeButton = findViewById(R.id.viewHomeButton)
        editPetButton = findViewById(R.id.editPetButton)
        deletePetButton  = findViewById(R.id.deletePetButton)
        petSpinner = findViewById(R.id.viewPetSpeciesSpinner)

        petNameText = findViewById(R.id.viewPetNameText)
        petAgeText  = findViewById(R.id.viewPetAgeText)
        petAllergiesText  = findViewById(R.id.viewPetAllergiesText)
        petPersonalityText  = findViewById(R.id.viewPetPersonalityText)
    }

    private fun deletePet() {
        if(pets.isNotEmpty() && petPosition < pets.size ){
            pets.removeAt(petPosition)
        }
        startHomeActivity()
    }

    private fun editPet() {
        if(pets.isNotEmpty() && petPosition < pets.size ){
            val currentPet = pets[petPosition]
            currentPet.name = petNameText.text.toString()
            currentPet.age = petAgeText.text.toString().toInt()
            currentPet.allergies = petAllergiesText.text.toString()
            currentPet.personality = petPersonalityText.text.toString()

            startHomeActivity()
        }
    }

    private fun displayPetInfo() {
        if(pets.isNotEmpty() && petPosition < pets.size){
            val currentPet = pets[petPosition]

            petNameText.text = currentPet.name
            petAgeText.text = currentPet.age.toString()
            petAllergiesText.text = currentPet.allergies
            petPersonalityText.text = currentPet.personality

            val petAdapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item,
                AnimalSpecies.values())
            petAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            petSpinner.adapter = petAdapter
            val speciesPos = AnimalSpecies.values().indexOf(currentPet.species)
            petSpinner.setSelection(speciesPos)
            petSpinner.isEnabled = false
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
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
}