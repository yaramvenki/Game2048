package com.example.game2048

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var board = arrayOf<Array<Int>>()
    private lateinit var gameManager:GameManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = recyclerView
        val clMain: ConstraintLayout = clMain
        board = Array(4) { i -> Array(4) { j -> 0} }
        gameManager = GameManager()

        plotNumbersOnBoard()
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

    fun plotNumbersOnBoard(){
        board[0][1] = 2
        board[0][3] = 4
        board[1][0] = 8
        board[1][2] = 16
        board[2][1] = 32
        board[2][3] = 128
        board[3][0] = 256
        board[3][2] = 512

        GridLayoutManager(
            this,
            4,
            RecyclerView.VERTICAL,
            false
        ).apply {
            recyclerView.layoutManager = this
        }

        recyclerView.adapter = GameAdapter(gameManager.convertArrayToList(board), this)
    }
}