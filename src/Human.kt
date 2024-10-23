abstract class Human (var hp:Int, val power:Int, val name:String) : Comparable<Human> {
    abstract fun attack(human: Human)
    abstract fun heal()
    abstract fun is_attacked(harm: Int)
    abstract override fun toString(): String

    override fun compareTo(other: Human) : Int{
        if (hp == other.hp) {
            return 0
        }
        if (hp > other.hp) {
            return 1
        } else {
            return -1
        }

    }
}
