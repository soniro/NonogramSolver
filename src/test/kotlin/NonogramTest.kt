import de.soniro.nonogramsolver.Cell.*
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
            arrayOf(EMPTY, EMPTY, EMPTY, 1, 0, 1, 1, 1, 0, 1, 1),
            arrayOf(1, 3, 2,
                FILL, NOT_FILLED,
                FILL, FILL, FILL, NOT_FILLED,
                FILL, FILL))

        nonogram.fillTrivialRows()

        nonogram.print()

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
            arrayOf(EMPTY, 1, 1, EMPTY),
            arrayOf(EMPTY, 3, 3, EMPTY),
            arrayOf(EMPTY, 2, 2, 8),
            arrayOf(3, FILL, FILL, FILL),
            arrayOf(1, NOT_FILLED, NOT_FILLED, FILL),
            arrayOf(3, FILL, FILL, FILL),
            arrayOf(3, FILL, FILL, FILL),
            arrayOf(3, FILL, FILL, FILL),
            arrayOf(1, NOT_FILLED, NOT_FILLED, FILL),
            arrayOf(3, FILL, FILL, FILL),
            arrayOf(3, FILL, FILL, FILL))

        nonogram.fillTrivialColumns()

        nonogram.print()

        assertArrayEquals(expectedGrid, nonogram.grid)
    }

    @Test
    fun writeColumn() {
        val full = intArrayOf(3)
        val single = intArrayOf(1)
        val matchForTrivialColumns = arrayOf(full, single, full, full, full, single, full, full)
        val nonogram = Nonogram(
            matchForTrivialColumns,
            arrayOf(intArrayOf(1, 3, 2), intArrayOf(1, 3, 2), intArrayOf(8)))

        nonogram.writeColumn(arrayOf(FILL, FILL, FILL, NOT_FILLED, FILL, FILL, FILL), 3)

        val expectedGrid: Array<Array<Any>> = arrayOf(
            arrayOf(EMPTY, 1, 1, EMPTY),
            arrayOf(EMPTY, 3, 3, EMPTY),
            arrayOf(EMPTY, 2, 2, 8),
            arrayOf(3, EMPTY, EMPTY, FILL),
            arrayOf(1, EMPTY, EMPTY, FILL),
            arrayOf(3, EMPTY, EMPTY, FILL),
            arrayOf(3, EMPTY, EMPTY, NOT_FILLED),
            arrayOf(3, EMPTY, EMPTY, FILL),
            arrayOf(1, EMPTY, EMPTY, FILL),
            arrayOf(3, EMPTY, EMPTY, FILL),
            arrayOf(3, EMPTY, EMPTY, EMPTY))

        nonogram.print()

        assertArrayEquals(expectedGrid, nonogram.grid)
    }

}