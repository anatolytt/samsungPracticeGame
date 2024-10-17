import kotlin.math.round
import kotlin.random.Random

class Robot (hp:Int,
             power:Int,
             name: String="Робот",
             var battery:Int) : Human(hp, power, name) {

    override fun attack(human:Human) {
        var harm: Int = power
        var batteryUsed: Int = 0
        if (battery <= 1) {
            battery = 1
            batteryUsed = 1
        }
        batteryUsed = Random.nextInt(1, (battery/10)+2)
        if (battery > 70) {
            harm = (harm*(1 + (batteryUsed.toDouble() / battery.toDouble()).toInt()))
        } else {
            harm = (harm*(1-(batteryUsed.toDouble() / battery.toDouble()))).toInt()
        }
        battery -= batteryUsed
        println("Робот нанёс урон $harm, потеряв $batteryUsed% батареи. ")
        human.is_attacked(harm)
    }

    override fun heal() {
        var batteryUsed : Int;
        if (battery <= 0) {
            battery = 0
            batteryUsed = 0
        } else {
            batteryUsed = Random.nextInt(1, (round(battery.toDouble()/10)+2).toInt())
        }

        hp += batteryUsed
        battery -= batteryUsed
        if (hp>100) { hp = 100 }
        if (hp < 0) { hp = 0 }

        println("Робот вылечился и увеличил свое здоровье на ${batteryUsed}%, потеряв ${batteryUsed}% батареи")
    }

    override fun is_attacked(harm: Int) { hp -= harm }
    override fun toString(): String { return "Робот: здоровье = $hp, сила = $power, батарея = $battery%" }
}