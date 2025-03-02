// 當 fun 不回傳任何有效值時，可以使用 Unit
fun printHello(s : String) : Unit{
    println("hello" + s)
}
// Default parameters，當呼叫 fun 未傳入參數值時，會自動帶入
fun printSpeed(s : String = "fast"){
    print("Drive " + s + "\n")
}

// 當函式的邏輯只有單一運算，可以使用更簡潔的語法來撰寫函式，提升可讀性與效率。
fun double(x: Int): Int = x * 2  // 直接使用 = 來指定回傳值



fun main() {
    printHello("jason")

    // Default parameters
    printSpeed()  // => Drive fast
    printSpeed("slow")  // => Drive slow
    printSpeed(s = "turtle")  // => Drive turtle

    // Lambdas and higher-Order functions
    // Lambdas 是一種匿名函式，可以用來當作變數儲存、傳遞給其他函式，或者自己執行
    val lambdaFun1 = { level: Int -> level / 2 }
    val lambdaFUn2: (Int) -> Int = { level -> level / 2 }
    val water = 10
    println(lambdaFun1(water))
    // 正確語法: val 變數名稱 = (參數型別) -> 傳回型別 = {參數名稱 : 參數類型 -> lambda 程式}

    // Higher-order functions，高階函式是 「接受函式作為參數」 或 「回傳函式」 的函式
    fun encodeMsg(msg : String,encode : (String) -> String) : String{
        return encode(msg)
    }
    // 參數：
    // msg: String → 要編碼的訊息
    // encode: (String) -> String → 函式型參數，代表一個接受 String 並回傳 String 的函式
    // 回傳值： String
    val msg = "hello"
    val encodeUpper = {s : String -> s.uppercase()}  // 匿名函數不用特別定義函式名稱
    // 傳入函式型參數，此處使用匿名函式，將函式指派給 encodeUpper 變數
    val result = encodeMsg(msg,encodeUpper)
    println(result)
    // 也可以這樣寫
    val res1 = encodeMsg("abc",{input : String -> input.uppercase()})
    val res2 = encodeMsg("abc"){input : String -> input.uppercase()}

    // Passing function reference，使用'::'來傳遞函式
    // lambda: 不用定義函式名稱，高階函式式呼叫此函式
    // Passing function reference: 要定義函式名稱，讓高階函式知道是傳入此函式當參數
    fun enc2(s : String) = s.reversed()
    val res = encodeMsg(msg,::enc2)
    println(res)  // => olleh



}

