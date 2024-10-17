import kotlin.math.round
import kotlin.random.Random

class Wizard (hp:Int,
              power:Int,
              name: String="Маг",
              private var mana:Mana) : Human(hp, power, name) {

    override fun attack(human: Human) {
        var harm: Int = power;
        val manaHarmK: Double = 1.0
        if (mana == Mana.Power) {
            val manaHarmK = listOf(1.1, 1.2, 1.3, 1.4, 0.9, 2.0)[Random.nextInt(0, 6)]
            harm = (harm.toDouble() * manaHarmK.toDouble()).toInt()
            human.is_attacked(harm)
            if (manaHarmK == 0.9) {
                println("Магу не удалось использовать ману урона в свою пользу. Урон был уменьшен на 10%.")
            } else if (manaHarmK != 1.0) {
                println("Мана была использована магом для увеличения урона. Урон был увеличен на ${round((manaHarmK - 1) * 100).toInt()}%")
            }
        } else {
            println("Маг нанес урон $harm")
            human.is_attacked(harm)
        }
    }
    override fun heal() {
        when (mana) {
            Mana.Health -> {
                hp = round(hp * 1.05).toInt()
                if (hp>100) {hp = 100}
                println("Маг вылечился с использованием маны. Здоровье было увеличено в 1.05 раз")
            }
            Mana.Power -> {
                hp = round((hp * 1.01)).toInt()
                if (hp>100) {hp = 100}
                println("Маг немного вылечился без помощи маны.")
            }
        }
        if (hp < 0) {hp = 0}
    }

    override fun is_attacked(harm: Int) { hp -= harm }
    override fun toString(): String { return "Маг: здоровье = $hp, сила = $power, тип маны = $mana" }
}