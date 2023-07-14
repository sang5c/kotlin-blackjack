package blackjack

import blackjack.fixture.CLUBS_10
import blackjack.fixture.CLUBS_A
import blackjack.fixture.CLUBS_J
import io.kotest.assertions.throwables.shouldThrow
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
}
