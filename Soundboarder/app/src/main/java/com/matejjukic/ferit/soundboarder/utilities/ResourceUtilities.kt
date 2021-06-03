package com.matejjukic.ferit.soundboarder.utilities

import com.matejjukic.ferit.soundboarder.R

fun getSound(number: Int): Int? {
    return when(number){
        1 -> R.raw.cat
        2 -> R.raw.dog
        else -> null
    }
}
