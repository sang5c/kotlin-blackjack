package blackjack.domain

class Hit(private val cards: List<PlayingCard>) : State {
    constructor(vararg cards: PlayingCard) : this(cards.toList())

    init {
        require(cards.size >= 2) { "2장 이상의 카드로 이루어져 있어야 합니다." }
        require(cards.sumOf(PlayingCard::score) < 21) { "21점 이상일 수 없습니다." }
    }

    fun draw(card: PlayingCard): Hit {
        return Hit(cards + card)
    }
}
