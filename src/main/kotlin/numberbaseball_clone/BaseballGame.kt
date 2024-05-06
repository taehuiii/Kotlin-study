package numberbaseball_clone

import helper.input
import kotlin.RuntimeException
/**
 *   BaseballGame.play()
 *    1. tryCount 을 0 으로 초기화한다.
 *    2. 사용자에게 정답 입력을 받는다.
 *    3. 사용자에게 입력받은 입력이 올바른지 검증한다.
 *    4. tryCount 을 1 증가시킨다.
 *    5. 스트라이크가 몇개인지 계산한다.
 *    6. 만약 스트라이크가 size 와 동일하다면 정답임으로 게임을 종료한다. (이때 TryCount 반환한다)
 *    7. 볼이 몇개인지 계산한다.
 *    8. 힌트를 출력하고 처음으로 돌아간다.
 *
 *   // 적당한 추상화가 적용된 설명 -> 읽기 쉬운 코드 만들어짐
 *   // 캡슐화를 구현할 수 있다 -> 구체적인걸 늦게 결정하기 때문
 *   // 관심사 분리를 통해서 문제를 작게 만들고, 생각하는 범위자체를 작게 만들수 있다.
 */


//상속할거면 open 키워드 써주기!
open class BaseballGame(private val size: Int =3) {

    protected open val answer = (1..9).shuffled().take(size) //List<Int>

    fun play() : Int { //open안써도되나 ?


        println("\n<게임을 시작합니다.>")

        //1. tryCount를 0으로 초기화한다. (입력시도 횟수세기)
        var tryCount =0

        //2. 사용자에게 입력받는다. -> 3. 입력이 올바른지 검증

        while(true){ //while문 반복할 때마다 새로운 list가 생성되어 input변수에 주소가 들어가는 것 ? 기존것은 참조를 잃어버리고 ? ->> GC가 치워줌?
            val input = try {
                input("정답을 입력하세요 : ") //123
                    .toList() //List<Char> ['1','2','3'] ??
                    .map { it.digitToInt()} //List<Int> digitToInt : 문자-> 숫자 ?
                    .also {if(!this.checkInput(it)) throw RuntimeException() }
            }catch(e : RuntimeException){ //예외 발생 시 할 작업 명시 (종료X, 회복 )
                println("잘못된 입력입니다. 다시 입력하세요.")
                continue //while문 처음으로 다시 돌아가서 입력?
            }

            //4. 제대로 된 입력에 대하여 시도횟수 +1
            tryCount++

            //5. strike인지 ball인지 계산 -> strike ==size면 정답!
            val strike = this.countStrike(input)
            if( strike == size){
                println("$strike 스트라이크! 정답입니다")
                break
            }

            val ball = this.countBall(input)
            println("$strike 스트라이크! $ball 볼!")

        }

        //6. 정답을 맞춰서 while문 빠져나가면 -> tryCount 리턴
        println()
        return tryCount


    }

    protected open fun checkInput(input : List<Int>): Boolean{
        if( input.size != size) return false
        if (input.distinct().size != size) return false //중복된 원소 제거
        return true
    }

    private fun countStrike(input: List<Int>):Int{ //얘넨 private인데 zero에서 어떻게쓰지 ?
        var count=0
        for(i in 0 until size){
            if(input[i] ==answer[i]){
                count++
            }
        }
        return count
    }

    private fun countBall(input: List<Int>):Int{
        var count=0
        for(i in 0 until size){
            if(input[i] != answer[i] && input[i] in answer ){ //input[i] in answer
                count++
            }
        }
        return count
    }


}