package subtask3

class TelephoneFinder {


    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.toInt() < 0) return null
        val neighbors: Array<Array<Char>> = arrayOf(
            arrayOf('8'),
            arrayOf('2', '4'),
            arrayOf('1', '5', '3'),
            arrayOf('2', '6'),
            arrayOf('1', '5', '7'),
            arrayOf('2', '4', '8', '6'),
            arrayOf('3', '5', '9'),
            arrayOf('4', '8'),
            arrayOf('7', '5', '9', '0'),
            arrayOf('6', '8')
        )
        val result = mutableListOf<String>()
        for (i in number.indices) {
            val value = number.toMutableList()
            for (j in neighbors[value[i].toString().toInt()]) {
                value[i] = j.toString()[0]
                result.add(value.joinToString(separator = ""))
            }
        }
        return result.toTypedArray()
    }
}
