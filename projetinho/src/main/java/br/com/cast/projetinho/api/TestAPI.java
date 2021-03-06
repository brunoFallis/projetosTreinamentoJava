package br.com.cast.projetinho.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.cast.projetinho.business.BusinessPessoa;
import br.com.cast.projetinho.dto.PessoaDTO;


@RestController
@RequestMapping(path="/test")
public class TestAPI {
	
	@Autowired
	private BusinessPessoa bp;
	
	@RequestMapping(path="", method=RequestMethod.GET)
	public List<PessoaDTO> buscarTodos() {
		return bp.buscaTodos();
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.GET)
	public String buscaPorCpf(@PathVariable("cpf") String cpf) {
		return "buscando por id " + cpf;
	}
	
/*	@RequestMapping(path="/{cpf}/{nome}", method=RequestMethod.GET)
	public String buscaPorCpfENome(@PathVariable("cpf") String cpf, 
								   @PathVariable("nome") String nome) {
		return "buscando por id " + cpf + ", - " + nome;
	}*/
	
	@RequestMapping(path="", method=RequestMethod.POST)
	public void inserir(@RequestBody PessoaDTO dto) {
		bp.inserir(dto);
	}
	
	@RequestMapping(path="/{cpf}", method=RequestMethod.DELETE)
	public void delete(@PathVariable("cpf") String cpf) {
		bp.delete(cpf);
	}
	
	@RequestMapping(path="", method=RequestMethod.PUT)
	public void alterar(@RequestBody PessoaDTO dto) {
		bp.alterar(dto);
	}
	
}
