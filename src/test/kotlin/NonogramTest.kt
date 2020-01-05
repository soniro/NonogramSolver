import de.soniro.nonogramsolver.Nonogram
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class NonogramTest {

    @Test
    fun fillTrivialRows() {
        val filled = intArrayOf(1)
        val notFilled = intArrayOf(0)
        val trivialRow = arrayOf(intArrayOf(1, 3, 2))
        val columnsMatchingRow = arrayOf(filled, notFilled, filled, filled, filled, notFilled, filled, filled)
        val nonogram = Nonogram(trivialRow, columnsMatchingRow)
        val expectedGrid: Array<Array<Any>> = arrayOf(
            arrayOf(Nonogram.EMPTY, Nonogram.EMPTY, Nonogram.EMPTY, 1, 0, 1, 1, 1, 0, 1, 1),
            arrayOf(1, 3, 2,
                Nonogram.FILL, Nonogram.NOT_FILLED,
                Nonogram.FILL, Nonogram.FILL, Nonogram.FILL, Nonogram.NOT_FILLED,
                Nonogram.FILL, Nonogram.FILL))

        nonogram.fillTrivialRows()

        assertArrayEquals(expectedGrid, nonogram.grid)
    }

    @Test
    fun fillTrivialColumns() {
        val full = intArrayOf(3)
        val single = intArrayOf(1)
        val matchForTrivialColumns = arrayOf(full, single, full, full, full, single, full, full)
        val nonogram = Nonogram(
            matchForTrivialColumns,
            arrayOf(intArrayOf(1, 3, 2), intArrayOf(1, 3, 2), intArrayOf(8)))
        val expectedGrid: Array<Array<Any>> = arrayOf(
            arrayOf(Nonogram.EMPTY, 1, 1, Nonogram.EMPTY),
            arrayOf(Nonogram.EMPTY, 3, 3, Nonogram.EMPTY),
            arrayOf(Nonogram.EMPTY, 2, 2, 8),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL),
            arrayOf(1, Nonogram.NOT_FILLED, Nonogram.NOT_FILLED, Nonogram.FILL),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL),
            arrayOf(1, Nonogram.NOT_FILLED, Nonogram.NOT_FILLED, Nonogram.FILL),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL),
            arrayOf(3, Nonogram.FILL, Nonogram.FILL, Nonogram.FILL))

        nonogram.fillTrivialColumns()

        assertArrayEquals(expectedGrid, nonogram.grid)
    }

}