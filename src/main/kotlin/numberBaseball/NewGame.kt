package numberBaseball

class NewGame(validator: Validate,makeA:MakeAnswer) {

    //var answer:Int = makeAnswer(makeA,validator)

    //사용자에게 입력받을 정수
    var num:Int =0
    var keepGoing:Int=0

    //정답을 맞힐때까지 반복
    var isValid :Boolean = false

    //시도 횟수 count
    var attempt :Int=0


    fun start(validator: Validate, cmp :Compare, answer:Int){

        while (isValid ==false) {
            try {
                print(" 숫자를 입력하세요 : ")
                num = readLine()!!.toInt()
                attempt++

                if(validator.check(num.toString())){ //입력이 잘 됐으면, 정답과 비교

                    //비교해서 힌트 출력 후, 정답이면 return 1, 아니면 return 2
                    keepGoing = cmp.compare(answer, num)

                    when(keepGoing){
                        1 ->{break}
                        2 ->{continue}
                    }

                }else{ //입력 오류 -> 다시 입력받음
                    isValid = false
                }

            } catch(e: NumberFormatException){
                println(e.message)
                isValid = false
                //start() ..??
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






}