import kotlin.math.round
import kotlin.random.Random

class Knight (hp:Int,
              power:Int,
              var defence:Int,
              name: String="Рыцарь") : Human(hp, power, name) {

    override fun attack(human: Human) {
        human.is_attacked(power)
        println("Рыцарь нанёс урон $power")
    }

    override fun is_attacked(harm: Int) {
        if (defence > 0) {
            defence -= 1
            println("Рыцарю удалось отразить атаку!")
        } else {
            hp -= harm;
        }

    }

    override fun heal() {
        val hpK = listOf(1.02, 1.04, 1.06, 1.1)[Random.nextInt(0, 4)]
        hp = (hp * hpK).toInt();
        if (hpK == 1.0) { println("Рыцарь не вылечился.") }
        else { println("Рыцарь вылечился, увеличив свое здоровье в $hpK раз") }
        if (hp<0) { hp = 0; }
        if (hp > 100) {
            hp = 100
        }
    }

    override fun toString(): String {
        return "Рыцарь: здоровье = $hp, сила = $power, количество оставшихся использозваний брони = $defence"
    }


}