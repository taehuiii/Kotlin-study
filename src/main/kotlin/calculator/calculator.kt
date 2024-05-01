package calculator

import calculator.operation.AbstractOperation

open class Calculator{

//    fun operation(abstractOperation: AbstractOperation, _num1:Int, _num2:Int):Double{
//        return abstractOperation.operate(_num1,_num2)
//    }

    fun operation(abstractOperation: AbstractOperation, _num1:Int, _num2:Int):Double =abstractOperation.operate(_num1,_num2)
}












