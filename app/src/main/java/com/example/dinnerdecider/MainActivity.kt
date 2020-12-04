package com.example.dinnerdecider

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlinx.android.synthetic.main.activity_main.transfer

class MainActivity : AppCompatActivity() {

    private val foodList = arrayListOf(
        "Burger", "Maultaschen",
        "Khachapuri", "Minestrone", "Moussaka",
        "Pizza", "Gyros", "Chicken Wrap", "Spaghetti Carbonara",
        "Käsespätzle", "Chicken Wings", "Spaghetti Bolognese",
        "Butter Chicken", "Schnitzel", "Gemüse Stir Fry",
        "Hähnchen Süß-Sauer", "Ramen", "Mix Vegetables",
        "Knusprige Ente", "Shahi Paneer", "Pasta Alio e Oglio",
        "Pasta Al Pomodoro", "Risotto", "Lasagne",
        "Pizza Napoli", "Saltim Bocca"
    )
    // Liste aus welcher die Gerichte random herausgezogen werden


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        decideBtn.setOnClickListener {
            //Aktion die ausgeführt werden soll wenn man auf gelben Button drückt

            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            //Array wird gezählt um random Nummer im Array Bereich zu erzeugen
            selectedFoodTxt.text = foodList[randomFood]
            // zuweisen des inhalts von selectedFoodTxt.text
            Toast.makeText(applicationContext, "Heute gibt es " + selectedFoodTxt.text + "!",Toast.LENGTH_SHORT).show()
        }


        transfer.setOnClickListener{
            val cont = selectedFoodTxt.text
            val intent = Intent (this, YTActivity::class.java)
            intent.putExtra(YTActivity.FOOD_Name, cont)
            startActivity(intent)
        }
    }
}