package blackjack.domain

import blackjack.domain.card.PlayingCard
import blackjack.domain.state.Begin
import blackjack.domain.state.Finished
import blackjack.domain.state.State

class Player private constructor(val name: String, var state: State) {
    val cards: List<PlayingCard>
        get() = state.getCards()

    constructor(name: String) : this(name, Begin())

    fun draw(cards: List<PlayingCard>): PlayerState {
        state = state.draw(cards)
        return PlayerState.of(name, state)
    }

    fun stay(): PlayerState {
        state = state.stay()
        return PlayerState.of(name, state)
    }

    fun isFinished(): Boolean {
        return state is Finished
    }
}
