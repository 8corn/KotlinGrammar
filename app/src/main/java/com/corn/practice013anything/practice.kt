package com.corn.practice013anything

fun main() {
    var a: Int      // 자료형 선언시 -> 변수: type
    a = 123
    println(a)

    val b: Int = 1232
    println(b)

    var c: Int? = null
    println(c)

    var d: String = a.toString()
    println(d)

    println("1-----------")

    var intArr: Array<Int> = arrayOf(1, 2, 3, 4)
    var intArr2 = arrayOfNulls<Int>(5)                  // type 생략 가능
    var anyArr : Array<Any> = arrayOf(1, "awd", 3.2, 4)      // Any는 데이터 타입의 최상위 (어느 데이터든 다 들어갈 수 있음)
    println(intArr[0])
    println(intArr2[1])
    println(anyArr[1])

    println("2-----------")

    println(add(1, 2, 3))
    println(add2(1, 2, 3))

    println("3-----------")

    var e = 7
    if (e > 6) {
        println(e)
    } else {
        println("bye")
    }

    var f: Any = 1
    if (f is Int) {
        println("int")
    }
    if (f is String) {
        println("string")
    }

    println("4-----------")

    exWhen(2)
    exWhen2(2)

    var g: Int = 0
    while (g < 3) {
        print(g)
        g++
    }
    println()

    println("5-----------")

    for (i in 0..3) {
        print(i)
        print(" ")
    }
    println()

    for (i in 3 downTo 0) {
        print(i)
        print(" ")
    }
    println()

    for (i in 0..5 step 2) {
        print(i)
        print(" ")
    }
    println()

    for (i in 'a'..'e') {
        print(i)
        print(" ")
    }
    println()

    println("6-----------")

    for (i in 0..5) {
        if (i == 2) {
            break
        }
        print(i)
        print(" ")
    }
    println()

    for (i in 0..5) {
        if (i == 2) {
            continue
        }
        print(i)
        print(" ")
    }
    println()

    asd@for (i in 0..10) {
        for (j in 0..10) {
            if (i == 0 && j == 3) {
                break@asd
            }
            println("$i, $j")
        }
    }

    println("7-----------")

    var h = Prs("jk", 27)
    println("${h.birth} ${h.name}")
    h.introduce()

    var h2 = Prs2("8corn", 25)

    var h3 = Prs3("김철권")

    println("8-----------")

    var dog = Dog("eve", 8)
    dog.introduce1()
    dog.introduce()

    var h4 = Rabbit()
    h4.eat()
    h4.sniff()

    println("9-----------")

    var j = Cat(4)
    j.eat()
    j.run()

    println("10-----------")

    lamda2(::lamda)  // 함수를 넘겨줄 때 ::을 붙인다. -> lamda를 lamda2로 넘겨줌

    // 람다 함수로 작성된 k
    // (입력 타입) -> 반환 타입 = {변수이름: 입력타입 -> 구몬}
    // 아래 두개의 k, l처럼 타입 생략 가능
    var k: (String) -> Unit = {s -> println(s) }
    var l = {s: String -> println(s) }
    var m = {s: String -> s}                    // s를 반환함
    var n = {                                   // 인자가 없는 경우
        println("xyzcs")
    }
    var o : (String) -> Unit = { println(it) }  // 인자가 하나일 경우 it 카워드 사용

    k("zxc")
    l("sss")
    println(m("ccc"))
    n()
    o("qqq")
}


// ---------- 함수 ---------------


fun add(a: Int, b: Int, c:Int): Int{        // 함수의 기본형 fun 함수이름(매개변수: type): return type
    return a + b + c;
}

fun add2(a: Int, b:Int, c:Int) = a + b + c  // int a, b, c를 더하므로 반환형 타입이 int라 추론 가능

fun exWhen(a: Any) {
    when(a) {
        1 -> println(a)
        "awd" -> println(a)
        else -> println(a)
    }
}

fun exWhen2(a: Any) {
    var b =
        when(a) {
            1 -> a
            "awd" -> a
            else -> a
        }
    println(b)
}

class Prs(var name: String, val birth: Int) {
    fun introduce() {
        println("$name $birth")
    }
}
/**
 * init
 * 1. 객체 초기화의 책임을 명확히 분리, 코드의 가독성과 유지 보수성을 높임
 * 2. 객체가 생성될 때 자동으로 실행되므로 초기화 작업을 한 곳에 모아둘 수 있음 -> 객체 생성 직후 필요한 작업을 init으로 처리하면 다른 메서드에서 이를 처리 안해도 됨
 * 3. 만약 초기화 작업을 별도 메서드에서 처리한다면, 객체 생성 후 매번 메서드를 호출해야 함 -> init으로 단점 보수
 * 4. 객체 생성 시 바로 실행되므로, 객체가 항상 올바른 상태로 초기화될 수 있음 -> 객체 속성을 검증하거나 계산해야 할 때 유용
 * 5. init 블록 없이 검증하면 객체가 잘못된 상태로 생성될 수 있음
 */
class Prs2(var name: String, val birth: Int) {      // Prs함수는 생성자를 만들면 생성자를 실행하면서 구문을 넣을 수 없지만
    init {                                          // init를 사용하여 생성자를 출력했을 때 구문이 실행되게 할 수 있다.
        println("${this.name} ${this.birth}")
    }
    init {                                          // init은 여러개 사용가능
        println(1)
    }
}

class Prs3(var name: String, val birth: Int) {
    constructor(name: String): this(name, 23)       // this를 사용해 기본 생성자로 값을 넘겨줘야 함 -> contructor = 보조 생성자 -> 오버로딩 생성자를 만들 수 있음
    init {
        println("${this.name} ${this.birth}")
    }
}
/**
 * 상속
 * 1. 클래스를 상속할 때 부모 클래스는 open을 사용하여야 상속 가능
 * 2. 또한 서브 클래스의 속성들은 부모 클래스의 속성과 이름이 같으면 안됨
 * 3. 함수를 override 할 때는 override 키워드 사용
 * 4. 함수를 override 할 때도 부모 클래스의 함수에 open 키워드를 사용해야 함
 */
open class Animal(var name: String, var age: Int, var type: String) {
    open fun introduce() {
        println("${this.name} ${this.age} ${this.type}")
    }
}

class Dog(var name1: String, var age1: Int): Animal(name1, age1, "dog") {
    fun introduce1() {
        super.introduce()
    }

    override fun introduce() {
        println("override")
    }
}

// 추상 클래스

abstract class Animal2 {
    abstract fun eat()
    fun sniff() {
        println("mung")
    }
}

class Rabbit: Animal2() {
    override fun eat() {
        println("kkangchong")
    }
}

/**
 * 인터페이스
 * 추상 함수뿐 아니라 속성과 일반 함수도 선언 할 수 있다. But 생성자는 생성할 수 없다.
 * 인터페이스의 유용성 -> 클래스들이 동일한 메서드와 속성을 구현하도록 강제할 수 있음, 코드의 일관성과 재사용성을 높임
 * 구현부가 있는 함수 -> open 함수로 간주
 * 구현부가 없는 함수 -> abstract 함수로 간주
 *
 * *구현부란? -> 해당 인터페이스에 정의된 메서드의 동작을 실제로 작성하는 부분, 구현부가 있는 메서드는 인터페이스에서 기본 동작을 제공
 */

interface Runner {
    fun run()
}

interface Eater {
    fun eat() {
        println("ggudang")
    }
}

class Cat(var a: Int): Runner, Eater {
    override fun run() {
        println("run")
    }

    override fun eat() {
        println("eat")
    }
}

/**
 * 고차함수(람다함수)
 * 함수를 클래스에서 만들어낸 인스턴스처럼 취급하는 방법
 * -> 함수를 파라미터로 넘겨줄 수 있음
 * -> 결과값으로도 반환 받을 수 있음
 */

fun lamda(str: String): String {
    return str
}

// 이름: (입력받을 타입) -> (리턴타입) 즉, a라는 함수와 같으면 된다.
fun lamda2(funs: (String) -> String) {          // 가져온 함수에 인자를 넣어 실행
    println(funs("람다함수"))
}