package numberBaseball

import java.util.Arrays
import java.util.Random

fun main(args: Array<String>) {
    fun start() {

        var answer = makeAnswer()
        var num: Int

        print(" 숫자를 입력하세요 : ")
        num = readLine()!!.toInt()
        //오류문구
        compare(answer, num)
    }

    start()
}

fun compare(ans: Int, num: Int) {

    if (ans == num) { //게임종료
        println("정답!")
    }
    var ball: Int = 0
    var strike: Int = 0

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
    println("${strike}S, ${ball}B 입니다.")
}

fun isBall() {}
fun isStrike() {}

fun makeAnswer(): Int {
    val answerArray = IntArray(3)
    var isOk: Boolean = false


    for (i: Int in 0..2) {
        answerArray[i] = makeRandom()


        //첫번째 숫자 필터링 반복문
        while (i == 0 && isOk == false) { //첫번째숫자은 0이 될 수 없음.
            if (answerArray[0] == 0) {
                answerArray[0] = makeRandom()
            } else {
                isOk = true
            }
        }

        isOk = false

        //앞자리와 같으면 안된다.
        while (i > 0 && isOk == false) {
            if (answerArray[i] == answerArray[i - 1]) {
                answerArray[i] = makeRandom()
            } else {
                isOk = true
            }
        }

        isOk = false

        while (i == 2 && isOk == false) {
            if (answerArray[2] == answerArray[0]) {
                answerArray[2] = makeRandom()
            } else {
                isOk = true
            }
        }


    }
    var result: String = ""

    for (i in 0..2) {
        result += answerArray[i]
    }
    return result.toInt()
}

fun makeRandom(): Int {
    val random = Random()
    return random.nextInt(9)

}

//fun makeAnswer22(): Int {
//    val answerArray = IntArray(3)
//
//    val numberList = mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
//
//    for (i: Int in 0..2) {
//        if (i == 1) {
//            numberList.add(0)
//        }
//        val makeRandom: Int = makeRandom22(numberList.size - 1)
//        answerArray[i] = numberList[makeRandom]
//        numberList.removeAt(makeRandom)
//    }
//    var result: String = ""
//
//    for (i in 0..2) {
//        result += answerArray[i]
//    }
//    return result.toInt()
//}
//
//
//fun makeRandom22(rangeNum: Int): Int {
//    val random = Random()
//    return random.nextInt(rangeNum)
//}
