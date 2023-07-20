package blackjack.domain.state

class Stay(private val hands: Hands) : State {
    override fun score(): Int {
        return hands.score().toInt()
    }
}
