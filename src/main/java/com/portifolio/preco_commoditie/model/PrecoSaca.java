package com.portifolio.preco_commoditie.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class PrecoSaca {
    @Id
    private String dataLastCheckout;
    private String commoditie;
    private String data;
    private double valorR$;
    private String variacaoDia;
    private String variacaoMes;
    private double valorU$$;
}
