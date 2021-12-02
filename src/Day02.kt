fun main() {
    fun part1(input: List<String>): Int {
        var totalDepth = 0
        var horizontalPosition = 0
        input.forEach {
            val movement = parseLine(it)
            when (movement.direction) {
                Direction.UP -> totalDepth -= movement.distance
                Direction.DOWN -> totalDepth += movement.distance
                Direction.FORWARD -> horizontalPosition += movement.distance
            }
        }
        return totalDepth * horizontalPosition
    }

    fun part2(input: List<String>): Int {
        var totalDepth = 0
        var horizontalPosition = 0
        var aim = 0
        input.forEach {
            val movement = parseLine(it)
            when (movement.direction) {
                Direction.UP -> aim -= movement.distance
                Direction.DOWN -> aim += movement.distance
                Direction.FORWARD -> {
                    horizontalPosition += movement.distance
                    totalDepth += aim * movement.distance
                }
            }
        }
        return totalDepth * horizontalPosition
    }


    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}

fun parseLine(line: String): Movement {
    val values = line.split(" ")
    val direction = Direction.fromString(values[0])
    val distance = values[1].toInt()
    return Movement(direction, distance)
}

data class Movement(val direction: Direction, val distance: Int)

enum class Direction(val value: String) {
    UP("up"),
    DOWN("down"),
    FORWARD("forward");

    companion object {
        fun fromString(str: String): Direction = values().first { it.value == str }
    }
}
