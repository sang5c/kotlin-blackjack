package blackjack.domain.state

import blackjack.domain.card.PlayingCard

class Begin : State {
    override fun draw(cards: List<PlayingCard>): State {
        val hands = Hands(cards)
        if (hands.score().isBlackjack) {
            return Blackjack(hands)
        }
        return Hit(hands)
    }

    override fun score(): Int {
        throw IllegalStateException("Begin 상태입니다.")
    }

    override fun stay(): State {
        throw IllegalStateException("Begin 상태입니다.")
    }

    override fun getCards(): List<PlayingCard> {
        throw IllegalStateException("Begin 상태입니다.")
    }
}
