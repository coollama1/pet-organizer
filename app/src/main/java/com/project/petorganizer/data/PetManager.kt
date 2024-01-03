package com.project.petorganizer.data

import com.project.petorganizer.model.AnimalSpecies
import com.project.petorganizer.model.Cat
import com.project.petorganizer.model.Dog
import com.project.petorganizer.model.Hamster
import com.project.petorganizer.model.Pet
import com.project.petorganizer.model.Turtle

object PetManager {
    val pets = ArrayList<Pet>()

    init{
        initializePets()
    }

    private fun initializePets() {
        val kitty = Cat("Kitty", 2,"Cinnamon","Friendly and affectionate")
        val doggy= Dog("Doggy", 3, "Chocolate", "Messy, Loves to run")
        val casper = Cat("Casper", 3, "Certain plants", "Needy and hungry")
        val turtle = Turtle("Torty",1, "None", "Slow")
        val hamster = Hamster("Hamy",3, "Lettuce", "Curious")
        pets.addAll(listOf(kitty,casper,doggy,turtle,hamster))
    }
}