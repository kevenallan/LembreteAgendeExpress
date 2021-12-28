package br.edu.ifpb.agendeexpress.lembrete.Scheduled;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.edu.ifpb.agendeexpress.lembrete.Model.Horario;
import br.edu.ifpb.agendeexpress.lembrete.Repository.HorarioRepository;


@Component
public class Lembrete {

	private static final Logger log = LoggerFactory.getLogger(Lembrete.class);
	
	@Autowired
    private JavaMailSender emailSender;
	
	@Autowired
	private HorarioRepository horarioRepository;
	
//	@Scheduled(fixedRate = 10000)
	@Scheduled(cron = "0 0 7 * * *" )
	public void x() {
		LocalDate data = LocalDate.now();
		List<Horario> horarioLista = this.horarioRepository.buscarHorarioPorDia(data.getYear(), data.getMonthValue(), data.getDayOfMonth()+1);
		for (Horario horario : horarioLista) {
			System.out.println(horario);
			 try{
	            SimpleMailMessage message = new SimpleMailMessage();
	            message.setFrom("agendeexpressifpb@gmail.com");
	            message.setTo(horario.getCliente().getEmail());
	            message.setSubject("Agendamento");
	            message.setText("Horário marcado para o dia " + horario.getDatahora().getDayOfMonth() + "/" + horario.getDatahora().getMonthValue() + " às " + horario.getDatahora().getHour() + "h");
	            emailSender.send(message);
	        } catch (MailException e){

	        }
		}
		    
	}
	
}
