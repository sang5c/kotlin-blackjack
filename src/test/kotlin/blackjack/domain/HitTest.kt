package blackjack.domain

import blackjack.fixture.*
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class HitTest {
    @Test
    fun `힛은 21점 이상일 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            Hit(CLUBS_10, CLUBS_J, CLUBS_A)
        }
    }

    @Test
    fun `힛은 2장 이상의 카드로 이루어져 있다`() {
        shouldThrow<IllegalArgumentException> {
            Hit(CLUBS_10)
        }
    }

    @Test
    fun `힛에서 카드를 받고 21점 미만이면 힛이다`() {
        val state = Hit(CLUBS_2, CLUBS_10)

        val actual = state.draw(CLUBS_4)

        actual.shouldBeTypeOf<Hit>()
    }
}
