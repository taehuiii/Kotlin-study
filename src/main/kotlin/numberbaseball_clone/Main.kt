package numberbaseball_clone
import helper.input

fun main(){

    val gameHistory = GameHistory()

    while(true){
        println(" *** 야구게임 ***")
        println("1. 게임 시작하기  2. 게임 기록 보기  3. 종료하기")
        when( input("입력 : ").toInt()){
            1->{
                println("1. 1~9 mode   2.0~9 mode")
                val game = when( input(" 숫자 입력 : ").toInt()){
                    1-> BaseballGame() //객체 생성만 한거임.
                    2-> BaseballGameWithZero()
                    else -> continue //어디로 가는가 ?
                }

                val tryCount=game.play() //play시작!
                gameHistory.record(tryCount)
            }
            2->{gameHistory.show()}
            3->{println("< 숫자야구게임을 종료합니다 >")
                break}
            else->{
                println("올바른 숫자를 입력해주세요! ") //다시 when의 맨 위로 올라가는것? 반복문 ?
            }

        }
    }
}