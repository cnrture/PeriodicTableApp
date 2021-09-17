package com.canerture.periodictableapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.periodictableapp.R
import com.canerture.periodictableapp.databinding.ElementColumnNumberBinding
import com.canerture.periodictableapp.databinding.ElementItemCardBinding

class ElementAdapter(
    val elementList: ArrayList<Any>,
    val clickedElementListener: ClickedElementListener
) : RecyclerView.Adapter<ElementViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ElementViewHolder {
        return when (viewType) {
            R.layout.element_item_card -> ElementViewHolder.ElementItemCardHolder(
                ElementItemCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            R.layout.element_column_number -> ElementViewHolder.ElementColumnNumberHolder(
                ElementColumnNumberBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
            else -> throw IllegalArgumentException("Invalid ViewType")


        }
    }

    override fun onBindViewHolder(holder: ElementViewHolder, position: Int) {
        when (holder) {
            is ElementViewHolder.ElementItemCardHolder -> holder.bind(
                clickedElementListener,
                elementList[position] as ElementRecyclerItem.Element,
                position
            )
            is ElementViewHolder.ElementColumnNumberHolder -> holder.bind(elementList[position] as ElementRecyclerItem.Column)
        }
    }

    override fun getItemCount() = elementList.size

    override fun getItemViewType(position: Int): Int {
        return when (elementList[position]) {
            is ElementRecyclerItem.Column -> R.layout.element_column_number
            is ElementRecyclerItem.Element -> R.layout.element_item_card
            else -> throw IllegalArgumentException("Invalid Data")
        }
    }

    interface ClickedElementListener {
        fun onClickedElementListener(data: ElementRecyclerItem.Element, pos: Int)
    }
}