package com.example.puzzlecrime.ui

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Binder
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.davemorrissey.labs.subscaleview.ImageSource
import com.example.puzzlecrime.App
import com.example.puzzlecrime.MainActivity
import com.example.puzzlecrime.R
import com.example.puzzlecrime.databinding.FragmentDecryp5Binding
import com.example.puzzlecrime.ui.dialog.InputPasscodeDialog
import kotlinx.coroutines.*

class DecrypFragment5 : Fragment() {

    lateinit var binding:FragmentDecryp5Binding
    val args:DecrypFragment5Args by navArgs()
    lateinit var mediaPlayer: MediaPlayer
    lateinit var runnable:Runnable
    private var handler : Handler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_decryp_5,container,false)
        mediaPlayer = MediaPlayer.create(activity,R.raw.mp3stage6)
        binding.picStage51.setImage(ImageSource.resource(R.drawable.picstage6_1))
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.seekBar.max = mediaPlayer.duration
        onClickFloatButton()
        setupMedia()
    }
    fun onClickFloatButton(){
        binding.floatingActionButton5.setOnClickListener {
            val dialog = InputPasscodeDialog(args.stage,binding.titleStage5.text.toString())
            dialog.isCancelable = false
            dialog.show(requireActivity().supportFragmentManager,"InputPasscodeDialog")
        }
    }
    fun setupMedia(){
        binding.playBtn.setOnClickListener {
            if(!mediaPlayer.isPlaying){
                binding.playBtn.setImageResource(R.drawable.ic_baseline_pause_24)
                CoroutineScope(Dispatchers.Default).launch {
                    mediaPlayer.start()
                }
            }
            else{
                mediaPlayer.pause()
                binding.playBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            }
        }


        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.seekTo(seekBar!!.progress)
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                mediaPlayer.seekTo(seekBar!!.progress)
            }
        })


        CoroutineScope(Dispatchers.Default).launch {
            runnable = Runnable{
                binding.seekBar.progress = mediaPlayer.currentPosition
                handler.postDelayed(runnable,1000)
            }
            handler.postDelayed(runnable,1000)
        }


        mediaPlayer.setOnCompletionListener {
            binding.seekBar.progress = 0
            binding.playBtn.setImageResource(R.drawable.ic_baseline_play_arrow_24)
            Log.i("Test",binding.seekBar.progress.toString())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        //mediaPlayer.reset()
    }
}