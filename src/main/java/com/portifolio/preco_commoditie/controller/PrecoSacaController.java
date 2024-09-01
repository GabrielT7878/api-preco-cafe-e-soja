package com.portifolio.preco_commoditie.controller;

import com.portifolio.preco_commoditie.dto.PrecoSacaDTO;
import com.portifolio.preco_commoditie.service.PrecoSacaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/preco")
public class PrecoSacaController {
    private final PrecoSacaService precoSacaService;

    public  PrecoSacaController(PrecoSacaService precoSacaService) {
        this.precoSacaService = precoSacaService;
    }

    @GetMapping()
    public ResponseEntity<PrecoSacaDTO> obterPrecoSaca(@RequestParam String commoditie){
        PrecoSacaDTO precoSacaDTO = precoSacaService.obterPrecoSaca(commoditie);
        return ResponseEntity.ok().body(precoSacaDTO);
    }


}
