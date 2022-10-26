class dqw {
    fun <T> List<T>.slidingWindow(size: Int): List<List<T>> {
        if (size < 1) {
            throw IllegalArgumentException("Size must be > 0, but is $size.")
        }
        return this.mapIndexed { index, _ ->
            this.subList(maxOf(index - size + 1, 0), index + 1)
        }
    }
    fun Iterable<Float>.mean(): Float {
        val sum: Float = this.sum()
        return sum / this.count()
    }
    fun sumTo(n: Int): Int = n * (n + 1) / 2

    fun Iterable<Float>.weightedMean(): Float {
        val sum: Float = this
            .mapIndexed { index, t -> t * (index + 1) }
            .sum()
        return sum / sumTo(this.count())
    }
    fun movingAverage(entries: List<Float>, window: Int,
                      averageCalc: Iterable<Float>.() -> Float): List<Float> {
        val result = entries.slidingWindow(size = window)
            .filter { it.isNotEmpty() }
            .map { it -> it.averageCalc() }
            .toList()
        return result
    }

}
