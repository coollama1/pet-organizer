package com.project.petorganizer.model

data class Dog(val dogName : String, val dogAge : Int, val dogAllergies : String, val dogPersonality : String) : Pet (dogName, AnimalSpecies.DOG, dogAge, dogAllergies, dogPersonality) {
    override fun eatFood(): String {
        return "Woof, I'm eating food!"
    }
    override fun toString() : String {
        return super.toString()
    }
}