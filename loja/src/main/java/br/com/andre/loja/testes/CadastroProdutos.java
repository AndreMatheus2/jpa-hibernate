package br.com.andre.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.andre.loja.dao.CategoriaDao;
import br.com.andre.loja.dao.ProdutoDao;
import br.com.andre.loja.modelo.Categoria;
import br.com.andre.loja.modelo.Produto;
import br.com.andre.loja.util.JpaUtil;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		Categoria celulares = new Categoria("CELULARES");
		
		Produto celular = new Produto("Xiaomi", "Verde", new BigDecimal("800"), celulares);
		
		
		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);

		
		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		celulares.setNome("XPTO");
		em.flush();
		em.clear();
		
		celulares = em.merge(celulares);
		celulares.setNome("ALURA");
		em.flush();
	}

}
