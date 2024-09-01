package com.portifolio.preco_commoditie.service;

import com.portifolio.preco_commoditie.dto.PrecoSacaDTO;
import com.portifolio.preco_commoditie.exception.WebScrapingException;
import com.portifolio.preco_commoditie.model.PrecoSaca;
import com.portifolio.preco_commoditie.model.PrecoSacaID;
import com.portifolio.preco_commoditie.repository.PrecoSacaRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

@Service
public class PrecoSacaService {

    private final PrecoSacaRepository precoSacaRepository;
    PrecoSaca precoSaca;

    public PrecoSacaService(PrecoSacaRepository precoSacaRepository) {
        this.precoSacaRepository = precoSacaRepository;
    }

    public PrecoSacaDTO obterPrecoSaca(String commoditie) {

        LocalDate date = LocalDate.now();
        precoSaca = precoSacaBD(date, commoditie);

        if (precoSaca == null) {
            String urlBase = String.format("https://www.cepea.esalq.usp.br/br/indicador/%s.aspx", commoditie);
            precoSaca = obterPrecoSacaWeb(urlBase, commoditie);
            precoSacaRepository.save(precoSaca);
        }

        return new PrecoSacaDTO(precoSaca.getCommoditie(),
                precoSaca.getData(),
                precoSaca.getValorR$(),
                precoSaca.getVariacaoDia(),
                precoSaca.getVariacaoMes(),
                precoSaca.getValorU$$());
    }

    private PrecoSaca obterPrecoSacaWeb(String urlBase, String commoditie) {
        try {
            Document doc = Jsoup.connect(urlBase).get();
            Element coffe_table_price = doc.select("table").get(0);
            Elements coffe_info_price = coffe_table_price.select("tr");

            precoSaca = PrecoSaca.builder().
                    commoditie(commoditie).
                    data(coffe_info_price.select("td").get(0).text()).
                    valorR$(NumberFormat.getInstance(Locale.GERMANY).parse(coffe_info_price.select("td").get(1).text()).doubleValue()).
                    variacaoDia(coffe_info_price.select("td").get(2).text()).
                    variacaoMes(coffe_info_price.select("td").get(3).text()).
                    valorU$$(NumberFormat.getInstance(Locale.FRENCH).parse(coffe_info_price.select("td").get(4).text()).doubleValue()).
                    dataLastCheckout(LocalDate.now().toString()).
                    build();
        } catch (Exception e) {
            throw new WebScrapingException("Erro ao obter preco da web");
        }
        return precoSaca;
    }

    private PrecoSaca precoSacaBD(LocalDate date, String commoditie) {
        PrecoSacaID precoSacaID = new PrecoSacaID(commoditie, date.toString());
        return precoSacaRepository.findById(precoSacaID).orElse(null);
    }


}
