package br.com.projedata.arcturus.teste.testes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesteMetodos {
	
	public String retornarHoraAtual() {
		DateFormat dateFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public void main(String[] args) {
		System.out.println(retornarHoraAtual());

	}

}
