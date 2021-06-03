package com.matejjukic.ferit.soundboarder.di


import com.matejjukic.ferit.soundboarder.sounds.SoundPoolPlayer
import com.matejjukic.ferit.soundboarder.sounds.AudioPlayer

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {

    single<AudioPlayer> { SoundPoolPlayer(androidContext()) }

}