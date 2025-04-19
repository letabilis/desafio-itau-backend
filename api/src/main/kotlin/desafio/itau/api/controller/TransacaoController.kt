package desafio.itau.api.controller

import desafio.itau.api.dto.TransacaoDTO
import desafio.itau.api.service.TransacaoService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.OffsetDateTime


@RestController
@RequestMapping("/transacao")
class TransacaoController (val transacaoService: TransacaoService){

    @PostMapping
    fun request(@Valid @RequestBody  t: TransacaoDTO): ResponseEntity<Void> {
        val agora = OffsetDateTime.now()
        if (t.dataHora.isAfter(agora) || t.valor < 0) {
            return ResponseEntity.unprocessableEntity().build()
        }
        this.transacaoService.addTransacao(t)
        return ResponseEntity.status(201).build()
    }
}