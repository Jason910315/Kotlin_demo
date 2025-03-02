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

// Secondary constructor
// 使用 constructor 關鍵字建構
// 使用 this 直接調用 primary constructor 或間接呼叫 primary constructor

// If you construct an object using the primary constructor:
// Primary Constructor -> Init blocks
// If you construct an object using one of the secondary constructors:
// Case 1: Init blocks -> Secondary constructor (if no primary constructor)
// Case 2: Primary constructor -> Init blocks -> Secondary constructor
class Circle(val radius : Double){
    constructor(name : String) : this(1.0)
    constructor(diameter : Int) : this(diameter / 2.0){
        println("in diameter constructor")
    }
    init{
        println("Area: ${Math.PI * radius * radius}")
    }
}
class Person(var name : String)

// 存取子 get、set
// set、get 能存取私有欄位的內容會對其內容做修改，以 object.property 來執行 get 區塊內容，若對 object.property 賦值則是執行 set 內容
// 格式: var propertyName : DataType = initialValue
//get(){...}
//set(value){...}
class P1(var firstName : String,var lastName : String){
    val fullName : String
        get(){
            return "$firstName $lastName"
        }
}
class P2(var firstName : String,var lastName : String){
    var fullName : String
        get() = "$firstName $lastName"
        // 透過賦予 fullName 值來修改原先物件的屬性
        set(value){
            var components = value.split(" ")
            firstName = components[0]
            lastName = components[1]
        }
}

// Inheritance: Kotlin 只支援單一繼承(Single class Inheritance)
// 若要實現多重繼承要使用 Interface，建立 Interface 讓其他類別來實作他
// Interface 內的 fun 一定要是 abstract 的，才可以被 override
interface Shape{
    fun computerArea() : Double  // abstract function return Double
}
class Squre(val height : Double) : Shape{
    // 覆寫/實作 Interface 裡的 fun
    override fun computerArea() = height * height
}

// Kotlin 中所有類別預設都是 final，不可被繼承，要允許繼承則父類別要使用 open 關鍵字
// 子類別繼承時，必須初始化父類別的 primary constructor(如果有的話)
open class Base(p : Int)  // 父類別
class Derive(p : Int) : Base(p)  // 子類別

// 若子類別未宣告 primary constructor，則必須在 secondary constructor 內用 super 關鍵字初始化 base class
class View : Base{
    constructor(input : Int) : super(input)
}

// Extension function: fun ClassName.functionName(paras){ body }
// 對已存在的 class 新增函式
// Add isOdd() to Int class:
fun Int.isOdd() : Boolean{ return this % 2 == 1}

// Data Class
// Special class that exists just to store a set of data
// Mark the class with the data keyword
// Requires at least one property in the primary constructor
// Format: data class <NameOfClass>( parameterList )
data class Player(var name : String,var age : Int)

// Object & Singleton
// 用 Object 關鍵子宣告的類別可以做為一個實例，如同 static class 一樣，可以直接調用屬性及方法，用 object 代替 class 關鍵字
object DataBase{
    val name = "DB"
    fun connect(){
        println("Connect to $name")
    }
}
// Companion object
// 類似 C++ 中靜態成員，這個類別還是有其他能讓物件存取的屬性，但用 companion object 關鍵字包住的屬性或方法都是屬於類別的，只能通過類別訪問
class PhysicsSystem{
    // 類別共享 WorldConstants 裡的屬性
    companion object WorldConstants{
        val gravity = 9.8
        val unit = "metric"
        fun compute(mass : Double,accel : Double) : Double{
            return mass * accel
        }
    }
}

fun main(){
    val house1 = House()
    println(house1.color)
    val cc = C(5)
    println(cc.y)  // => 透過建構子傳入的參數會變成物件的屬性

    // 使用 Initializer block
    val aa = A(20)   // => 印出 20

    val c1 = Circle(4.0)  // 先執行 primary constructor，在執行 init block
    val c2 = Circle(3)  // 參數型別為 Int，因此是使用 secondary constructor，case2
    val person = Person("Jason")
    println(person.name)
    person.name = "Elly"
    println(person.name)
    // get、set
    val p1 = P1("Jason","Yang")
    println(p1.fullName)
    val p2 = P2("Allen","Wang")
    println(p2.fullName)
    p2.fullName = "Timmy Wu"
    println(p2.firstName + " " + p2.lastName)

    // Interface
    val s1 = Squre(10.0)
    val Area = s1.computerArea()
    println("s1 Area: $Area")

    // extension function: 上述已將 isOdd() 新增近 Int 類別裡
    if(3.isOdd() == false){
        println("是偶數")
    }
    else{
        println("是奇數")
    }

    // Data class，用來儲存 data 的特殊類別
    val firstPlayer = Player("Lucas",25)
    println(firstPlayer)
    val (name,age) = firstPlayer  // 將 firstPlayer 儲存的 data 指派給 name、age
    println("name: $name, age: $age")

    // object，類別直接調用屬性、方法
    DataBase.connect()  // 直接用類別名稱調用方法
    println(DataBase.name)

    // Companion object，只能使用類別自身來訪問
    println(PhysicsSystem.WorldConstants.gravity)

}