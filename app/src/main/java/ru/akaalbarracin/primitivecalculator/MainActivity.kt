package ru.akaalbarracin.primitivecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val maintext = findViewById<TextView>(R.id.maintext)
        maintext.text = "Primitive calculator by Albarracin"
        val charDiv = '/'
        val result = findViewById<TextView>(R.id.resultTextView)
        val body = findViewById<TextView>(R.id.bodyTextView)


//        MAP TO USE
        val buttonNumber0 = findViewById<Button>(R.id.buttonNumber0)
        val buttonNumber1 = findViewById<Button>(R.id.buttonNumber1)
        val buttonNumber2 = findViewById<Button>(R.id.buttonNumber2)
        val buttonNumber3 = findViewById<Button>(R.id.buttonNumber3)
        val buttonNumber4 = findViewById<Button>(R.id.buttonNumber4)
        val buttonNumber5 = findViewById<Button>(R.id.buttonNumber5)
        val buttonNumber6 = findViewById<Button>(R.id.buttonNumber6)
        val buttonNumber7 = findViewById<Button>(R.id.buttonNumber7)
        val buttonNumber8 = findViewById<Button>(R.id.buttonNumber8)
        val buttonNumber9 = findViewById<Button>(R.id.buttonNumber9)

        val buttonComma = findViewById<Button>(R.id.buttonComma)
        val buttonDelete = findViewById<Button>(R.id.buttonDelete)
        val buttonEquals = findViewById<Button>(R.id.buttonEquals)
        val buttonPlus = findViewById<Button>(R.id.buttonPlus)
        val buttonMinus = findViewById<Button>(R.id.buttonMinus)
        val buttonCdot = findViewById<Button>(R.id.buttonCdot)
        val buttonDiv = findViewById<Button>(R.id.buttonDiv)
        val buttonMod = findViewById<Button>(R.id.buttonMod)
        val buttonSkobki = findViewById<Button>(R.id.buttonSkobki)
        val buttonClear = findViewById<Button>(R.id.buttonClear)
        var operationCount: Short = 0

        fun makeResult(): String {
            val error = Toast.makeText(this, "result is infinity or incorrect", Toast.LENGTH_LONG)
            // using library exp4j (take string get result) (it's say me Tigran)
            if (body.text != "") {
                try {
                    val localResult: Double =
                        ExpressionBuilder(body.text.toString()).build().evaluate()
                    if (localResult.toInt().toDouble() == localResult) {
//                        result.text = localResult.toInt().toString()
                        return localResult.toInt().toString()

                    } else {
//                        result.text = localResult.toString()
                        return localResult.toString()
                    }
                } catch (e: Exception) {
//                    error.show()
                    return ""
                }
            }
            return ""
        }

        buttonNumber0.setOnClickListener {
            body.text = "${body.text}0"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber1.setOnClickListener {
            body.text = "${body.text}1"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber2.setOnClickListener {
            body.text = "${body.text}2"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber3.setOnClickListener {
            body.text = "${body.text}3"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber4.setOnClickListener {
            body.text = "${body.text}4"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber5.setOnClickListener {
            body.text = "${body.text}5"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber6.setOnClickListener {
            body.text = "${body.text}6"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber7.setOnClickListener {
            body.text = "${body.text}7"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber8.setOnClickListener {
            body.text = "${body.text}8"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonNumber9.setOnClickListener {
            body.text = "${body.text}9"
            if (operationCount > 0) result.text = makeResult()
        }
        buttonDelete.setOnClickListener {
            if (body.text.toString().length > 0) {
                val lastChar = body.text.substring(
                    body.text.toString().lastIndex,
                    body.text.toString().lastIndex + 1
                )
                if (lastChar == '+'.toString() || lastChar == '-'.toString() || lastChar == '*'.toString() || lastChar == charDiv.toString()) {
                    operationCount--
                }
                body.text = body.text.toString().substring(0, body.text.toString().lastIndex)
            }
            if (operationCount > 0) result.text = makeResult()
        }
        buttonClear.setOnClickListener {
            body.text = ""
            result.text = ""
        }
        buttonComma.setOnClickListener {
            body.text = "${body.text},"
        }
        buttonPlus.setOnClickListener {
            body.text = "${body.text}+"
            operationCount++
        }
        buttonMinus.setOnClickListener {
            body.text = "${body.text}-"
            operationCount++
        }
        buttonCdot.setOnClickListener {
            body.text = "${body.text}*"
            operationCount++
        }
        buttonDiv.setOnClickListener {
            body.text = "${body.text}$charDiv"
            operationCount++
        }
        buttonMod.setOnClickListener {
            body.text = "${body.text}%"
            operationCount++
        }
        buttonSkobki.setOnClickListener {

            if (body.text.toString().length > 0) {
                val ArrayOfText = body.text.toString().toCharArray().toTypedArray()
                val lastChar = ArrayOfText[ArrayOfText.lastIndex]
                if (lastChar == '+' ||
                    lastChar == '-' ||
                    lastChar == '*' ||
                    lastChar == charDiv ||
                    lastChar == '('
                ) {
                    body.text = "${body.text}("
                } else {
                    body.text = "${body.text})"
                    if (operationCount > 0) result.text = makeResult()
                }
            }else{
                body.text = "${body.text}("
            }
        }

        buttonEquals.setOnClickListener {
            if (result.text != "") {
                body.text = result.text
                result.text = ""
            }
        }

    }
}