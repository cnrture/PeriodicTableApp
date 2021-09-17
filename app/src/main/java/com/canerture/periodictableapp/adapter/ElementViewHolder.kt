package com.canerture.periodictableapp.adapter

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.canerture.periodictableapp.databinding.ElementColumnNumberBinding
import com.canerture.periodictableapp.databinding.ElementItemCardBinding

sealed class ElementViewHolder(binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    class ElementItemCardHolder(private val binding: ElementItemCardBinding) :
        ElementViewHolder(binding) {
        fun bind(
            elementClickedElementListener: ElementAdapter.ClickedElementListener,
            element: ElementRecyclerItem.Element,
            pos: Int
        ) {

            binding.apply {
                elementModel = element

                elementCardView.setOnClickListener {
                    elementClickedElementListener.onClickedElementListener(element, pos)
                }
            }
        }
    }

    class ElementColumnNumberHolder(private val binding: ElementColumnNumberBinding) :
        ElementViewHolder(binding) {
        fun bind(column: ElementRecyclerItem.Column) {
            binding.columnNumber = column.columnNumber
        }
    }

}
