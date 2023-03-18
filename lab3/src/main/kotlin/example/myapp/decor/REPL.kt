package example.myapp.decor

// const val 的值在编译时确定，而 val 的值在程序执行期间确定
// 即 val 可以在运行时由函数赋值
// const val 仅适用于顶层
const val rocks = 3

// const val 仅适用于使用 object 声明的单例类，而不适用于常规类
// 可以使用它创建仅包含常量的文件或单例对象，并根据需要导入此类文件或单例对象
object Constants{
    const val CONSTANT2 = "object constant"
}

val foo = Constants.CONSTANT2

// 创建伴生对象
// 伴生对象从包含类的静态构造函数进行初始化，即系统会在创建对象时创建伴生对象
// 常规对象会在首次访问该对象时(首次使用时)延迟进行初始化
class MyClass{
    companion object {
        const val CONSTANT3 = "constant in companion"
    }
}


// 扩展函数
// 扩展函数是在类之外定义的函数，但可以在类中使用

//fun String.hasSpaces(): Boolean{
//    val found = this.indexOf(' ')
//    // 如果找到空格，则返回 true
//    return found != -1
//}

// 将函数缩减为一个表达式并返回
fun String.hasSpaces() = indexOf(" ") != -1


// 扩展函数只能访问要扩展的类的公共API.无法访问 private 或 protected 成员
// 扩展函数会在编译时根据变量类型进行静态解析

class AquariumPlant(val color: String, private val size: Int)

fun AquariumPlant.isRed() = color == "red"

//fun AquariumPlant.isBig() = size > 50

open class AquariumPlant2(val color: String, private val size: Int)

class GreenLeafyPlant(size: Int): AquariumPlant2("green", size)

fun AquariumPlant2.print() = println("AquariumPlant2")

fun  GreenLeafyPlant.print() = println("GreenLeafyPlant")

// isGreen 属性的访问方式与常规属性相同； 访问时，系统会调用 isGreen 的 getter 来获取该值
val AquariumPlant2.isGreen : Boolean
    get() = color == "green"

//fun main() {
//    val plant = GreenLeafyPlant(size = 50)
//    plant.print()
//
//    val aquariumPlant: AquariumPlant2 = plant
//    // 扩展函数会在编译时根据变量类型进行静态解析，因此调用的是 AquariumPlant2.print()
//    aquariumPlant.print()
//
//    println(aquariumPlant.isGreen)
//}

// 可为 null 的接收器
// 如果扩展函数的接收器可以为 null，则必须在扩展函数名称之前添加问号
fun AquariumPlant?.pull() {
    this?.apply {
        println("removing $this")
    }
}

val plant: AquariumPlant? = null

fun main(){
    plant.pull()
}

//fun main() {
//  对和三元组
//    // 1. 创建一些对和三元组
//
//    // 使用关键字 to 创建一个用于连接两个值(如两个字符串)的表达式，然后使用 .first 或 .second 来引用每个值
//    val equipment = "fish net" to "catching fish"
//    println("${equipment.first} used for ${equipment.second}")
//
//    // Triple: 三元组
//    val numbers = Triple(6, 9, 42)
//    println(numbers.toString())
//    println(numbers.toList())
//
//    // 创建一个对，其中该对的第一部分本身就是一个对
//    val equipment2 = ("fish net" to "catching fish") to "equipment"
//    println("${equipment2.first} is ${equipment2.second}")
//    println("${equipment2.first.second}")
//
//    // 2. 解构一些对和三元组
//    // 解构对和三元组与数据类的工作原理相同
//    val (tool, use) = equipment
//    println("$tool is used for $use")
//
//    val (n1, n2, n3) = numbers
//    println("$n1 $n2 $n3")

//// 集合
//    // 1. 详细了解列表
//    val list = listOf(1, 5, 3, 4)
//    println(list.sum())
//
//    val list2 = listOf("a", "bbb", "cc")
//    println(list2.sumOf { it.length })
//
//    for (s in list2.listIterator()){
//        print("$s ")
//    }
//    println()
//
//    // 哈希映射
//    // hashMapOf()
//    // 创建与鱼类通用名(键)和这些与的学名(值)的哈希映射
//    val scientific = hashMapOf("guppy" to "poecilia reticulata", "catfish" to "corydoras", "zebra fish" to "danio rerio")
//    // 通过get() 或者[] 来根据鱼类通用名检索学名值
//    println(scientific.get("guppy"))
//    println(scientific.get("zebra fish"))
//    // 若映射中未包含某个键，尝试返回匹配的学名会返回 null
//    println(scientific.get("swordtail"))
//    // getOrDefault()查找
//    println(scientific.getOrDefault("swordtail", "sorry, I don't know"))
//
//    // getOrElse()
//    // 执行大括号{}之间的任何代码,而不是返回简单的默认值(大括号中的默认最后一行代码为返回值)
//    println(scientific.getOrElse("swordtail"){
//        println("i'm ok")
//        "sorry, I don't know"
//    })
//
//
//}


//}
