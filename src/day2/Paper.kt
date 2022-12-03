package day2

class Paper : Shape {
    override val symbol = "B"
    override val playScore = 2
    override fun versus(opponentShape: Shape): GameResult {
        return when (opponentShape) {
            is Rock -> GameResult.WIN
            is Paper -> GameResult.DRAW
            is Scissors -> GameResult.LOSE
            else -> {throw Exception("invalid game")}
        }
    }

    override fun beats(): Shape {
        return Rock()
    }

    override fun losesTo(): Shape {
        return Scissors()
    }
}