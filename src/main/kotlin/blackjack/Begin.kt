package blackjack

class Begin {
    fun draw(card1: PlayingCard, card2: PlayingCard): State {
        val totalScore = card1.score + card2.score + 10
        if (totalScore == 21) {
            return Blackjack()
        }
        return Hit(card1, card2)
    }
}
