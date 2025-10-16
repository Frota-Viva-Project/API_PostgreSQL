package org.example.frotavivapostgreapi.repository;

import jakarta.transaction.Transactional;
import org.example.frotavivapostgreapi.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query(value = "SELECT * FROM empresa WHERE id = :id", nativeQuery = true)
    Empresa findById(@Param("id") Integer id);


    @Transactional
    @Query(value = "INSERT INTO empresa (nome, cnpj, tamanhoEmpresa, tamanhoFrota, tipoEmpresa, areaAtuacao, razaoSocial, cnae, telefone, endereco, cod_empresa) " +
            "VALUES (:nome, :cnpj, :tamanhoEmpresa, :tamanhoFrota, :tipoEmpresa, :areaAtuacao, :razaoSocial, :cnae, :telefone, :endereco, :cod_empresa)"+
            "RETURNING id",
            nativeQuery = true)
    Integer inserirEmpresa(@Param("nome") String nome,
                         @Param("cnpj") String cnpj,
                         @Param("tamanhoEmpresa") Integer tamanhoEmpresa,
                         @Param("tamanhoFrota") Integer tamanhoFrota,
                         @Param("tipoEmpresa") String tipoEmpresa,
                         @Param("areaAtuacao") String areaAtuacao,
                         @Param("razaoSocial") String razaoSocial,
                         @Param("cnae") String cnae,
                         @Param("telefone") String telefone,
                         @Param("endereco") String endereco,
                         @Param("cod_empresa") String cod_empresa);

    @Query(value = "SELECT * FROM empresa WHERE cod_empresa = :cod_empresa", nativeQuery = true)
    Empresa findByCodEmpresa(@Param("cod_empresa") String cod_empresa);
}
