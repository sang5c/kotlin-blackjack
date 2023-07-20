package blackjack.domain.state

import blackjack.domain.card.PlayingCard

class Hands(private val cards: List<PlayingCard>) {
    constructor(vararg cards: PlayingCard) : this(cards.toList())

    val size: Int
        get() = cards.size

    operator fun plus(card: PlayingCard): Hands {
        return Hands(cards + card)
    }

    fun score(): Score {
        val score = Score(cards.sumOf(PlayingCard::score))
        if (isSoft()) {
            return score.plusBonusIfNotBust()
        }
        return score
    }

    // 핸드가 변한다는 의미에서 소프트라는 명칭을 사용한다.
    private fun isSoft(): Boolean = cards.any { it.isAce }
}
