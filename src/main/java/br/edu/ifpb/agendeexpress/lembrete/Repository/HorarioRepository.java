package br.edu.ifpb.agendeexpress.lembrete.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.ifpb.agendeexpress.lembrete.Model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long>{

	@Query("SELECT h FROM Horario h "
			+ "WHERE DATE_PART('year', h.datahora) = :ano "
			+ "and DATE_PART('month', h.datahora) = :mes "
			+ "and DATE_PART('day', h.datahora) = :dia "
			+ "order by h.datahora")
	List<Horario> buscarHorarioPorDia(int ano,int mes,int dia);
}
