package calculator_re

import calculator_re.operator.AddOperator
import calculator_re.operator.DivideOperator
import calculator_re.operator.MultiplyOperator
import calculator_re.operator.SubtractOperator

fun main(){
    val operator = input("Operator(+,-,*,/) : ")
    val x = input("First Number : ").toDouble()
    val y = input("Second Number : ").toDouble()

    val calculator = Calculator()

    when(operator){
        "+" -> AddOperator()
        "-" -> SubtractOperator()
        "*" -> MultiplyOperator()
        "/" -> DivideOperator()
        else -> throw RuntimeException("Wrong Operator!")
    }.let{
        println("${calculator.operate(it,x,y)}")
    }

}