package br.edu.ifpb.agendeexpress.lembrete.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifpb.agendeexpress.lembrete.Model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
