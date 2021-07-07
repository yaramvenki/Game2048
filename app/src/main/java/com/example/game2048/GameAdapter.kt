package com.example.game2048

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.game2048.R.color.*
import kotlinx.android.synthetic.main.cell_item.view.*

class GameAdapter (private val cellValList: MutableList<Int>, val context: Context)
    : RecyclerView.Adapter<GameAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvCelValue: TextView = itemView.tvCellVal
        val clCell: ConstraintLayout = itemView.clCell
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.cell_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return cellValList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        when(cellValList[position]){
            0 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_default))
            2 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_2))
            4 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_4))
            8 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_8))
            16 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_16))
            32 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_32))
            64 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_64))
            128 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_128))
            256 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_256))
            512 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_512))
            1024 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_1024))
            2048 -> holder.clCell.setBackgroundColor(
                ContextCompat.getColor(context, color_2048))
        }

        if(cellValList[position] != 0){
            holder.tvCelValue.text = cellValList[position].toString()
        } else {
            holder.tvCelValue.text = ""
        }

    }

}