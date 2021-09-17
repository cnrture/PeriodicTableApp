package com.canerture.periodictableapp

import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.canerture.periodictableapp.adapter.ElementAdapter
import com.canerture.periodictableapp.adapter.ElementRecyclerItem
import com.canerture.periodictableapp.databinding.ActivityMainBinding
import com.canerture.periodictableapp.util.ElementUtil
import com.squareup.picasso.Picasso
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity(), ElementAdapter.ClickedElementListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val elementColumnList = ArrayList<Any>()

        elementColumnList.addAll(ElementUtil.drawElementColumns())

        binding.apply {
            adapter = ElementAdapter(elementColumnList, this@MainActivity)
        }

        //android:textColor="@{context.getColor(elementModel.cardColor)}"

    }

    override fun onClickedElementListener(data: ElementRecyclerItem.Element, pos: Int) {

        val edcDesign = LayoutInflater.from(applicationContext)
            .inflate(R.layout.element_detail_card, null, false)
        val alertDialogBuilder = AlertDialog.Builder(this)
        alertDialogBuilder.setView(edcDesign)

        val elementNumber: TextView = edcDesign.findViewById(R.id.elementNumber)
        val elementName: TextView = edcDesign.findViewById(R.id.elementName)
        val elementAtomicMass: TextView = edcDesign.findViewById(R.id.elementAtomicMass)
        val elementElectronConfiguration: TextView =
            edcDesign.findViewById(R.id.elementElectronConfiguration)

        val elementImage: ImageView = edcDesign.findViewById(R.id.elementImage)
        elementNumber.text = data.elementNumber.toString()
        elementName.text = "${data.elementShortName} - ${data.elementName}"
        elementAtomicMass.text = data.elementAtomicMass
        elementElectronConfiguration.text = data.elementElectronConfiguration

        if (data.elementImage != "") {
            Picasso.get().load(data.elementImage).into(elementImage)
        } else {
            Picasso.get().load("https://www.burrosabio.net/wp-content/uploads/2018/09/Atomo.jpg")
                .into(elementImage)
        }

        val dialog = alertDialogBuilder.create()
        dialog.show()
        dialog.window?.attributes?.windowAnimations = R.style.AlertAnimation
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val displayRectangle = Rect()
        window?.decorView?.getWindowVisibleDisplayFrame(displayRectangle)
        dialog.window?.setLayout(
            ((displayRectangle.width() * 0.8f).roundToInt()),
            ((displayRectangle.height() * 0.7f).roundToInt())
        )

    }
}