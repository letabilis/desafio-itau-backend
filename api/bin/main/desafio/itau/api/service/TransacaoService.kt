package desafio.itau.api.service

import desafio.itau.api.dto.TransacaoDTO
import org.springframework.stereotype.Service
import java.time.OffsetDateTime
import java.util.DoubleSummaryStatistics
import java.util.concurrent.BlockingQueue
import java.util.stream.Collectors


@Service
class TransacaoService(var transacoes: BlockingQueue<TransacaoDTO>) {

    fun addTransacao(t: TransacaoDTO) {
        this.transacoes.add(t)
    }

    fun limparTransacoes() {
        this.transacoes.clear()
    }

    fun getEstatisticas(): DoubleSummaryStatistics {
        val agora: OffsetDateTime = OffsetDateTime.now()
        val transacoesAlvo = this.transacoes.filter { t -> t.dataHora.isBefore(agora.minusMinutes(1))}

        val estatistica: DoubleSummaryStatistics = transacoesAlvo.stream()
            .collect(Collectors.summarizingDouble(TransacaoDTO::valor))

        return estatistica
    }
}



