
fun printHello() {
    // 輸出文字
    println("Hello, world")
}
// 程式進入點
fun main() {
    // kotlin 中所有變數都是一個物件，因此可以對其呼叫 member function 或 properties
    println(2.times(5));  // 變數 2 呼叫 times function
    println(3.5.plus(4))

    // Data Type
    // 所有初始化的整數若未超過 Int 長度，則預設都是 Int 型別
    val one = 1  // Int
    val threeBillion = 3000000  // Long(超過 Int 長度)
    val oneLong = 1L  // Long
    val oneByte : Byte = 1

    // 所有初始化的 fractional number 都預設為 Double
    val pi = 3.14  // Double
    val e : Float = 2.7182818284F // Float
    val eFloat = 2.7182818284F    // Float

    // String
    val str = """
        Hello,
        my name is
        Jason
    """.trimIndent()  // 使用三重引號 """ 可以定義多行字串，不需要任何換行或跳脫字服即可實現功能
    println(str)

    // Kotlin 中不同數值類型（如 Byte, Int, Float, Double 等）之間不會進行隱式類型轉換
    val i : Int = 6;
    // val b : Byte = i  // 產生 Type mismatch error，因為 Kotlin 不會自動轉型
    val b : Byte = i.toByte()  // 應該使用強制轉換

    // 當我們需要使用可空變數（如 Int?）時，數字會被裝箱（Boxing）為物件，這時候就不再是原始類型，而是對應的物件（Object）
    // 在 Kotlin 中：
    // 1. ==（等值比較）：比較「值」是否相等。
    // 2. ===（識別比較）：比較「記憶體位址」是否相同（即是否是同一個物件）。
    val a : Int = 100000  // 變數在 -127~127 間仍會以 JVM 緩存，但超過則 Boxed 時就會指向不同物件
    val boxedA1 : Int? = a
    val boxedA2 : Int? = a
    print("equality: ${boxedA1 == boxedA2}\n")
    print("Identity: ${boxedA1 === boxedA2}")

    // arithmetical operations
    // Kotlin 中的位元計算不像普通語言，如左移並不是 <<
    val n : Int? = 4;
    val s = n?.and(4)     // and operation
    val t = n?.shl(2)   // signed shift left 2

    // Kotlin 中的 Character 型別不能被直接是為 Int
    fun equal(c:Char) : Boolean{
        if(c.toInt() == 1) {
            return true
        }
        return false
    }

    // String
    // String is "immutable" ,ex: s[2] = 'a' error
    // 字符串插值，使用 '$' 實現，有兩種寫法，一是 $ + 變數，另一個方法是 $ + {變數}
    val j = 10
    println("str is $j")
    val z = "abc"
    println("$z.length is ${z.length}")  // print abc.length is 3



}