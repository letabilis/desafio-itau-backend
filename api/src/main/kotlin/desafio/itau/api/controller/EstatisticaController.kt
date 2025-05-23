package desafio.itau.api.controller

import desafio.itau.api.dto.EstatisticaDTO
import desafio.itau.api.service.TransacaoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/estatistica")
class EstatisticaController (val transacaoService: TransacaoService){

    @GetMapping
    fun response(): ResponseEntity<EstatisticaDTO> {
        val estatistica = EstatisticaDTO(transacaoService.getEstatisticas())
        return ResponseEntity.ok(estatistica)
    }
}