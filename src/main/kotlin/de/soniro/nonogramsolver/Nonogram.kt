package de.soniro.nonogramsolver

import kotlin.math.max

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
        grid = Array(numberOfRows()) { row -> Array<Any>(numberOfColumns()) {
                column -> if (row < columnOffset || column < rowOffset) EMPTY else UNKNOWN
        } }
        writeColumns()
        writeRows()
    }

    private fun writeColumns() {
        for (i in rowOffset downTo 1) {
            for (j in 0..columns.size-1) {
                if (columns[j].size >= i) {
                    grid[rowOffset-i][columnOffset+j] = columns[j][columns[j].size-i]
                }
            }
        }
    }

    private fun writeRows() {
        for (i in columnOffset downTo 1) {
            for (j in 0..rows.size-1) {
                if (rows[j].size >= i) {
                    grid[rowOffset+j][columnOffset-i] = rows[j][rows[j].size-i]
                }
            }
        }
    }

    private fun numberOfColumns() : Int {
        return columnOffset + columns.size
    }

    private fun numberOfRows() : Int {
        return rowOffset + rows.size
    }

    private fun longestSubArray(array: Array<IntArray>): Int {
        var longestArray = 0
        for (subarray in array) {
            longestArray = max(longestArray, subarray.size)
        }
        return longestArray
    }

    fun print() {
        for (row in grid) {
            for (cell in row) {
                print("$cell ")
            }
            println()
        }
    }

    fun fillTrivialRows() {
        for (row in rows) {
            if (row.sum() + row.size-1 == columns.size) {
                var index = columnOffset
                for (value in row) {
                    repeat(value) {
                        grid[rowOffset][index] = FILL
                        index++
                    }
                    if (index < numberOfColumns() - 1) {
                        grid[rowOffset][index] = NOT_FILLED
                        index++
                    }
                }
            }
        }
    }
}