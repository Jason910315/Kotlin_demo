// Class 定義使用與 C++ 類似
class House{
    var color : String = "White"
    var numberOfwindows : Int = 2
    var isSale : Boolean = true

    fun updateColor(s : String) : Unit{
        this.color = s
    }
}

// Constructor，建構子若有參數時，必須在前加上 val or var，否則參數並不會傳入到物件屬性裡
class C(val y : Int){
    val b : Int = y
}

// Constructor 的優先順序
// 1. Primary Constructor
// 直接宣告在 class header，若 class 為定義任何建構子，則 without ant parameters 的 primary constructor 會預測提供
class B(val n : Int)

//2. Initializer block
// 可以有多個 initializer block(執行順序與宣告順序一樣)，建立物件時會馬上執行
class A(val input : Int){
    init {
        println(input)
    }
}
fun main(){
    val house1 = House()
    println(house1.color)
    val cc = C(5)
    println(cc.y)  // => 透過建構子傳入的參數會變成物件的屬性

    // 使用 Initializer block
    val aa = A(20)   // => 印出 20
}