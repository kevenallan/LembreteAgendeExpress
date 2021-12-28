package br.edu.ifpb.agendeexpress.lembrete.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "O nome do cliente não pode ser nulo")
	private String nome;

	@Column(unique = true)
	@NotBlank(message = "O email do cliente não pode ser nulo")
	@Email
	private String email;
	
	@Column(unique = true)
	@NotBlank(message = "O usuario não pode ser nulo")
	private String usuario;
	
	@NotBlank(message = "A senha não pode ser nula")
	private String senha;
	
	@Column(length = 11)
	private String telefone;

}