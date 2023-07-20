package blackjack.domain.state

import blackjack.domain.card.PlayingCard

class Begin {
    fun draw(card1: PlayingCard, card2: PlayingCard): State {
        val hands = Hands(card1, card2)
        if (hands.score().isBlackjack) {
            return Blackjack()
        }
        return Hit(hands)
    }
}
