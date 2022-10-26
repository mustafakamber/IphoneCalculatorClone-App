package com.mustafakamber.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.mustafakamber.mycalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
    fun clickedNumber(view : View){
        if(newOperator){
            binding.proccessText.setText("")
        }
        newOperator = false
        var chosenButton = view as Button
        var clickedtheNumber : String = binding.proccessText.text.toString()
        when(chosenButton.id){
            binding.buttonZero.id ->{
                clickedtheNumber+="0"
            }
            binding.buttonOne.id ->{
                clickedtheNumber+="1"
            }
            binding.buttonTwo.id ->{
                clickedtheNumber+="2"
            }
            binding.buttonThree.id ->{
                clickedtheNumber+="3"
            }
            binding.buttonFour.id ->{
                clickedtheNumber+="4"
            }
            binding.buttonFive.id ->{
                clickedtheNumber+="5"
            }
            binding.buttonSix.id ->{
                clickedtheNumber+="6"
            }
            binding.buttonSeven.id ->{
                clickedtheNumber+="7"
            }
            binding.buttonEight.id ->{
                clickedtheNumber+="8"
            }
            binding.buttonNine.id ->{
                clickedtheNumber+="9"
            }
            binding.buttonPM.id ->{
                clickedtheNumber = "-" + clickedtheNumber
            }
            binding.buttonPoint.id ->{
                clickedtheNumber = clickedtheNumber + "."
            }
        }
        binding.proccessText.setText(clickedtheNumber)
    }
    var operator = "*"
    var oldNumber = ""
    var newOperator = true
    fun clickedProccess(view : View){
        var chosenProcess = view as Button
        when(chosenProcess.id){
            binding.buttonDivide.id->{
                operator = "/"
            }
            binding.buttonMultiply.id->{
                operator = "x"
            }
            binding.buttonSubtraction.id->{
                operator = "-"
            }
            binding.buttonAddition.id->{
                operator = "+"
            }
            binding.buttonPercent.id->{
                operator = "%"
            }
        }
        oldNumber = binding.proccessText.text.toString()
        newOperator = true
    }
    fun clickedEqual(view : View){
        var newNumber = binding.proccessText.text.toString()
        var resultNumber:Double?=null
        when(operator){
            "/"->{
                resultNumber=oldNumber.toDouble()/newNumber.toDouble()
            }
            "x"->{
                resultNumber=oldNumber.toDouble()*newNumber.toDouble()
            }
            "-"->{
                resultNumber=oldNumber.toDouble()-newNumber.toDouble()
            }
            "+"->{
                resultNumber=oldNumber.toDouble()+newNumber.toDouble()
            }
            "%"->{
                resultNumber=oldNumber.toDouble()*(newNumber.toDouble())/100
            }
        }
        binding.proccessText.setText(resultNumber.toString())
        newOperator = true
    }
    fun clickedAC(view : View){
        binding.proccessText.setText("0")
        newOperator = true
    }

}