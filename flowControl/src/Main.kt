fun main(){
    // if 不僅可以做判斷式，也可以做表達式(expression)，返回一個值
    val a = 5;
    val b = 10
    val max = if (a > b) a else b

    // Range operator: 1~100 可表示為 1..100(注意 operator 間是沒有間隔的)
    val number = 50
    if(number in 1..100){  // 相等於 if(number >= 1 && number <= 100)
        println(number)
    }
    // when expression，相當於 switch 功能
    val x = 0
    when(x){
        1 -> println("x is 1")
        2 -> println("x is 2")
        else -> {   // 也可用 block 框住執行式
            println("x is nothing")
        }
    }
    // multiple cases 也可以放在同一個式子內
    when(x){
        0,1 -> println("right")
        else -> println("wrong")
    }
    // in or !in 可檢測便數是否存在 range 裡
    when(x){
        in 1..10 -> println("x is in the range of 1-10")
        !in 10..20 -> println("x is out of range")
    }
    // when 也可以接在 fun 後面
    fun hasPrefix(x : Any) = when(x){
        is String -> x.startsWith("prefix")  // 如果 x 是 String，檢查它是否以 "prefix" 開頭
        else -> false
    }

    // for loop
    val arr1 = arrayOf(1,2,3,4,5)
    for(i in arr1.indices){
        println(arr1[i])
    }
    for(i in 1..5){
        println(i)  // => 12345
    }
    for(i in 5 downTo 1){
        println(i)    // => 54321
    }
    for(i in 3..6 step 2){
        println(i)  // => 35
    }

    // repeat loop
    repeat(2){   // 重複執行兩次大括號內程式
        println("hello")
    }

    // null variables，Kotlin 中 null 型別預設是不允許的
    // val a : Int = null  => error
    // 若想將變數設為 null，則要使用 safe call operator ,'?'
    var numberOfnull : Int? = null
    // 安全呼叫運算子,'?.'，好處為當便數為 null 時，不會拋出 NullPointerException
    // ?. 用於當變數可能為 null 時，安全地調用其方法。
    // 如果變數為 null，則不執行方法，直接回傳 null。
    var num : Int? = 6
    num = num?.dec()   // 若 num 不為 null 則執行 -1

    // 若想強制確保變數不為 null，可用 '!!'，期會拋出 NullPointerException
    val n = num !! + 1
}