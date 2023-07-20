package blackjack.domain

class Hit(private val cards: List<PlayingCard>) : State {
    constructor(vararg cards: PlayingCard) : this(cards.toList())

    init {
        require(cards.size >= 2) { "2장 이상의 카드로 이루어져 있어야 합니다." }
        require(cards.sumOf(PlayingCard::score) <= 21) { "21점 초과일 수 없습니다." }
    }

    fun stay(): State {
        return Stay(cards)
    }

    fun draw(card: PlayingCard): State {
        val playingCards = cards + card
        if (playingCards.sumOf(PlayingCard::score) > 21) {
            return Bust()
        }
        return Hit(playingCards)
    }

    fun score(): Int {
        val score = cards.sumOf(PlayingCard::score)
        if (isSoft()) {
            return score + 10
        }
        return score
    }

    // 핸드가 변한다는 의미에서 소프트라는 명칭을 사용한다.
    private fun isSoft(): Boolean = cards.any { it.isAce }
}
