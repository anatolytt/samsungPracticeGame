class InputHuman {

    fun createHuman(number : Int) : Human {
        println("Ввод игрока $number.\n" +
                "Для игрока Robot введите R\n" +
                "Для игрока Wizard введите W\n" +
                "Для игрока Knight введите K\n" +
                "Введите игрока: ")
        val playerName : String = readln()

        println("Введите здововье игрока от 1 до 100:")
        val hp = readln().toInt()
        println("Введите силу игрока от 1 до 100:")
        val power = readln().toInt()
        when (playerName) {
            "R" -> {
                println("Введите батарею робота от 1 до 100: ")
                return (Robot(hp=hp, power=power, battery = readln().toInt()))
            }
            "W" -> {
                println("Введите H для маны здоровья или P для маны силы: ")
                val tempMana = readln()
                val mana: Mana
                when (tempMana) {
                    "H" -> mana = Mana.Health
                    "P" -> mana = Mana.Power
                    else -> {
                        println("Вы ввели неподходящее значение. Была автоматически выбрана мана силы")
                        mana = Mana.Power
                    }
                }
                return (Wizard(hp=hp, power=power, mana=mana))
            }
            "K" -> {
                println("Введите максимальное количество использования брони: ")
                return (Knight(hp=hp, power=power, defence = readln().toInt()))
            }

            else -> {
                println("Вы ввели невозможный тип игрока. Был автоматически создан Робот со здоровьем 50, силой 50 и батареей 50")
                return (Robot(hp=50, power=50, battery=50))
            }
        }


    }
}
