package com.portifolio.preco_produto;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

@ContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient(timeout = "36000")
class PrecoProdutoApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void obterPrecoSacaSucesso() {
        webTestClient
                .get()
                .uri("/preco?produto=cafe")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("produto").isEqualTo("cafe");
    }

    @Test
    public void obterPrecoSacaFalhaSemPassarParametro() {
        webTestClient
                .get()
                .uri("/preco")
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void obterPrecoSacaFalhaPassarParametroIncorreto() {
        webTestClient
                .get()
                .uri("/preco?produto=testunitario")
                .exchange()
                .expectStatus().is5xxServerError();
    }


}
