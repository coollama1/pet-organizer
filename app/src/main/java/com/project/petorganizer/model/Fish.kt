package com.project.petorganizer.model

data class Fish(val fishName : String , val fishAge : Int, val fishAllergies : String, val fishPersonality : String) : Pet(fishName,AnimalSpecies.FISH,fishAge, fishAllergies,fishPersonality) {
    override fun eatFood(): String {
        return "Glub Glub, I'm eating my yummy snacks"
    }
    override fun toString() : String {
        return super.toString()
    }
}