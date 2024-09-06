package com.portifolio.preco_produto.repository;

import com.portifolio.preco_produto.model.PrecoSaca;
import com.portifolio.preco_produto.model.PrecoSacaID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrecoSacaRepository extends JpaRepository<PrecoSaca, PrecoSacaID> {

}
