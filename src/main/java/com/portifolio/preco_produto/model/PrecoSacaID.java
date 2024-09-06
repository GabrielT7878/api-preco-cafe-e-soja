package com.portifolio.preco_produto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PrecoSacaID implements Serializable {

    private String produto;
    private String dataLastCheckout;

}
