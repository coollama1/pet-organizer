package com.project.petorganizer.model

data class Cat(val catName : String, val catAge : Int, val catAllergies : String, val catPersonality : String) : Pet(catName,AnimalSpecies.CAT,catAge, catAllergies, catPersonality) {
    override fun eatFood(): String {
        return "Meow, I'm eating food..."
    }
    override fun toString() : String {
        return super.toString()
    }
}