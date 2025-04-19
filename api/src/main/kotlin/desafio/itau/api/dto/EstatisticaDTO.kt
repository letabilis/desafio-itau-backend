package desafio.itau.api.dto

import java.util.DoubleSummaryStatistics

class EstatisticaDTO (private val s: DoubleSummaryStatistics){
    val count: Long = s.count
    val sum: Double = s.sum
    val avg: Double = s.average
    val min: Double = s.min
    val max: Double = s.max
}