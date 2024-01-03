package com.project.petorganizer.model

import com.project.petorganizer.MainActivity
import com.project.petorganizer.MainActivity.Companion.toTitleCase

enum class AnimalSpecies {
    CAT, DOG, HAMSTER, TURTLE, FISH;

    override fun toString(): String {
        return toTitleCase(super.toString())
    }


}