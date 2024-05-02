package numberBaseball

fun main() {

    var answer:Int?

    //for 검증
    var validator = Validate()

    //for 정답 생성
    var makeA = MakeAnswer()

    //for 정답과 입력 비교
    var cmp = Compare()

    //for 원하는 동작 입력받기
    var initNum: Int = 0

    //key : n번째 게임, value : 시도횟수
    var gameMap = mutableMapOf<Int,Int>()

    // n번째 게임인지 count
    var cnt = 0




    while (true) {
        print(
            """
        환영합니다! 원하시는 번호를 입력해주세요
    1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기 : """
        )
        //원하는 동작 입력받음
        initNum = readLine()!!.toInt()

        when (initNum) {
            1 -> {

                //게임 인스턴스 생성
                var game = NewGame(validator, makeA)
                cnt++

                //게임 시작
                answer = makeA.make(validator) //정답만들어서
                game.start(validator, cmp, answer) //game에 넘겨줌

                //게임맵에 게임정보 추가 ( (cnt)번째, (game.attemp)번 시도)
                gameMap.put(cnt,game.attempt)



            }

            2 -> {
                for(i in gameMap){
                    print("${i.key}번째 게임 : ${i.value}회 시도")
                }
            }
            3 -> {
                for(i in gameMap){
                    gameMap.remove(i.key, i.value)
                }
                break
            }

            else -> {
                throw RuntimeException("잘못된 입력입니다.")
            }
        }

    }
}

