package blackjack.domain.state

import blackjack.fixture.*
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class BeginTest {
    @Test
    fun `시작 상태에서 카드를 받으면 힛이다`() {
        val state = Begin()

        val actual = state.draw(listOf(CLUBS_2, CLUBS_10))

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun `시작 상태에서 10과 JACK을 받으면 힛이다`() {
        val state = Begin()

        val actual = state.draw(listOf(CLUBS_10, CLUBS_J))

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun `시작 상태에서 ACE와 KING을 받으면 블랙잭이다`() {
        val state = Begin()

        val actual = state.draw(listOf(CLUBS_A, CLUBS_K))

        actual.shouldBeTypeOf<Blackjack>()
    }
}
