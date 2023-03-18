package example.myapp

//abstract class AquariumFish {
//    abstract val color: String
//}

interface FishAction {
    fun eat()
}

//class Shark: AquariumFish(), FishAction{
//    override val color: String = "grey"
//    override fun eat() {
//        println("hunt and eat fish")
//    }
//}
//
//class Plecostous : AquariumFish(), FishAction{
//    override val color: String = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}

// 一个类中可以实现多个接口，但只能从一个类创建子类
// 接口委托： 接口的方法由帮助程序(或委托)对象实现， 该帮助程序(或委托)对象然后由类使用

// 1.创建一个新接口
interface FishColor {
    val color: String
}

//class Plecostomus : FishAction, FishColor {
//    override val color = "gold"
//    override fun eat() {
//        println("eat algae")
//    }
//}
//
class Shark : FishAction, FishColor {
    override val color = "grey"
    override fun eat() {
        println("hunt and eat fish")
    }
}

// 2.创建一个单例类
// 关键字 object 将创建一个实例，该实例按类名称引用。因此，所有其他对象只能使用该实例，不能创建此类的其他实例
object GoldColor: FishColor{
    override val color = "gold"
}

// 3. 为 FishColor 添加接口委托
//class Plecostomus : FishAction, FishColor by GoldColor{
//    override fun eat() {
//        println("eat algae")
//    }
//}

// 采用传递的fishColor 及其构造函数， 并将其默认值设置为 GoldColor
//class Plecostomus(fishColor: FishColor = GoldColor) : FishAction, FishColor by fishColor{
//    override fun eat() {
//        println("eat algeae")
//    }
//}

// 4. 为 FishAction 添加接口委托
class PrintingFishAction(val food: String): FishAction{
    override fun eat() {
        println(food)
    }
}

class Plecostous(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("eat algae"),
        FishColor by fishColor