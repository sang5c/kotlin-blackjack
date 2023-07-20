package blackjack.domain.card

class CardDeck {
    private val deck: MutableList<PlayingCard> = PlayingCard.getCards().shuffled().toMutableList()

    fun draw(count: Int): List<PlayingCard> {
        require(deck.size >= count) { "카드가 부족합니다." }

        return List(count) { deck.removeAt(0) }
    }
}
