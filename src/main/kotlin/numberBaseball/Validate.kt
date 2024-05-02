package numberBaseball

class Validate {

    fun check( strAnswer: String ) : Boolean {

        val num = strAnswer.toInt()
        val testNumber = strAnswer.toCharArray().map { it.toString() }.toTypedArray()

        var tagArray = IntArray(10, { 0 })
        val end = strAnswer.length
        var index: Int

        //세자리 수인지 (
        if (num < 100 || num > 999) {
            println(" 세자리 수를 입력하세요! ")
            return false
           // throw TooShortInputException(" 세자리 수를 입력하세요! ")

        }

        //0이 포함되었는지
        for (i: Int in 0 until end) {

            if (i == 0 && testNumber[i] == "0") {
                println(" 맨 앞자리는 0을 제외한 1~9의 숫자를 입력하세요! ")
                return false
              //  throw ZeroInValidInputException(" 맨 앞자리는 0을 제외한 1~9의 숫자를 입력하세요! ")

            }
        }

        //같은 숫자가 두번이상 쓰였는지
        for (i: Int in 0 until end) {

            index = testNumber[i].toInt()
            tagArray[index]++
            if (tagArray[index] >= 2) {
                println(" 서로 다른 세숫자로 구성해주세요!")
                return false
              //  throw SameNumberException(" 서로 다른 세숫자로 구성해주세요!")

            }

        }

        return true

    }
}