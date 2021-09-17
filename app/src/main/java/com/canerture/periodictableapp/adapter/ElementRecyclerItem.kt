package com.canerture.periodictableapp.adapter

sealed class ElementRecyclerItem {

    data class Column(
        var columnNumber: Int? = null
    ) : ElementRecyclerItem()

    data class Element(
        val elementNumber: Int? = null,
        val elementShortName: String? = null,
        val elementName: String? = null,
        val elementAtomicMass: String? = null,
        val elementElectronConfiguration: String? = null,
        val elementImage: String? = null,
        val cardColor: Int? = null,
        val isVisibile: Boolean? = null
    ) : ElementRecyclerItem()

}