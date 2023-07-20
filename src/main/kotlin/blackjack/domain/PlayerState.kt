package blackjack.domain

import blackjack.domain.card.PlayingCard
import blackjack.domain.state.State

class PlayerState(val name: String, val cards: List<PlayingCard>, val score: Int) {
    companion object {
        fun of(name: String, state: State): PlayerState {
            return PlayerState(name, state.getCards(), state.score())
        }
    }
}
