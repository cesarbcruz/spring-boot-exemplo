package br.com.alura.listavip;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.alura.enviadorEmail.enviadorEmail.EmailService;
import br.com.alura.listavip.model.Convidado;
import br.com.alura.listavip.service.ConvidadosService;

@Controller
public class ConvidadoController {
	
	@Autowired
	private ConvidadosService service;
	
	@RequestMapping("/")
	public String index(){
		return "index";
	}
	
	@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){
		return retornarListaConvidados(model);
	}
	
	@RequestMapping(value="salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("nome") String nome, @RequestParam("email") String email, 
			@RequestParam("telefone") String telefone, Model model) {
		
		Convidado convidado = new Convidado(nome, email, telefone);
		service.salvarConvidado(convidado);
		service.enviarEmail(convidado);
		
		return retornarListaConvidados(model);
	}
	
	private String retornarListaConvidados(Model model) {
		model.addAttribute("convidados", service.obterTodosConvidados());		
		return "listaconvidados";
	}
	
	

}
