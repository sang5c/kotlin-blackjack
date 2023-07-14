package blackjack

class Hit(vararg cards: PlayingCard) : State {
    init {
        require(cards.sumOf { it.score } < 21)
    }
}
