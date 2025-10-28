package org.example.frotavivapostgreapi.repository;

import io.lettuce.core.dynamic.annotation.Param;
import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Manutencao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface ManutencaoRepository extends JpaRepository<Manutencao, Long> {

    @Query(value = "SELECT * FROM manutencao WHERE id_caminhao = :id_caminhao", nativeQuery = true)
    List<Manutencao> findByIdCaminhao(@PathVariable("id_caminhao") Integer id_caminhao);

    @Transactional
    @Query(value = "INSERT INTO manutencao (status,id_caminhao, info, titulo) " +
            "VALUES ('PENDENTE', :idCaminhao, :info, :titulo)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirManutencao(@Param("idCaminhao") Integer idCaminhao,
                           @Param("info") String info,
                           @Param("titulo") String titulo);

    @Modifying
    @Transactional
    @Query(value = "UPDATE manutencao SET status = 'CONCLUIDO' WHERE id = :id_manutencao",
            nativeQuery = true)
    void finalizarManutencao(@PathVariable("id_manutencao") Integer id_manutencao);

    @Modifying
    @Transactional
    @Query(value = "UPDATE manutencao SET status = 'SERVICO;' WHERE id = :id_manutencao",
            nativeQuery = true)
    void solicitarServico(@PathVariable("id_manutencao") Integer id_manutencao);
}
