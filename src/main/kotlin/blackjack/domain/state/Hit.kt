package blackjack.domain.state

import blackjack.domain.card.PlayingCard

class Hit(private val hands: Hands) : State {
    constructor(vararg cards: PlayingCard) : this(cards.toList())
    constructor(cards: List<PlayingCard>) : this(Hands(cards))

    init {
        require(hands.size >= MINIMUM_CARD_SIZE) { "2장 이상의 카드로 이루어져 있어야 합니다." }
        require(!hands.score().isBust) { "21점 초과일 수 없습니다." }
    }

    fun stay(): State {
        return Stay()
    }

    fun draw(card: PlayingCard): State {
        val hands = hands + card
        if (hands.score().isBust) {
            return Bust()
        }
        return Hit(hands)
    }

    override fun score(): Int {
        return hands.score().toInt()
    }

    companion object {
        private const val MINIMUM_CARD_SIZE = 2
    }
}

