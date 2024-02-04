import kotlin.time.measureTime
class MyMutableIntList {
    /**
     * Add [element] to the end of the list
     */
    var list = emptyArray<Int>();
    var next_empty_index: Int = 0;
    fun add(element: Int) {
        val temp_list = list
        if (list.size == 0) {
            list = arrayOf(1)
            list[next_empty_index] = element
            next_empty_index+=1
        }
        if (next_empty_index >= list.size) {
            list = arrayOf(list.size * 2)
            for (index in 0 .. temp_list.size - 1){
                list[index] = temp_list[index]
            }
        }
        if (next_empty_index < temp_list.size) {
            list[next_empty_index] = element
            next_empty_index+=1
        }
    }

    /**
     * Remove all elements from the list
     */
    fun clear() {
        list = emptyArray<Int>()
    }

    /*
     * @return the size of the list
     */
    fun size(): Int {
        return list.size
    }
    /**
     * @param index the index to return
     * @return the element at [index]
     */
    operator fun get(index: Int):Int {
        if (index < list.size) {
            return list[index]
        } else {
            return 0
        }
    }

    /**
     * Store [value] at position [index]
     * @param index the index to set
     * @param value to store at [index]
     */
    operator fun set(index: Int, value: Int) {
        if (index < list.size) {
            list[index] = value
        }
    }

    }

fun main() {
    val arraySizes = listOf(100, 1000, 10000, 100000, 1000000, 10000000, 100000000)
    println("numberOfElements totalTime timePerElement")
    for (arraySize in arraySizes) {
        val myList = MyMutableIntList()
        val timeTaken = measureTime {
            for (i in 0..<arraySize) {
                myList.add(i)
            }
        }
        println("$arraySize $timeTaken ${timeTaken/arraySize}")
    }
}


