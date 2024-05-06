package numberbaseball_clone

class GameHistory {
    private val history = mutableListOf<Int>()

    fun record(score:Int){
        history.add(score)
    }

    fun show(){
        println("\n < 게임 기록 보기> ")
        history.forEachIndexed{ index, i ->
            println("${index+1}번째 게임 : 시도횟수 = $i")
        }
    }
}