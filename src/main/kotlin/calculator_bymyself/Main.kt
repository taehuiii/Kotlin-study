package calculator_bymyself

import helper.input
import numberbaseball_clone.GameHistory
import java.lang.Exception

/** 어떤 등장인물이 등장하면 좋을까 ?
 *
 * 1. 어떤 등장인물들이 등장하면 좋을까 ?
 *  전체적인 흐름 통제 : Main
 *  계산기 객체 Calculator
 *  각 연산 객체 AddOperator, SubOperator, ..
 *  ==> AbstractOperator
 *
 * 2. 등장인물들의 협력을 이미지로 그려보기!
 * -Main -> Calculator : 연산을 위해 operate()요청, 그 결과를 응답으로 받음
 * -Calculator -> AbstractOperator : 각 연산에 맞는 객체에게 operate()요청, 그 결과를 응답으로 받음
 *
 * 3. 각 객체가 어떻게 흘러가면 좋을지 납득가능한 한글로 먼저 써보기!
 *
 * -Main
 * 1) 사용자에게 두 숫자를 입력을 받는다. -> 잘못된 입력 시, 다시 입력받는다
 * 2) 사용자에게 연산자를 입력받는다. -> 잘못된 입력 시, 다시 입력받는다
 * 3) calculator에게 operate를 요청한다.
 * //3) 사용자에게 요청받은 연산자에 따라, 연산자객체를 생성한다.
 * //4) calculator에게 연산을 요청할 때, 연산자 객체와 함께 넘겨준다.
 *
 * -Calculator
 * 1) Main에게서 두 숫자와 연산자객체를 전달받으며 연산을 요청받는다.
 * 2) 요청받은 연산에 맞는 연산자객체를 생성해서 요청을 한다.
 * 3) 그 결과를 받는다.
 *
 * -AbstractOperator ( Add, Sub, Mul, Div )
 * 1) Calculator에게 요청받은 연산을 수행하고, 그 값을 반환한다.
 *
 * */

fun main(){

    var num1 : Number =0 //[Todo] Number 써볼까 ?
    var num2 : Number=0
    var oprt =""
    var calculator =Calculator()
    var result :Number =0

    while(true){

        // 1)두숫자 입력받기
        try {
            print(" 두 숫자를 입력하세요 : ")
            num1 = readLine()!!.toDouble()
            num2 = readLine()!!.toDouble()
        }catch(e : Exception){
            println(" 잘못된 입력입니다. 다시 입력하세요. ")
            println(e.message)
            continue
        }

        //2) 연산자 입력받기
        try {
            print(" 연산자를 입력하세요 : ")
            oprt = readLine()!!.toString()

        }catch(e : Exception){
            println(" 잘못된 입력입니다. 다시 입력하세요. ")
            println(e.message)
            continue
        }

        //calculator에게 전달
        result = calculator.operate(num1,num2,oprt)
        print("결과 : $result")
        break
    }


}