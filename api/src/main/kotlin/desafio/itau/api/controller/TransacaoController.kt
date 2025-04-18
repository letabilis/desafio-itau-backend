package desafio.itau.api.controller

import desafio.itau.api.dto.TransacaoDTO
import desafio.itau.api.service.TransacaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime


@RestController
@RequestMapping
class TransacaoController (val transacaoService: TransacaoService){

    @PostMapping("/transacao")
    fun request(t: TransacaoDTO): ResponseEntity<Void> {
        val agora = OffsetDateTime.now()
        if (t.dataHora.isAfter(agora)) {
            return ResponseEntity.unprocessableEntity().build()
        }
        this.transacaoService.addTransacao(t)
        return ResponseEntity.ok().build()
    }
}