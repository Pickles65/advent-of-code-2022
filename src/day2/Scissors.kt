package day2

class Scissors : Shape {
    override val symbol = "C"
    override val playScore = 3

    override fun versus(opponentShape: Shape): GameResult {
        return when (opponentShape) {
            is Rock -> GameResult.LOSE
            is Paper -> GameResult.WIN
            is Scissors -> GameResult.DRAW
            else -> {throw Exception("invalid shape")}
        }
    }

    override fun beats(): Shape {
        return Paper()
    }

    override fun losesTo(): Shape {
        return Rock()
    }

}