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

        } catch (e: Exception) {
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

            when (operator) {
                "+" -> result=calc.add(AddOperation(), num1, num2)
                "-" -> result=calc.sub(SubstractOperation(), num1, num2)
                "/" -> result=calc.div(DivideOperation(), num1, num2)
                "*" -> result=calc.mul(MultiplyOperation(), num1, num2)
                "%" -> result=calc.rem(ReminderOperation(), num1, num2)
                else-> {throw Exception("연산자 잘못입력 ")}
            }

        } catch (e: Exception) {
            isValid = false
        }
    }

    println(" ${num1} ${operator} ${num2} 의 결과는 ${result} 입니다.")

    }

open class Calculator(){

    fun add(addOperation : AddOperation ,_num1:Int, _num2:Int ):Double{
        return addOperation.operate(_num1,_num2)
    }

    fun sub(subOperation : SubstractOperation ,_num1:Int, _num2:Int ):Double{
        return subOperation.operate(_num1,_num2)
    }
    fun div (divOperation: DivideOperation ,_num1:Int, _num2:Int ):Int{
        return divOperation.operate(_num1,_num2)
    }

    fun mul(mulOperation: MultiplyOperation,_num1:Int, _num2:Int ):Double{
        return mulOperation.operate(_num1,_num2)
    }
    fun rem(remOperation: ReminderOperation, _num1:Int, _num2:Int ):Int{
        return remOperation.operate(_num1,_num2)

    }
}

class AddOperation(){
    fun operate(num1 : Int, num2: Int):Double = (num1+num2).toDouble() //문법 ..?
}
class SubstractOperation{
    fun operate(num1 : Int, num2: Int):Double = (num1-num2).toDouble()
}
class MultiplyOperation{
    fun operate(num1 : Int, num2: Int):Double = (num1*num2).toDouble()
}
class DivideOperation{
    fun operate(num1 : Int, num2: Int):Int = (num1/num2)
}
class ReminderOperation{
    fun operate(num1 : Int, num2: Int):Int = (num1%num2)
}




