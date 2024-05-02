package numberBaseball

class Compare {

    fun compare(ans: Int, num: Int):Int { //정답과 입력을 비교해서 힌트 생성

        if (ans == num) { //게임종료
            println("정답!")   //[Todo] 정답맞춰서 종료되었을 경우, 초기 안내문구 다시 출력
            return 1
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
        return 2

    }
}