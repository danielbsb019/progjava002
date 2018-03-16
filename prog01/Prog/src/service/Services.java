package service;

import dao.PaisDAO;
import model.Pais;

public class Services {
	PaisDAO dao;

	public Services() {
		dao = new PaisDAO();

	}

	public void criar(Pais pais) {
		dao.incluir(pais);

	}

	public void atualizarPais(Pais pais, String NovoPais) {
		dao.atualizarPais(pais, NovoPais);
	}

	public void excluir(Pais pais) {
		dao.excluir(pais);

	}

	public void carregar(Pais pais) {
		dao.carregar(pais);

	}

	public void maiorPopulacao(Pais pais) {
		dao.maiorPopulacao(pais);

	}

	public void menorArea(Pais pais) {
		dao.menorArea(pais);
	}

	public String[] getNomes() {
		String[] lista = dao.nomes();
		return lista;
	}

}
