package blackjack.domain.state

import blackjack.fixture.*
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class HitTest {
    @Test
    fun `힛은 21점 이상일 수 없다`() {
        shouldThrow<IllegalArgumentException> {
            Hit(CLUBS_10, CLUBS_J, CLUBS_2)
        }
    }

    @Test
    fun `힛은 2장 이상의 카드로 이루어져 있다`() {
        shouldThrow<IllegalArgumentException> {
            Hit(CLUBS_10)
        }
    }

    @Test
    fun `힛에서 카드를 받고 21점 이하이면 힛이다`() {
        val state = Hit(CLUBS_2, CLUBS_10)

        val actual = state.draw(CLUBS_9)

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun `힛에서 카드를 받고 21점 초과면 버스트이다`() {
        val state = Hit(CLUBS_2, CLUBS_10)

        val actual = state.draw(CLUBS_10)

        actual.shouldBeTypeOf<Bust>()
    }

    @Test
    fun `힛에서 카드를 받고 스테이를 하면 스테이이다`() {
        val state = Hit(CLUBS_2, CLUBS_10)

        val actual = state.stay()

        actual.shouldBeTypeOf<Stay>()
    }

    @Test
    fun `A + 4는 15점이다`() {
        val state = Hit(CLUBS_A, CLUBS_4)

        state.score() shouldBe 15
    }

    @Test
    fun `A + J + K는 21점이다`() {
        val state = Hit(CLUBS_A, CLUBS_J, CLUBS_K)

        state.score() shouldBe 21
    }

    @Test
    fun `A + J를 받은 후 K를 draw하면 21점이다`() {
        val state = Hit(CLUBS_A, CLUBS_J)

        val actual = state.draw(CLUBS_K)

        actual.score() shouldBe 21
    }

    @Test
    fun `A + 2 + 4를 받으면 17점이다`() {
        val state = Hit(CLUBS_A, CLUBS_2, CLUBS_4)

        state.score() shouldBe 17
    }

    @Test
    fun `A + 2를 받고 4를 draw 하면 17점이다`() {
        val state = Hit(CLUBS_A, CLUBS_2)

        val actual = state.draw(CLUBS_4)

        actual.score() shouldBe 17
    }
}
