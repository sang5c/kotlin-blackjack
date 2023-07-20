package blackjack.domain.state

import blackjack.domain.card.PlayingCard

abstract class Finished(private val hands: Hands) : State {
    override fun score(): Int {
        return hands.score().toInt()
    }

    override fun draw(cards: List<PlayingCard>): State {
        throw IllegalStateException("이미 종료된 상태입니다.")
    }

    override fun stay(): State {
        throw IllegalStateException("이미 종료된 상태입니다.")
    }

    override fun getCards(): List<PlayingCard> {
        return hands.cards
    }
}
