package calculator_re

import calculator_re.operator.AbstractOperator

class Calculator {
    fun operate ( operator : AbstractOperator, x:Double,y:Double) = operator.operate(x,y)
}