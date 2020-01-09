package de.soniro.nonogramsolver

class Nonogram(val rows: Array<IntArray>, val columns: Array<IntArray>) {

    companion object {
        const val FILL = "\u2588"
        const val EMPTY = " "
        const val NOT_FILLED = "X"
        const val UNKNOWN = "?"
    }

    val grid: Array<Array<Any>>
    private val columnOffset: Int
    private val rowOffset: Int

    init {
        columnOffset = longestSubArray(rows)
        rowOffset = longestSubArray(columns)
        grid = Array(numberOfRows()) { row ->
            Array<Any>(numberOfColumns()) { column ->
                if (row > columnOffset && column > rowOffset) UNKNOWN else EMPTY
            }
        }
        writeColumns()
        writeRows()
    }

    private fun writeColumns() =
        (rowOffset downTo 1).forEach { i ->
            (0..columns.size - 1).forEach { j ->
                if (columns[j].size >= i) {
                    grid[rowOffset - i][columnOffset + j] = columns[j][columns[j].size - i]
                }
            }
        }

    private fun writeRows() =
        (columnOffset downTo 1).forEach { i ->
            (0..rows.size - 1).forEach { j ->
                if (rows[j].size >= i) {
                    grid[rowOffset + j][columnOffset - i] = rows[j][rows[j].size - i]
                }
            }
        }

    private fun numberOfColumns(): Int = columnOffset + columns.size

    private fun numberOfRows(): Int = rowOffset + rows.size

    private fun longestSubArray(array: Array<IntArray>): Int = array.maxBy { it.size }!!.size

    fun print() = grid.forEach { row ->
        row.forEach { cell -> print("$cell ") }
        println()
    }

    fun fillTrivialRows() {
        for ((currentRowIndex, row) in rows.withIndex()) {
            if (row.sum() + row.size - 1 == columns.size) {
                var index = columnOffset
                val rowIndex = rowOffset + currentRowIndex
                for (value in row) {
                    repeat(value) {
                        grid[rowIndex][index] = FILL
                        index++
                    }
                    if (index < numberOfColumns() - 1) {
                        grid[rowIndex][index] = NOT_FILLED
                        index++
                    }
                }
            }
        }
    }

    fun fillTrivialColumns() {
        for ((currentColumnIndex, column) in columns.withIndex()) {
            if (column.sum() + column.size - 1 == rows.size) {
                var index = rowOffset
                val columnIndex = columnOffset + currentColumnIndex
                for (value in column) {
                    repeat(value) {
                        grid[index][columnIndex] = FILL
                        index++
                    }
                    if (index < numberOfRows() - 1) {
                        grid[index][columnIndex] = NOT_FILLED
                        index++
                    }
                }
            }
        }
    }
}