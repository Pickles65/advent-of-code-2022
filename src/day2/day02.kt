package day2

import readInputLines

typealias GameRecord = Pair<String, String>
typealias Game = Pair<Shape, Shape>

fun main () {
    part1()
    part2()
}

fun part1() {
    val games = getGameRecords().map { gameRecord ->
        Game(symbolToShape(gameRecord.first), symbolToShape(gameRecord.second))
    }
    println("Part 1: Overall Score: ${getOverallScore(games)}") // 10404
}

fun part2() {
    val games = getGameRecords().map { gameRecord ->
        val elfShape = symbolToShape(gameRecord.first)
        val shapeForDesiredOutcome = when (symbolToDesiredResult(gameRecord.second)) {
            GameResult.WIN -> elfShape.losesTo()
            GameResult.DRAW -> elfShape
            GameResult.LOSE -> elfShape.beats()
        }
        Game(elfShape, shapeForDesiredOutcome)
    }
    println("Part 2: Overall Score: ${getOverallScore(games)}")
}


fun getOverallScore(games: List<Game>) : Int {
    return games.fold(0) {acc: Int, game: Game ->  acc + determineGameScore(game)}
}

fun determineGameScore(game: Game) : Int {
    return pointsByGameResult(game.second.versus(game.first)) + game.second.playScore
}

fun pointsByGameResult(gameResult: GameResult) : Int {
    return when (gameResult) {
        GameResult.WIN -> 6
        GameResult.DRAW -> 3
        GameResult.LOSE -> 0
    }
}

fun getGameRecords() : List<GameRecord> = readInputLines("day2/input").map { gameRecord ->
    val gameShapes = gameRecord.split(" ")
    Pair(gameShapes[0], gameShapes[1])
}

fun symbolToShape(symbol: String) : Shape {
    return when (symbol) {
        "A", "X" -> Rock()
        "B", "Y" -> Paper()
        "C", "Z" -> Scissors()
        else -> {throw Exception("invalid shape")}
    }
}

fun symbolToDesiredResult(symbol: String) : GameResult {
    return when (symbol) {
        "X" -> GameResult.LOSE
        "Y" -> GameResult.DRAW
        "Z" -> GameResult.WIN
        else -> {throw Exception("invalid desired result")}
    }
}