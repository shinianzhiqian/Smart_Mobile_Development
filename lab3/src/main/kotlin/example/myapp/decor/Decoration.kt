package example.myapp.decor
//
//// 1.创建数据类
//data class Decoration(val rocks: String) {
//}
//
//fun makeDecorations(){
//    val decoration1 = Decoration("granite")
//    println(decoration1)
//
//    val decoration2 = Decoration("slate")
//    println(decoration2)
//
//    val decoration3 = Decoration("slate")
//    println(decoration3)
//
//    println("decoration1.equals(decorations2) = " + decoration1.equals(decoration2))
//    println("decoration2.equals(decorations3) = " + decoration2.equals(decoration3))
//
//    // 对数据类型对象使用 == 等同于使用 equals() (结构性等式)
//    println("decoration1 == decorations2 = " + (decoration1 == decoration2))
//    println("decoration2 == decorations3 = " + (decoration2 == decoration3))
//
//    // === 运算符检查两个变量是否引用同一对象
//    println("decoration1 === decorations2 = " + (decoration1 === decoration2))
//    println("decoration2 === decorations3 = " + (decoration2 === decoration3))
//
//    // 将数据类对象赋给其他变量会复制对该对象而非内容的引用
//    // 如果需要将内容复制到新对象，使用 copy 方法
//
//}
//
//// 2.解构
//data class Decoration2(val rocks: String, val wood: String, val diver:String){
//}
//
//fun makeDecorations2() {
//    val d5 = Decoration2("crystal", "wood", "diver")
//
//    println(d5)
//
//    val (rock, wood, diver) = d5
//    println(rock)
//    println(wood)
//    println(diver)
//
//    val (rock2, _, diver2) = d5
//
//}
//
//// 枚举类
//enum class Color(val rgb: Int){
//    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF)
//}
//fun main() {
////    makeDecorations()
////    makeDecorations2()
//    println(Color.GREEN.name)
//    println(Color.GREEN.ordinal)
//    println(Color.GREEN.rgb)
//}

// 伴生对象
// 1.伴生对象从包含类的静态构造函数进行初始化，即系统会在创建对象时创建伴生对象
// 2.常规对象会在首次访问该对象时(即首次使用时)延迟进行初始化

class Choice(){
    companion object{
        var name: String = "lyric"
        fun showDescription(name: String) = println("My favorite $name")
    }
}

fun main(){
    println(Choice.name)
    Choice.showDescription("Pick")
    Choice.showDescription("selection")
}