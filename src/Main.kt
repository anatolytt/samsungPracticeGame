import kotlin.math.max

fun main() {
    val inputHuman = InputHuman()
    val player1: Human = inputHuman.createHuman(1) ;
    val player2: Human = inputHuman.createHuman(2);

    var roundCounter :Int = 1;
    while (player1.hp > 0 && player2.hp > 0) {
        println(player1)
        println(player2)
        println("\n")
        println("Раунд $roundCounter:\nИгрок ${player1.name} атакует игрока ${player2.name}:")
        roundCounter += 1
        player1.attack(player2)
        player2.heal()
        println()
        println("Игрок ${player2.name} атакует игрока ${player1.name}:")
        player2.attack(player1)
        player1.heal()
        println()
    }
    println()
    println(player1)
    println(player2)
    println("Игра закончена. ${maxOf(player1, player2).name} победил")
}