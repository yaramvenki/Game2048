package com.example.game2048

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    var board = arrayOf<Array<Int>>()
    private lateinit var gameManager:GameManager
    private lateinit var tvScore : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = recyclerView
        val clMain: ConstraintLayout = clMain
        //Default score we are displaying
        tvScore = findViewById(R.id.tvScoreVal)
        tvScore.setText("0")
        board = Array(4) { i -> Array(4) { j -> 0} }
        //Setting default values
        board[1][1] = 2
        board[2][2] = 2

        gameManager = GameManager()

        plotNumbersOnBoard()

        recyclerView.setOnTouchListener(object : SwipeTouchListener(this@MainActivity) {
            override fun onSwipeLeft() {
                super.onSwipeLeft()
                board = gameManager.handleLeftSwipe(board)
                tvScore.setText("${gameManager.score}")

                if(board[0][3] == 0){
                    board[0][3] = 2
                }
                plotNumbersOnBoard()

            }

            override fun onSwipeRight() {
                super.onSwipeRight()
//                gameManager.handleRightSwipe(board)
                plotNumbersOnBoard()
            }

            override fun onSwipeUp() {
                super.onSwipeUp()
                plotNumbersOnBoard()
            }

            override fun onSwipeDown() {
                super.onSwipeDown()
                plotNumbersOnBoard()
            }
        })
    }

    fun plotNumbersOnBoard(){

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

    fun generateRandomPosition(){
        //Need to implement fully
    }
}