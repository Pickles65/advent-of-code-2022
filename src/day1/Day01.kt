fun main() {
    part1()
    part2()
}

fun part1() {
    println("Part 1: Highest calorie count: ${highestCalorieCount(getElfEntries())}")
}

fun part2() {
    println("Part 2: Top three calorie count sum: ${topNHighestCalorieCount(getElfEntries(), 3)}")
}

fun highestCalorieCount(elfEntries: List<List<String>>) : Int {
    val max = elfEntries.map { calorieEntries ->
        calorieEntries.map { calorieEntry ->
            calorieEntry.toInt()
        }.sum()
    }.max()
    return max
}

fun topNHighestCalorieCount(elfEntries: List<List<String>>, n: Int) : Int {
    val sortedCalorieCounts = elfEntries.map { calorieEntries ->
        calorieEntries.map { calorieEntry ->
            calorieEntry.toInt()
        }.sum()
    }.sorted()
    return sortedCalorieCounts.takeLast(n).sum()
}

fun getElfEntries() : List<List<String>> {
    return readInput("day1/input").split("\n\n").map { it.split("\n") }
}

