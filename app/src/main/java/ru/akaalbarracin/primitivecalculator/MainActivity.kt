package ru.akaalbarracin.primitivecalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {


    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val maintext = findViewById<TextView>(R.id.maintext)
        maintext.text = "Primitive calculator by Albarracin"
        val charDiv = '/'
        val textMap = mapOf<String, TextView>(
            "result" to findViewById(R.id.resultTextView), "body" to findViewById(R.id.bodyTextView)
        )

        val buttonMap = mapOf<String, Button>(
            "buttonNumber0" to findViewById(R.id.buttonNumber0),
            "buttonNumber1" to findViewById(R.id.buttonNumber1),
            "buttonNumber0" to findViewById(R.id.buttonNumber0),
            "buttonNumber1" to findViewById(R.id.buttonNumber1),
            "buttonNumber2" to findViewById(R.id.buttonNumber2),
            "buttonNumber3" to findViewById(R.id.buttonNumber3),
            "buttonNumber4" to findViewById(R.id.buttonNumber4),
            "buttonNumber5" to findViewById(R.id.buttonNumber5),
            "buttonNumber6" to findViewById(R.id.buttonNumber6),
            "buttonNumber7" to findViewById(R.id.buttonNumber7),
            "buttonNumber8" to findViewById(R.id.buttonNumber8),
            "buttonNumber9" to findViewById(R.id.buttonNumber9),
            "buttonComma" to findViewById(R.id.buttonComma),
            "buttonDelete" to findViewById(R.id.buttonDelete),
            "buttonEquals" to findViewById(R.id.buttonEquals),
            "buttonPlus" to findViewById(R.id.buttonPlus),
            "buttonMinus" to findViewById(R.id.buttonMinus),
            "buttonCdot" to findViewById(R.id.buttonCdot),
            "buttonDiv" to findViewById(R.id.buttonDiv),
            "buttonMod" to findViewById(R.id.buttonMod),
            "buttonSkobki" to findViewById(R.id.buttonSkobki),
            "buttonClear" to findViewById(R.id.buttonClear),
        )
        var operationCount: Short = 0

        fun makeResult(): String {
            // using library exp4j (take string get result) (it's say me Tigran)
            if (textMap["body"]?.text != "") {
                try {
                    val localResult: Double =
                        ExpressionBuilder(textMap["body"]?.text.toString()).build().evaluate()
                    if (localResult.toInt().toDouble() == localResult) {
                        return localResult.toInt().toString()

                    } else {
                        return localResult.toString()
                    }
                } catch (e: Exception) {
                    return ""
                }
            }
            return ""
        }

        buttonMap["buttonNumber0"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}0"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber1"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}1"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber2"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}2"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber3"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}3"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber4"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}4"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber5"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}5"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber6"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}6"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber7"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}7"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber8"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}8"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonNumber9"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}9"
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonDelete"]?.setOnClickListener {
            if (textMap["body"]?.text.toString().length > 0) {
                val lastChar = textMap["body"]?.text?.substring(
                    textMap["body"]?.text.toString().lastIndex,
                    textMap["body"]?.text.toString().lastIndex + 1
                )
                if (lastChar == '+'.toString() || lastChar == '-'.toString() || lastChar == '*'.toString() || lastChar == charDiv.toString()) {
                    operationCount = (operationCount - 1).toShort()
                }
                textMap["body"]?.text = textMap["body"]?.text.toString()
                    .substring(0, textMap["body"]?.text.toString().lastIndex)
            }
            if (operationCount > 0) textMap["result"]?.text = makeResult()
        }
        buttonMap["buttonClear"]?.setOnClickListener {
            textMap["body"]?.text = ""
            textMap["result"]?.text = ""
        }
        buttonMap["buttonComma"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text},"
        }
        buttonMap["buttonPlus"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}+"
            operationCount++
        }
        buttonMap["buttonMinus"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}-"
            operationCount++
        }
        buttonMap["buttonCdot"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}*"
            operationCount++
        }
        buttonMap["buttonDiv"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}$charDiv"
            operationCount++
        }
        buttonMap["buttonMod"]?.setOnClickListener {
            textMap["body"]?.text = "${textMap["body"]?.text}%"
            operationCount++
        }
        buttonMap["buttonSkobki"]?.setOnClickListener {

            if (textMap["body"]?.text.toString().length > 0) {
                val ArrayOfText = textMap["body"]?.text.toString().toCharArray().toTypedArray()
                val lastChar = ArrayOfText[ArrayOfText.lastIndex]
                if (lastChar == '+' || lastChar == '-' || lastChar == '*' || lastChar == charDiv || lastChar == '(') {
                    textMap["body"]?.text = "${textMap["body"]?.text}("
                } else {
                    textMap["body"]?.text = "${textMap["body"]?.text})"
                    if (operationCount > 0) textMap["result"]?.text = makeResult()
                }
            } else {
                textMap["body"]?.text = "${textMap["body"]?.text}("
            }
        }

        buttonMap["buttonEquals"]?.setOnClickListener {
            if (textMap["result"]?.text != "") {
                textMap["body"]?.text = textMap["result"]?.text
                textMap["result"]?.text = ""
            }
        }

    }
}