package example.myapp

import sun.security.util.Length
import java.lang.Math.PI

//class Aquarium(var length: Int = 100,var  width: Int = 20, var height: Int = 40) {
//    // 系统会按照 init 块在类定义中显示的顺序执行这些块，并在调用构造函数时执行所有这些块
//    init {
//        println("aquarium initializing")
//    }
////    init {
////        println("Volume: ${width * length * height / 1000} iters")
////    }
//
//    constructor(numberOfFish: Int): this(){
//        val tank = numberOfFish * 2000 * 1.1
//        height = (tank / (length * width)).toInt()
//    }
//    // 可见性修饰符: public 、 private 、 protected 、 internal
//    // 外部代码只能读取该属性
//    var volume: Int
//        get() = width * height * length / 1000
//        private  set(value){
//            height = (value * 1000) / (width * length)
//        }
//    fun printSize(){
//        println("Width: $width cm "+
//                "Length: $length cm " +
//                "Height: $height cm ")
//        println("Volume: $volume iters")
//    }
//}

// 将某个类标记为 open 才能将其子类化
// 还需将属性和成员变量标记为 open 才能在子类中替换它们
open class Aquarium(open var length: Int = 100, open var width: Int = 20, open var height: Int = 40){
    init {
        println("aquarium initializing")
    }
    open var volume: Int
        get() = width * height * length / 1000
        set(value){
            height = (value * 1000) / (width * height)
        }

    open val shape = "rectangle"

    open var water: Double = 0.0
        get() = volume * 0.9

    fun printSize(){
        println(shape)
        println("Width: $width cm " +
                "Length: $length cm " +
                "Height: $height cm ")

        println("Volume: $volume liters Water: $water liters (${water / volume * 100.0}% full)")
    }
}

// 子类替换父类属性需要使用 override 关键字
// 子类需要显示声明其构造函数参数
class TowerTank(override var height: Int, var diameter: Int): Aquarium(height = height, width = diameter, length = diameter){
    override var volume: Int
        get() = (width / 2 * length / 2 * height / 1000 * PI).toInt()
        set(value){
            height = ((value * 1000 / PI) / (width / 2 * length / 2)).toInt()
        }

    override var water = volume * 0.8

    override val shape = "cylinder"

}