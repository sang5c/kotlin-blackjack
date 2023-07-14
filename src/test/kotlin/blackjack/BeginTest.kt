package blackjack

import blackjack.fixture.CLUBS_10
import blackjack.fixture.CLUBS_2
import blackjack.fixture.CLUBS_A
import blackjack.fixture.CLUBS_K
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class BeginTest {
    @Test
    fun `시작 상태에서 카드를 받으면 히트다`() {
        val state = Begin()

        val actual = state.draw(CLUBS_2, CLUBS_10)

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun `시작 상태에서 ACE와 KING을 받으면 블랙잭이다`() {
        val state = Begin()

        val actual = state.draw(CLUBS_A, CLUBS_K)

        actual.shouldBeTypeOf<Blackjack>()
    }
}
