import kotlin.math.pow

fun main() {
    val seqList: MutableList<MutableList<Double>> = ArrayList() // alternatively: = mutableListOf()
    val seqList2: MutableList<Double> = mutableListOf<Double>()
    var zScore: MutableList<Double> = mutableListOf<Double>()

    seqList.add(
        mutableListOf<Double>(
            1666508400000.0, 19185.0, 19169.0, 19185.0, 19165.0, 6.67853525
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666504800000.0, 19190.0, 19184.0, 19198.0, 19176.0, 10.71108993
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666501200000.0, 19196.0, 19191.0, 19204.0, 19181.0, 9.76865547
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666497600000.0, 19208.0, 19196.0, 19234.0, 19193.0, 12.50183245
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666494000000.0, 19209.0, 19208.0, 19210.0, 19202.0, 3.33252165
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666490400000.0, 19195.0, 19209.0, 19219.0, 19194.0, 6.04923604
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666486800000.0, 19212.0, 19191.0, 19214.0, 19179.0, 14.84832207
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666483200000.0, 19219.0, 19212.0, 19229.0, 19211.0, 7.33246192
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666479600000.0, 19210.0, 19219.0, 19221.0, 19210.0, 3.24254642
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666476000000.0, 19217.0, 19209.0, 19224.0, 19202.0, 6.59722566
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666472400000.0, 19234.0, 19217.0, 19238.0, 19211.0, 22.04980786
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666468800000.0, 19202.0, 19234.0, 19241.0, 19196.0, 8.01165382
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666465200000.0, 19192.0, 19202.0, 19208.0, 19190.0, 11.715822
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666461600000.0, 19167.0, 19192.0, 19195.0, 19156.0, 8.51127096
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666458000000.0, 19209.0, 19166.0, 19224.0, 19165.0, 17.26519273
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666454400000.0, 19263.0, 19209.0, 19270.0, 19200.0, 14.78726137
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666450800000.0, 19257.0, 19262.0, 19278.0, 19238.0, 36.23130268
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666447200000.0, 19226.0, 19251.0, 19261.0, 19226.0, 123.71421153
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666443600000.0, 19194.0, 19225.0, 19260.0, 19194.0, 362.34691832
        )
    )
    seqList.add(
        mutableListOf<Double>(
            1666440000000.0, 19190.0, 19194.0, 19212.0, 19172.0, 27.79930519
        )
    )


    for (index in seqList) {
        var y = ((index[3] + index[4]) / 2)
        seqList2.add(y)
    }
    val SD = sd(seqList2)
    var SR = seqList2.movingAverages()
    var result: MutableList<Double> = mutableListOf<Double>()
    var z_Score: MutableList<Double> = mutableListOf<Double>()

    for (i in 0..seqList2.size - 1) {
        var score = seqList2[i] - SR[i]
        result.add(score)
    }
    for (i in 0..result.size - 1) {
        var z_score = result[i] / SD
        z_Score.add(z_score)
        i + 1
    }
    println(z_Score)
}

fun sd(data: MutableList<Double>): Double {
    val mean = data.average()
    return data
        .fold(0.0, { accumulator, next -> accumulator + (next - mean).pow(2.0) })
        .let {
            Math.sqrt(it / data.size)
        }
}


fun MutableList<Double>.movingAverages(): List<Double> {

    val window_size: Int = 4
    var moving_averages = mutableListOf<Double>()


    for (i in 0..window_size - 2) {
        var moving_average = this.subList(0, i + 1).sum() / (i + 1)
        moving_averages.add(moving_average)
        i + 1
    }
    for (i in 0..this.size - window_size) {
        var moving_average = this.subList(i, i + window_size).sum() / window_size
        moving_averages.add(moving_average)
        i + 1
    }
    return moving_averages
}







