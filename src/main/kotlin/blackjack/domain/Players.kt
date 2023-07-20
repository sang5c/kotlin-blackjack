package blackjack.domain

import blackjack.domain.card.CardDeck

class Players(val players: List<Player>) {
    fun draw(cardDeck: CardDeck, count: Int) {
        players.forEach { it.draw(cardDeck.draw(count)) }
    }

    fun names(): List<String> {
        return players.map { it.name }
    }

    fun allPlayersFinished(): Boolean {
        return players.all { it.isFinished() }
    }


    companion object {
        fun of(names: List<String>): Players {
            return Players(names.map { Player(it) })
        }
    }
}
