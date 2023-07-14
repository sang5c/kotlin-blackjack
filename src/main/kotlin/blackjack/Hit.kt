package blackjack

class Hit(vararg cards: PlayingCard) : State {
    init {
        require(cards.size > 1)
        require(cards.sumOf { it.score } < 21)
    }
}
