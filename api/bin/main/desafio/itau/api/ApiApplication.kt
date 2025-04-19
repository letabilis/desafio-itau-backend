package desafio.itau.api

import desafio.itau.api.dto.TransacaoDTO
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.concurrent.BlockingQueue
import java.util.concurrent.LinkedBlockingQueue

@SpringBootApplication
class ApiApplication{
	@Bean
	fun blockingQueue(): BlockingQueue<TransacaoDTO> {
		return LinkedBlockingQueue()
	}

}
fun main(args: Array<String>) {
	runApplication<ApiApplication>(*args)
}
