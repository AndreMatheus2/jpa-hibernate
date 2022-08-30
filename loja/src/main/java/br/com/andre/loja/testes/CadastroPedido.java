package br.com.andre.loja.testes;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.andre.loja.dao.CategoriaDao;
import br.com.andre.loja.dao.ClienteDao;
import br.com.andre.loja.dao.PedidoDao;
import br.com.andre.loja.dao.ProdutoDao;
import br.com.andre.loja.modelo.Categoria;
import br.com.andre.loja.modelo.Cliente;
import br.com.andre.loja.modelo.ItemPedido;
import br.com.andre.loja.modelo.Pedido;
import br.com.andre.loja.modelo.Produto;
import br.com.andre.loja.util.JpaUtil;

public class CadastroPedido {

	public static void main(String[] args) {
		popularBancoDeDados();
		EntityManager em = JpaUtil.getEntityManager();
		ProdutoDao produtoDao = new ProdutoDao(em);
		ClienteDao clienteDao = new ClienteDao(em);
		Produto produto = produtoDao.buscarPorId(1l);
		Cliente cliente = clienteDao.buscarPorId(1l);
		em.getTransaction().begin();
		
		Pedido pedido = new Pedido(cliente);
		pedido.adicionarItem(new ItemPedido(10, pedido, produto));
		
		PedidoDao pedidoDao = new PedidoDao(em);
		pedidoDao.cadastrar(pedido);
		
		em.getTransaction().commit();
		
	}	

	private static void popularBancoDeDados() {	
		Categoria celulares = new Categoria("CELULARES");

		Produto celular = new Produto("Xiaomi", "Verde", new BigDecimal("800"), celulares);
		Cliente cliente = new Cliente("Andre", "1234");


		EntityManager em = JpaUtil.getEntityManager();

		ProdutoDao produtoDao = new ProdutoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		ClienteDao clienteDao = new ClienteDao(em);

		em.getTransaction().begin();
		categoriaDao.cadastrar(celulares);
		produtoDao.cadastrar(celular);
		clienteDao.cadastrar(cliente);
		celulares.setNome("XPTO");
		em.flush();
		em.clear();

		celulares = em.merge(celulares);
		celulares.setNome("ALURA");
		em.flush();
	}

}
