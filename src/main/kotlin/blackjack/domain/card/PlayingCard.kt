package blackjack.domain.card

class PlayingCard private constructor(
    private val suit: Suit,
    private val denomination: Denomination,
) {
    val isAce: Boolean
        get() = denomination == Denomination.ACE
    val score: Int
        get() = denomination.score

    companion object {
        private val CARDS: MutableMap<String, PlayingCard> = mutableMapOf()

        init {
            for (suit in Suit.values()) {
                for (denomination in Denomination.values()) {
                    CARDS[toKey(suit, denomination)] = PlayingCard(suit, denomination)
                }
            }
        }

        fun getCards(): List<PlayingCard> {
            return CARDS.values.toList()
        }

        fun of(suit: Suit, denomination: Denomination): PlayingCard {
            return CARDS[toKey(suit, denomination)] ?: throw NoSuchElementException("Invalid card: $suit $denomination")
        }

        private fun toKey(suit: Suit, denomination: Denomination): String {
            return suit.name + denomination.name
        }
    }
}
