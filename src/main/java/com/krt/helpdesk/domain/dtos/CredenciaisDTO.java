package com.krt.helpdesk.domain.dtos;

//Ele vai ser usado para fazer a conversão do usuario e senha que vem no login
public class CredenciaisDTO {
	
	private String email;
	private String senha;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	

}
