package br.com.andre.loja.dao;

import javax.persistence.EntityManager;

import br.com.andre.loja.modelo.Categoria;

public class CategoriaDao {

	private EntityManager em;

	public CategoriaDao(EntityManager em) {
		super();
		this.em = em;
	}
	
	public void cadastrar(Categoria categoria) {
		this.em.persist(categoria);
	}
	
}
