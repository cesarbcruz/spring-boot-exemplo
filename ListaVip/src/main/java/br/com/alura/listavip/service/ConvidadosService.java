package br.com.alura.listavip.service;

import br.com.alura.gerenciador.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.repository.ConvidadoRepository;

@Service
public class ConvidadosService {
	
	@Autowired
	private ConvidadoRepository repository;
	
	public Iterable<Convidado> obterTodosConvidados() {
		return repository.findAll();
	}
	
	public void salvarConvidado(Convidado convidado) {
		repository.save(convidado);
	}
	
	public void enviarEmail(Convidado convidado) {
		new EmailService().enviar(convidado.getNome(), convidado.getEmail());
	}
}
