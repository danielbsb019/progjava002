package test;


import model.Pais;
import service.Services;

import org.junit.runners.MethodSorters;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class Teste {

	private Pais pais,copia;
	private Services service;
	static int id = 1;
	
	
	@BeforeEach
	public void setUp() throws Exception {
		System.out.println("Setup");
		pais = new Pais(id,"Brasil",8541800,57841.00);
		copia = new Pais(id,"Brasil",8541800,57841.00);
		service = new Services();
	}
	
	@Test
	public void Criar() {
		System.out.println("Criando");
		service.criar(pais);
		id = pais.getId();
		assertEquals(pais.getId(),copia.getId(),"Teste de criacao");
	}
	

	
	@Test
	public void Atualizar() {
		System.out.println("Atualizar");

		pais.setNome("Atualizado");
		copia.setNome("Atualizado");
		
		service.atualizarPais(pais, "Nome");
		service.carregar(id);
		
		assertEquals(pais.getNome(),copia.getNome(),"Teste Atualziar");
		
	}
	
	public void Carregar() {
		
		System.out.println("Teste Carregar");
		service.carregar(id);
		assertEquals(pais.getId(),copia.getId(),"Teste de criacao");
	}
	
	@Test
	public void Excluir() {
		System.out.println("Excluir Pais");
		service.excluir(pais);
		copia.setId(-1);
		
		service.carregar(id);
		assertEquals(pais.getId(),copia.getId(),"Teste de criacao");
	}

	@Test
	public void maiorPopulacao() {
		System.out.println("Maior populacao");
		service.maiorPopulacao(pais);
		
		long pop = pais.getPop();
		copia.setPop(pop);
		assertEquals(pais.getPop(),copia.getPop(),"Testando maior populacao");
	}
	
	@Test
	public void menorArea() {
		System.out.println("Menor Area");
		service.menorArea(pais);
		double area = pais.getArea();		
		copia.setArea(area);
		
		assertEquals(pais.getArea(),copia.getArea(),"Testando menor area");
	}
	
	@Test
	public void testevetor() {
		System.out.println("Vetor de paises");
		String[] array = service.getNomes();
		
		assertEquals(array.length,3,"Testando Vetor de paises");
	}
	
	
}