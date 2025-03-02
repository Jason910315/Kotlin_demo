
fun main() {
    // List，List 可包含任意型別的元素
    // 用 listOf 創造 immutable list
    val e = listOf("type", "abc", "123")
    println(e)
    // Mutable lists 可用 mutableListOf 創造
    val mutableList = mutableListOf("type", "abc", 123)
    println(mutableList)
    mutableList.removeAt(1)  // 移除 index 1 的元素
    mutableList.remove("type")
    mutableList.add("456")
    mutableList[0] = "789"
    println(mutableList)
    // 注意: 當用 val 賦予一個變數 list 時，是可以對該變數指向的 List 物件做修改(除非是 immutable list)，
    // 但不能對變數本身修改，即不能將變數指向新的物件

    // Array，可以包含任何型別的元，使用 arrayOf() 建立
    // Array elements are mutable
    // Array size is fixed
    val arr = arrayOf(1,2,3)
    var a2 = arrayOf(1,2,"Hello")
    // 另一個方法是用 array 的建構子，並搭配初始化函式來定義 array 內容
    val a3 = Array(5){i -> (i * i).toString()}


}
