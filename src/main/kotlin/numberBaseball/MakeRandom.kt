package numberBaseball

import java.util.*

class MakeRandom {

    fun makeRandom(): Int {
        val random = Random()

        return random.nextInt(9)
    }

}