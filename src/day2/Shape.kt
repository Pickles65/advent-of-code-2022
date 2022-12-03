package day2

interface Shape {
    val symbol: String
    val playScore: Int
    fun versus(opponentShape: Shape): GameResult
    fun losesTo(): Shape
    fun beats(): Shape
}
