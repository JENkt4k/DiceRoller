package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)

        //rollButton.text = "Let's Roll"

        rollButton.setOnClickListener {
            rollDice()
        }

        var defaultImage = resources.getString(R.string.DiceValue)
        diceImage = findViewById(R.id.dice_image)
        diceImage.setImageResource(getDiceResource(defaultImage.toInt()))
    }

    private inline fun getDiceResource(resrouce:Int) :Int{
        return when (resrouce){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6
        }
    }

    private fun rollDice() {

/*        val randomInt = Random.nextInt(6)+1
        val drawableResource =  when (randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.dice_6

        }*/
        diceImage.setImageResource(getDiceResource(Random.nextInt(6)+1))

    }


}
