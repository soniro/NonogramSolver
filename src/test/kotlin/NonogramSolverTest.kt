import de.soniro.nonogramsolver.Nonogram
import org.junit.jupiter.api.Test

internal class NonogramSolverTest {

    @Test
    fun printNonogram() {
        val row1 : IntArray = intArrayOf(1, 1)
        val row2 : IntArray = intArrayOf(1)
        val row3 : IntArray = intArrayOf(1, 1)

        val column1 : IntArray = intArrayOf(1, 1)
        val column2 : IntArray = intArrayOf(1)
        val column3 : IntArray = intArrayOf(1, 1)
        val nonogram = Nonogram(arrayOf(row1, row2, row3), arrayOf(column1, column2, column3))

        nonogram.print()
    }

    @Test
    fun printNonogram2() {
        val row1 : IntArray = intArrayOf(1, 2)
        val row2 : IntArray = intArrayOf(3)
        val row3 : IntArray = intArrayOf(4, 5, 6)

        val column1 : IntArray = intArrayOf(10, 11)
        val column2 : IntArray = intArrayOf(12)
        val column3 : IntArray = intArrayOf(13, 14)
        val nonogram = Nonogram(arrayOf(row1, row2, row3), arrayOf(column1, column2, column3))

        nonogram.print()
    }
}