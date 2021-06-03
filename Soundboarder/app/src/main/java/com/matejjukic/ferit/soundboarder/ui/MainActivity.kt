package com.matejjukic.ferit.soundboarder.ui


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.matejjukic.ferit.soundboarder.R
import com.matejjukic.ferit.soundboarder.databinding.ActivityMainBinding
import com.matejjukic.ferit.soundboarder.sounds.AudioPlayer
import org.koin.android.ext.android.inject


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageButtons: List<ImageButton>
    private val audioPlayer by inject<AudioPlayer>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
    }

    private fun setupUI() {
        binding.apply {
            imageButtons = listOf(ibMacka, ibPas)
            imageButtons.forEach { imageButton -> imageButton.setOnClickListener { onImageClick(it.id) } }
        }
    }
    private fun onImageClick(id: Int) {
        when(id) {
            R.id.ib_macka -> audioPlayer.playSound(R.raw.cat)
            R.id.ib_pas -> audioPlayer.playSound(R.raw.dog)
        }
    }
}
