package blackjack

import blackjack.fixture.CLUBS_10
import blackjack.fixture.CLUBS_A
import blackjack.fixture.CLUBS_J
import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.api.Test

class HitTest {
    @Test
    fun constructor() {
        shouldThrow<IllegalArgumentException> {
            Hit(CLUBS_10, CLUBS_J, CLUBS_A)
        }
    }
}
