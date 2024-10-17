abstract class Human (var hp:Int, val power:Int, val name:String) {
    abstract fun attack(human: Human)
    abstract fun heal()
    abstract fun is_attacked(harm: Int)
    abstract override fun toString(): String
}
