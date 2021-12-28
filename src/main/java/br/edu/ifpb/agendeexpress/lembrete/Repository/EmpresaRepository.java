package br.edu.ifpb.agendeexpress.lembrete.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.agendeexpress.lembrete.Model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long>{

}
