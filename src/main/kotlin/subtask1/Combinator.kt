package subtask1

class Combinator {


    fun checkChooseFromArray(array: Array<Int>): Int? {
        val n: Long = array[1].toLong()
        val number: Long = array[0].toLong()
        var x: Long
        var nF: Long = 1
        var mF: Long = 1
        var mSum: Long = 1
        var toReturn: Long? = number
        for (m in 1..n) {
            nF *= m
        }
        for (y in 1 until n) {
            mF *= y
            for (m in (y + 1)..n) {
                mSum *= (m - y)
            }
            x = nF / (mF * mSum)
            if (x == number) {
                if (toReturn != null) {
                    if (toReturn > y)
                        toReturn = y
                }
            }
            mSum = 1
        }
        if (toReturn == number) {
            toReturn = null
        }
        return toReturn?.toInt()
    }
}
