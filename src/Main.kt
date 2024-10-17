//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val robot: Robot = Robot(hp=100, power=15, battery = 100)
    val wizard: Wizard = Wizard(hp=100, power=20, mana=Mana.Health)
    val knight: Knight = Knight(hp=100, power=10, defence = 2)

    val player1: Human = wizard;
    val player2: Human = knight;


    var roundCounter :Int = 1;
    while (player1.hp != 0 && player2.hp != 0) {
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
    println("Игра закончена. ${
        if (player1.hp == 0) {
            player2.name
        } else {
            player1.name
        }
    } победил")


}