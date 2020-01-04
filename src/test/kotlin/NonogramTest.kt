import de.soniro.nonogramsolver.Nonogram
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NonogramTest {

    @Test
    fun fillTrivialRows() {
        val filled = intArrayOf(1)
        val notFilled = intArrayOf(0)
        val nonogram = Nonogram(arrayOf(intArrayOf(1, 3, 2)),
            arrayOf(filled, notFilled, filled, filled, filled, notFilled, filled, filled))
        val expectedGrid: Array<Array<Any>> = arrayOf(
            arrayOf(Nonogram.EMPTY, Nonogram.EMPTY, Nonogram.EMPTY, 1, 0, 1, 1, 1, 0, 1, 1),
            arrayOf(1, 3, 2,
                Nonogram.FILL, Nonogram.NOT_FILLED,
                Nonogram.FILL, Nonogram.FILL, Nonogram.FILL, Nonogram.NOT_FILLED,
                Nonogram.FILL, Nonogram.FILL))

        nonogram.fillTrivialRows()

        assertArrayEquals(expectedGrid, nonogram.grid)
    }

}