package de.soniro.nonogramsolver

import kotlin.math.max

class Nonogram(val rows: Array<IntArray>, val columns: Array<IntArray>) {

    companion object {
        const val FILL = "\u2588"
        const val EMPTY = " "
        const val NOT_FILLED = "X"
        const val UNKNOWN = "?"
    }

    private val grid: Array<Array<Any>>
    private val columnOffset: Int
    private val rowOffset: Int

    init {
        columnOffset = longestSubArray(rows)
        rowOffset = longestSubArray(columns)
        grid = Array(numberOfRows()) { row -> Array<Any>(numberOfColumns()) {
                column ->
            if (row < rowOffset || column < columnOffset) EMPTY
            else if (row % 2 == 0 && column % 2 == 0) FILL
            else NOT_FILLED
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
}