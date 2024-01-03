package com.project.petorganizer.model

data class Hamster(val hamsterName : String, val hamsterAge : Int, val hamsterAllergies : String, val hamsterPersonality : String) : Pet(hamsterName,AnimalSpecies.HAMSTER,hamsterAge, hamsterAllergies, hamsterPersonality) {
    override fun eatFood(): String {
        return "*nibble* good food *nibble*"
    }
    override fun toString() : String {
        return super.toString()
    }
}