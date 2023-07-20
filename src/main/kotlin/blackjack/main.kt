package blackjack

import blackjack.domain.Player
import blackjack.domain.Players
import blackjack.domain.card.CardDeck

private const val INIT_CARD_COUNT = 2

fun main() {
    val cardDeck = CardDeck()

    println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)")
//    val names = readln().split(",")
    val names = "pobi,jason"
    val players = Players.of(names.split(","))
    initCards(players, cardDeck)

    // TODO: 21점 미만의 사람들에게 한 장씩 카드 발급할지 물어보기. 한 명이 n을 선택할때까지 반복한 다음, 다음 사람에게 물어보기
    processGame(players, cardDeck)

    // TODO: 최종 결과 출력
    printResultState(players)
}

private fun printResultState(players: Players) {
    //pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
    //jason카드: 7클로버, K스페이드 - 결과: 17
    players.players.forEach { player ->
        printResult(player)
    }

}

private fun printResult(player: Player) {
    println("${player.name}카드: ${player.cards.joinToString()}, 결과: ${player.state.score()}")
}

fun processGame(players: Players, cardDeck: CardDeck) {
    // TODO: 모두 finished 상태가 될 때까지 반복
    while (players.allPlayersFinished()) {
        players.players
            .filter { !it.isFinished() }
            .forEach { player ->
                repeat(player, cardDeck)
            }
    }
}

// TODO: 사용자와의 상호작용에 고민하지말고 일단 작성할 것
private fun repeat(player: Player, cardDeck: CardDeck) {
    while (!player.isFinished()) {
        val answer = getUserInput(player)
        if (answer == "y") {
            player.draw(cardDeck.draw(1))
//            pobi카드: 2하트, 8스페이드, A클로버
            printNowState(player)
        } else {
            player.stay()
        }
    }
}

private fun getUserInput(player: Player): String {
    println("${player.name}는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)")
    return "y"
}

private fun initCards(players: Players, cardDeck: CardDeck) {
    players.draw(cardDeck, INIT_CARD_COUNT)
    // pobi, jason에게 2장의 나누었습니다.
    //pobi카드: 2하트, 8스페이드
    //jason카드: 7클로버, K스페이드

    val names = players.names().joinToString()
    println("${names}에게 2장씩 나누었습니다.")
    players.players.forEach { player ->
        println("${player.name}카드: ${player.cards.joinToString()}")
    }
}

private fun printNowState(player: Player) {
    println("${player.name}카드: ${player.cards.joinToString()}")
}
