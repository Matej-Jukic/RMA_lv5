package com.matejjukic.ferit.soundboarder.sounds

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import com.matejjukic.ferit.soundboarder.R

class SoundPoolPlayer(context: Context) : AudioPlayer {

    private val priority: Int = 1
    private val maxStreams: Int = 2
    private val leftVolume = 1f
    private val rightVolume = 1f
    private val shouldLoop = 0
    private val playbackRate = 1f

    private val soundPool: SoundPool

    private var soundLoaded: Boolean = false
    var soundMap: HashMap<Int, Int> = HashMap()

    init {

        val audioAttributes = AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .setUsage(AudioAttributes.USAGE_GAME)
            .build()
        soundPool = SoundPool.Builder()
            .setAudioAttributes(audioAttributes)
            .setMaxStreams(maxStreams)
            .build()
        soundMap[R.raw.cat] = soundPool.load(context, R.raw.cat, priority)
        soundMap[R.raw.dog] = soundPool.load(context, R.raw.dog, priority)
        soundPool.setOnLoadCompleteListener { _, _, _ -> soundLoaded = true }
    }

    override fun playSound(id: Int) {
        if (soundLoaded)
            when (id) {
                R.raw.cat -> soundPool.play(
                    soundMap[id]!!,
                    leftVolume,
                    rightVolume,
                    priority,
                    shouldLoop,
                    playbackRate
                )
                R.raw.dog -> soundPool.play(
                    soundMap[id]!!,
                    leftVolume,
                    rightVolume,
                    priority,
                    shouldLoop,
                    playbackRate
                )
            }
    }
}