package blackjack

class Hit(vararg cards: PlayingCard) : State {
    init {
        require(cards.size >= 2) { "2장 이상의 카드로 이루어져 있어야 합니다." }
        require(cards.sumOf(PlayingCard::score) < 21) { "21점 이상일 수 없습니다." }
    }
}
