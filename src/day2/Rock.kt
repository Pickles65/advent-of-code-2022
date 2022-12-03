package day2

class Rock : Shape {
    override val symbol = "A"
    override val playScore = 1
    override fun versus(opponentShape: Shape) : GameResult {
        return when (opponentShape) {
            is Rock -> GameResult.DRAW
            is Paper -> GameResult.LOSE
            is Scissors -> GameResult.WIN
            else -> {throw Exception("invalid game")}
        }
    }

    override fun beats(): Shape {
        return Scissors()
    }

    override fun losesTo(): Shape {
        return Paper()
    }
}