package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface ServicoRepository extends JpaRepository<Servico, Long> {

    @Transactional
    @Query(value = "INSERT INTO servico (desc_servico, custo, data_inicio, id_manutencao) " +
            "VALUES (:descServico, 0, :dataInicio, :idManutencao)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirServico(@Param("descServico") String descServico,
                           @Param("dataInicio") Date dataInicio,
                           @Param("idManutencao") Integer idManutencao);
}
