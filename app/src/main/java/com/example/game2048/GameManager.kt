package com.example.game2048

class GameManager {
    fun convertArrayToList(arr: Array<Array<Int>>) : MutableList<Int>{
        val cellValList = mutableListOf(
            arr[0][0], arr[0][1], arr[0][2],arr[0][3],
            arr[1][0], arr[1][1], arr[1][2], arr[1][3],
            arr[2][0], arr[2][1], arr[2][2], arr[2][3],
            arr[3][0], arr[3][1], arr[3][2], arr[3][3])
        return cellValList
    }
}