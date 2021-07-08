package com.example.game2048

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = recyclerView
        val clMain: ConstraintLayout = clMain

        val numbers = mutableListOf(
            0, 2, 0, 4, 8, 16, 32, 0, 64, 128, 0, 256, 512, 1024, 0, 2048
        )

        GridLayoutManager(
            this,
            4,
            RecyclerView.VERTICAL,
            false
        ).apply {
            recyclerView.layoutManager = this
        }

        recyclerView.adapter = GameAdapter(numbers, this)



        recyclerView.setOnTouchListener(object : SwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                Toast.makeText(
                    this@MainActivity, "Swipe Left gesture detected",
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

            override fun onSwipeRight() {
                super.onSwipeRight()
                Toast.makeText(
                    this@MainActivity,
                    "Swipe Right gesture detected",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onSwipeUp() {
                super.onSwipeUp()
                Toast.makeText(this@MainActivity, "Swipe up gesture detected", Toast.LENGTH_SHORT)
                    .show()
            }

            override fun onSwipeDown() {
                super.onSwipeDown()
                Toast.makeText(this@MainActivity, "Swipe down gesture detected", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
}