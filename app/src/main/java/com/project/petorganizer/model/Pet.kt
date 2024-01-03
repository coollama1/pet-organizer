package com.project.petorganizer.model

import com.project.petorganizer.data.PetManager
import java.util.Arrays
import kotlin.streams.toList

open abstract class Pet (var name : String, var species : AnimalSpecies, var age : Int, var allergies : String, var personality : String) {
    open fun eatFood () : String {
        return "The pet is eating food!"
    }
    override fun toString(): String {
        return "$name, $age"
    }
    override fun equals(otherPet : Any?) : Boolean{
        if(otherPet is Pet){
            return (name == otherPet.name) && (species == otherPet.species) && (age == otherPet.age) && (allergies == otherPet.allergies) && (personality == otherPet.personality)
        }
        return false
    }
//CAT, DOG, HAMSTER, TURTLE, FISH
    companion object {
         fun createNewPet(species : String, name : String, age : Int, allergies : String, personality : String) : Pet? {
            val speciesList = Arrays.stream(AnimalSpecies.values()).map{ e -> e.toString()}.toList()
            val speciesIndex = speciesList.indexOf(species)
            return when (speciesIndex){
                    0 -> Cat(name,age,allergies,personality)
                    1 -> Dog(name,age,allergies,personality)
                    2 -> Hamster(name,age,allergies,personality)
                    3 -> Turtle(name,age,allergies,personality)
                    4 -> Fish(name,age,allergies,personality)
                    else -> null
            }
        }
    }
}