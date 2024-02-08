package com.michelsonroncete.certification_java;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiroController")
public class PrimeiroController {

	@GetMapping("/retornarPrimeiroController")
	public Usuario retornoPrimeiroController() {
		var usuario = new Usuario("Michel", 35);
		return usuario;
	}
	
	@PostMapping("/primeiroPost")
	public String post1() {
		return "Primeiro Post";
	}
	
	record Usuario(String nome, int idade) {}
}
