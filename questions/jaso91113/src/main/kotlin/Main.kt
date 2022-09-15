class MyData {}

fun create() = MyData()
fun createList() = listOf(MyData(), MyData())

fun main() {
    val data = create()
    val list = createList()
}
