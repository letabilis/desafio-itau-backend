package desafio.itau.api.dto

import jakarta.validation.constraints.Min
import jakarta.validation.constraints.NotNull
import java.time.OffsetDateTime

// O que a API pode saber do modelo?
// Aplicar alguns constraints

class TransacaoDTO(@NotNull @Min(0) val valor: Double, @NotNull  val dataHora: OffsetDateTime)