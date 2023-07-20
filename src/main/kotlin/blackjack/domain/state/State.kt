package blackjack.domain.state

import blackjack.domain.card.PlayingCard

interface State {
    fun score(): Int
    fun draw(cards: List<PlayingCard>): State
    fun stay(): State
    fun getCards(): List<PlayingCard>
}
