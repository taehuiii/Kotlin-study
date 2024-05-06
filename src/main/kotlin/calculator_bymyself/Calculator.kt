package calculator_bymyself

import calculator_bymyself.operator.AddOperator
import calculator_bymyself.operator.DivideOperator
import calculator_bymyself.operator.MultiplyOperator
import calculator_bymyself.operator.SubOperator

class Calculator{

    fun operate(num1:Double, num2:Double, oprt:String):Double {

        when (oprt) {

            "+" -> AddOperator()

            "-" -> SubOperator()

            "*" -> MultiplyOperator()

            "/" -> DivideOperator()

            else -> {
               throw RuntimeException("Wrong Operator!")
            }
        }.let{
            return it.operate(num1,num2)
        }
    }}