package br.com.andre.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.andre.loja.dao.ProdutoDao;
import br.com.andre.loja.modelo.Categoria;
import br.com.andre.loja.modelo.Produto;
import br.com.andre.loja.util.JpaUtil;

public class CadastroProdutos {

	public static void main(String[] args) {
		
		Produto celular = new Produto("Xiaomi", "Verde", new BigDecimal("800"), Categoria.CELULARES);
		
		
		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao dao = new ProdutoDao(em);
		
		em.getTransaction().begin();
		dao.cadastrar(celular);
		em.getTransaction().commit();
		em.close();
	}

}
