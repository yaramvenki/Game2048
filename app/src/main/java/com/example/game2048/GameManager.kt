package com.example.game2048

import android.util.Log

class GameManager {
    var score  = 0
    fun convertArrayToList(arr: Array<Array<Int>>) : MutableList<Int>{
        return mutableListOf(
            arr[0][0], arr[0][1], arr[0][2], arr[0][3],
            arr[1][0], arr[1][1], arr[1][2], arr[1][3],
            arr[2][0], arr[2][1], arr[2][2], arr[2][3],
            arr[3][0], arr[3][1], arr[3][2], arr[3][3])
    }

    fun handleLeftSwipe(arr: Array<Array<Int>>) : Array<Array<Int>>{
        val row1 = arrayOf(arr[0][0], arr[0][1], arr[0][2], arr[0][3] )
        val row2 = arrayOf(arr[1][0], arr[1][1], arr[1][2], arr[1][3])
        val row3 = arrayOf(arr[2][0], arr[2][1], arr[2][2], arr[2][3])
        val row4 = arrayOf(arr[3][0], arr[3][1], arr[3][2], arr[3][3])

        for (i in 0..3){
            when(i){
                0 -> {
                    //{2, 2, 4, 0}
                    //{2, 4, 4, 0}
                    //{2, 4, 4, 4}

                    //4,4,0,8 -> 8,0,0,8 -> 8,8,0,0
                    //4,4,2,8 -> 8,0,2,8 -> 8,2,8,0
                    pushZerosToRight(row1, row1.size)
                    executeLeftLogic(row1)
                }

                1 -> {
                    pushZerosToRight(row2, row2.size)
                    executeLeftLogic(row2)
                }
                2 -> {
                    pushZerosToRight(row3, row3.size)
                    executeLeftLogic(row3)
                }
                3 -> {
                    pushZerosToRight(row1, row4.size)
                    executeLeftLogic(row4)
                }

            }
        }

        val board = Array(4) { i -> Array(4) { j -> 0} }
        board[0][0] = row1[0]
        board[0][1] = row1[1]
        board[0][2] = row1[2]
        board[0][3] = row1[3]

        board[1][0] = row2[0]
        board[1][1] = row2[1]
        board[1][2] = row2[2]
        board[1][3] = row2[3]

        board[2][0] = row3[0]
        board[2][2] = row3[1]
        board[2][2] = row3[2]
        board[2][3] = row3[3]

        board[3][0] = row4[0]
        board[3][1] = row4[1]
        board[3][2] = row4[2]
        board[3][3] = row4[3]

        return board
    }

    fun handleRightSwipe(arr: Array<Array<Int>>){
        val row1 = arrayOf(arr[0][0], arr[0][1], arr[0][2], arr[0][3] )
        val row2 = arrayOf(arr[1][0], arr[1][1], arr[1][2], arr[1][3])
        val row3 = arrayOf(arr[2][0], arr[2][1], arr[2][2], arr[2][3])
        val row4 = arrayOf(arr[3][0], arr[3][1], arr[3][2], arr[3][3])
        pushZerosToLeft(row1, row1.size)
        for (num in row1) {
            Log.d("Venki", "$num")
        }
    }

    fun handleBottomSwipe(arr: Array<Array<Int>>){

    }

    fun handleTopSwipe(arr: Array<Array<Int>>){

    }

    fun pushZerosToRight(arr: Array<Int>, n: Int) {
        var count = 0
        for (i in 0 until n){
            if (arr[i] != 0)
                arr[count++] = arr[i]
        }
        while (count < n) arr[count++] = 0
    }

    fun pushZerosToLeft(array: Array<Int>, n: Int) {
        var current = n - 1
        for (i in array.indices.reversed()) {
            if (array[i] != 0) {
                array[current] = array[i]
                current--
            }
        }

        while (current >= 0) {
            array[current] = 0
            current--
        }
    }

    fun executeLeftLogic(row1: Array<Int>){
        //2, 0, 0,2
        if (row1[0] != 0 && row1[1] != 0 && row1[0] == row1[1]) {
            row1[0] = row1[1] * 2
            score += row1[0]
            row1[1] = 0
            if (row1[2] != 0 && row1[3] != 0 && row1[2] == row1[3]) {
                row1[2] = row1[3] * 2
                score += row1[2]
                row1[3] = 0

                if (row1[1] == 0) {
                    row1[1] = row1[2]
                    row1[2] = 0
                }
            } else {
                if(row1[2] != 0){
                    row1[1] = row1[2]
                    if(row1[3] != 0){
                        row1[2] = row1[3]
                        row1[3] = 0
                    } else {
                        row1[2] = 0
                        row1[3] = 0
                    }

                } else if(row1[3] != 0){
                    row1[1] = row1[3]
                    row1[2] = 0
                    row1[3] = 0
                }
            }
        } else if(row1[1] != 0 && row1[2] != 0 && row1[1] == row1[2]){
            row1[1] = row1[2] * 2
            score += row1[1]
            row1[2] = 0

            if(row1[3] != 0){
                row1[2] = row1[3]
                row1[3] = 0
            }
        }
    }
}