package com.project.petorganizer.model

data class Turtle(val turtleName : String, val turtleAge : Int, val turtleAllergies : String, val turtlePersonality : String) : Pet(turtleName,AnimalSpecies.TURTLE,turtleAge, turtleAllergies, turtlePersonality) {
    override fun eatFood(): String {
        return "..... I'm ... eating...  food ..."
    }
    override fun toString() : String {
        return super.toString()
    }
}