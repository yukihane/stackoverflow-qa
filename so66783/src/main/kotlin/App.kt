interface IHoge {
    fun test()
}

class A : IHoge {
    override fun test() {}
}

class C : IHoge {
    @Deprecated(message = "利用不能メソッド", level = DeprecationLevel.ERROR)
    override fun test() {}
}

fun main(args: Array<String>) {
    val c = C()
    c.test() // コンパイルエラー

    val i: IHoge = C()
    i.test() // コンパイルエラーにならない
}
