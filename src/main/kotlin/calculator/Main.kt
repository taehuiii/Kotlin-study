package calculator

import calculator.operation.*
import java.lang.Exception

fun main(){

    val calc = Calculator() //객체만들고

    var isValid: Boolean = false
    var num1: Int =0;
    var num2: Int =0;
    var operator :String =""
    var result :Any = 0

    //숫자 입력받기
    while(isValid ==false) {
        isValid = true

        try {
            print(" 두 숫자를 입력하세요 : ")
            num1 = readLine()!!.toInt()
            num2 = readLine()!!.toInt()
            isValid = true

        } catch(e:NumberFormatException){
            println(e.message)
            isValid = false

        }catch (e: Exception) { //상황에 맞는 Exception 구현하기
            println(e.message)
            isValid = false
        }
    }

    //연산자 입력받기
    isValid = false


    while(isValid ==false) {


        isValid = true
        try {
            print(" 연산자 입력하세요 : ")
            operator = readLine().toString()

//            when (operator) { //연산자 enum으로 관리하기1
//                Operator.PLUS.Name-> result=calc.operation(AddOperation(), num1, num2)
//                Operator.MINUS.Name -> result=calc.operation(SubstractOperation(), num1, num2)
//                Operator.MULTIPLY.Name-> result=calc.operation(MultiplyOperation(), num1, num2)
//                Operator.DIVIDE.Name-> result=calc.operation(DivideOperation(), num1, num2)
//                Operator.REMAINDER.Name -> result=calc.operation(ReminderOperation(), num1, num2)
//                else-> {throw InvalidInputException("연산자 잘못입력 !!")}
//            }

            when(operator){
                Operator.PLUS.value-> AddOperation()
                Operator.MINUS.value -> SubstractOperation()
                Operator.MULTIPLY.value -> MultiplyOperation()
                Operator.DIVIDE.value -> DivideOperation()
                Operator.REMAINDER.value -> ReminderOperation()
                else-> throw InvalidInputException("연산자 잘못입력 !!")
            }.let{
                //Upcasting
                it.operate(num1,num2)
            }
        } catch (e: Exception) {
            println(e.message)
            //  e.printStackTrace()
            isValid = false
        }
    }

    println(" ${num1} ${operator} ${num2} 의 결과는 ${result} 입니다.")

}

