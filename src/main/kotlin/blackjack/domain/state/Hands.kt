package blackjack.domain.state

import blackjack.domain.card.PlayingCard

class Hands(private val playingCards: List<PlayingCard>) {
    val size: Int
        get() = playingCards.size
    val cards: List<PlayingCard>
        get() = playingCards.toList()

    operator fun plus(card: List<PlayingCard>): Hands {
        return Hands(playingCards + card)
    }

    fun score(): Score {
        val score = Score(playingCards.sumOf(PlayingCard::score))
        if (isSoft()) {
            return score.plusBonusIfNotBust()
        }
        return score
    }

    // 핸드가 변한다는 의미에서 소프트라는 명칭을 사용한다.
    private fun isSoft(): Boolean = playingCards.any { it.isAce }
}
