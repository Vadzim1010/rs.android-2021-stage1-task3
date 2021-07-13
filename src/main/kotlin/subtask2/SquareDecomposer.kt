package subtask2

import java.util.*
import kotlin.math.sqrt

class SquareDecomposer {


    fun decomposeNumber(number: Int): Array<Int>? {
        val array = ArrayDeque<Int>()
        val mapFinder = mutableMapOf<Int, Int>()
        val value = number - 1
        for (i in value downTo 1) {
            mapFinder[number] = value
            array.push(squareDiff(number, value))
            while (!array.isEmpty()) {
                val currentValue = array.peek()
                var x: Int
                if (mapFinder.containsKey(currentValue)) {
                    x = mapFinder[currentValue]?.minus(1) ?: 0
                    if (x < 3) {
                        array.pop()
                        mapFinder.remove(currentValue)
                        continue
                    }
                } else x = sqrt(currentValue.toDouble()).toInt()

                when {
                    mapFinder.containsValue(x) -> {
                        array.pop()
                    }
                    currentValue - x * x == 0 -> {
                        mapFinder[currentValue] = x
                        return mapFinder.values.toTypedArray().sortedArray()
                    }
                    else -> {
                        mapFinder[currentValue] = x
                        array.push(currentValue - x * x)
                    }
                }
            }
        }
        return null
    }

    private fun square(x: Int) = x * x
    private fun squareDiff(a: Int, b: Int) = square(a) - square(b)
}

