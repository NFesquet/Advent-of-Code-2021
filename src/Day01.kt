fun main() {
    fun part1(input: List<Int>): Int {
        var increaseCount = 0
        (0 until input.size - 1).forEach { i ->
            if (input[i + 1] > input[i]) increaseCount++
        }

        return increaseCount
    }

    fun part2(input: List<Int>): Int {
        var increasedCount = 0
        (0 until input.size - 3).forEach { i ->
            val window = input[i] + input[i + 1] + input[i + 2]
            val nextWindow = input[i + 1] + input[i + 2] + input[i + 3]
            if (nextWindow > window) increasedCount++
        }
        return increasedCount
    }

    val input = readInput("Day01")
    val inputInt = input.map { it.toInt() }
    println(part1(inputInt))
    println(part2(inputInt))
}
