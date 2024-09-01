package com.portifolio.preco_commoditie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@IdClass(PrecoSacaID.class)
public class PrecoSaca {
    @Id
    private String commoditie;
    @Id
    private String dataLastCheckout;
    private String data;
    private double valorR$;
    private String variacaoDia;
    private String variacaoMes;
    private double valorU$$;
}



