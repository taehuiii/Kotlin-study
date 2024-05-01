package numberBaseball

import java.util.Arrays
import java.util.Random
//[Todo] 추가구현 : 0~9의 서로다른 숫자로 변경해보기 ( 맨앞자리 0불가)
//[Todo] 기록보기 : 그동안의 게임 시도횟수 출력
//[Todo] 종료하기 : 그동안의 게임기록 초기화
fun main(args: Array<String>) {
    //[Todo] 추가구현 : 시작, 기록보기, 종료 구분하는 수 입력 (+ 이외의 입력값 : 오류출력 )
    //[Todo] 추가구현 : 정답맞춰서 종료되었을 경우, 초기 안내문구 다시 출력

    start()
    //show()
    //terminate()
}

fun start() {

    var answer :Int = makeAnswer() //랜덤으로 정답만들기
    var num: Int //사용자에게 입력받을 num

    var isValid:Boolean = false

    while (isValid ==false) {
        try {
            print(" 숫자를 입력하세요 : ")
            num = readLine()!!.toInt()

            if(examine(num)){ //입력이 잘 됐으면
            compare(answer, num) //비교해서 힌트 출력
                isValid = true //[Todo] 정답맞출때까지 반복문 돌아야함 (+횟수세기)
            }else{ //아니면 -> 다시 입력받음
                isValid = false
            }

        } catch(e: NumberFormatException){
            println(e.message)
            isValid = false
        } catch(e: TooShortInputException){
            println(e.message)
            isValid = false
        } catch(e: ZeroInValidInputException){
            println(e.message)
            isValid = false
        } catch(e: SameNumberException){
            println(e.message)
            isValid = false
        } catch(e : Exception){
            e.printStackTrace()
            isValid = false
        }
    }
}
fun examine(num:Int):Boolean{

    val testNumber = num.toString().toCharArray().map { it.toString() }.toTypedArray()

    var tagArray =IntArray(9,{0})
    val end = num.toString().length
    var index :Int

    //세자리 수인지 ( [Todo] 클래스로 만들어보기 )
    if( num <100 ){
        throw TooShortInputException(" 세자리 수를 입력하세요! ")
    }

    //0이 포함되었는지
    for( i :Int in 0 until end){

       if( testNumber[i] =="0" ){
           throw ZeroInValidInputException(" 0을 제외한 1~9의 숫자를 입력하세요! ")
       }
    }

    //같은 숫자가 두번이상 쓰였는지
    for( i :Int in 0 until end){

      index = testNumber[i].toInt()
        tagArray[index-1]++
        if( tagArray[index-1] >=2){
            throw SameNumberException(" 서로 다른 세숫자로 구성해주세요!")
        }

    }

    return true
}

fun makeAnswer():Int{ //리턴 ?
    val answerArray = IntArray(3)
    var isOk: Boolean = false
    val end =answerArray.size-1


    for (i: Int in 0 .. end) {
        answerArray[i] = makeRandom() //일단 세자리숫자 배열로받고
    }

    var result: String = "" //문자열에 이어붙임

    for (i in 0..2) {
        result += answerArray[i] //[Todo] toString 안하고 붙여도되나?
    }

    //result.toInt()를 검사해야함.
    return result.toInt() //일단 오류안나려고 리턴

//
//        //숫자는 1~9
//        while (answerArray[i] ==0) {
//            answerArray[i] = makeRandom()
//        }
//
//
//        //앞자리와 같으면 안된다.
//        while (i > 0 && isOk == false) { //첫자리수는 검사안해도되니까 i>0부터
//            if (answerArray[i] == answerArray[i - 1]) {
//                answerArray[i] = makeRandom()
//            } else {
//                isOk = true
//            }
//        }
//
//        isOk = false
//
//        //맨뒷자리는 앞앞자리랑도 다른걸 확인해야함.
//        while (i == end && isOk == false) {
//            if (answerArray[end] == answerArray[0]) {
//                answerArray[end] = makeRandom()
//            } else {
//                isOk = true
//            }
//        }
//
//    }



}

fun compare(ans: Int, num: Int) { //정답과 입력을 비교해서 힌트 생성

    if (ans == num) { //게임종료
        println("정답!")   //[Todo] 정답맞춰서 종료되었을 경우, 초기 안내문구 다시 출력
        return
    }
    var ball: Int = 0
    var strike: Int = 0

    //int -> 문자열 -> 배열에 쪼개서 한글자씩 비교
    val ansString = ans.toString().toCharArray().map { it.toString() }.toTypedArray()
    val numString = num.toString().toCharArray().map { it.toString() }.toTypedArray()

    for (i: Int in 0..2) {
        for (j: Int in 0..2) {

            if (ansString[i] == numString[j]) {
                if (i == j) {
                    strike++
                } else {
                    ball++
                }
            }

        }
    }
    if( strike ==0 && ball ==0){
        println("nothing")
    }else{
        println("${strike}S, ${ball}B 입니다.")
    }

}



fun makeRandom(): Int {
    val random = Random()
    return random.nextInt(9)

}

