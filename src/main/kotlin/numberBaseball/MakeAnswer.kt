package numberBaseball

class MakeAnswer {

    var mkRandom = MakeRandom()
    val answerArray = IntArray(3)
    var isOk: Boolean = false
    val end =answerArray.size-1
    var result: String = ""

    fun make(validator:Validate):Int{

        while( isOk ==false ) {
            result ="" //초기화

            for (i: Int in 0..end) {
                mkRandom = MakeRandom()
                answerArray[i] = mkRandom.makeRandom() //일단 세자리숫자 배열로받고

                while (i > 0 && isOk == false) { //첫자리수는 검사안해도되니까 i>0부터
                    if (answerArray[i] == answerArray[i - 1]) {
                        answerArray[i] = mkRandom.makeRandom()
                    } else {
                        isOk = true
                    }
                }

                isOk = false

                //맨뒷자리는 앞앞자리랑도 다른걸 확인해야함.
                while (i == end && isOk == false) {
                    if (answerArray[end] == answerArray[0]) {
                        answerArray[end] = mkRandom.makeRandom()
                    } else {
                        isOk = true
                    }
                }

            }

            }

            for (i in 0..2) { //문자열에 이어붙임
                result += answerArray[i] //[Todo] toString 안하고 붙여도되나?
            }


                if (validator.check(result) == true) {
                    print("정답 : ${result}")
                    isOk=true

                }
        return result.toInt()
        }



    }
