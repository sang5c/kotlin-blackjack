package blackjack.domain.state

@JvmInline
value class Score(private val value: Int) {
    val isBust: Boolean
        get() = value > BLACKJACK_SCORE
    val isBlackjack: Boolean
        get() = value == BLACKJACK_SCORE

    fun plusBonusIfNotBust(): Score {
        val sum = value + BONUS_SCORE
        if (sum <= BLACKJACK_SCORE) {
            return Score(sum)
        }
        return this
    }

    fun toInt(): Int = value

    companion object {
        private const val BONUS_SCORE = 10
        private const val BLACKJACK_SCORE = 21
    }
}
