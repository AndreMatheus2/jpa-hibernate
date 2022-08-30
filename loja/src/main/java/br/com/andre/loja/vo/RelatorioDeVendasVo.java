package br.com.andre.loja.vo;

import java.time.LocalDate;

public class RelatorioDeVendasVo {

	private String nomeProduto;
	private Long quantidadeVendida;
	private LocalDate dataUtilmaVenda;
	
	
	public RelatorioDeVendasVo(String nomeProduto, Long quantidadeVendida, LocalDate dataUtilmaVenda) {
		super();
		this.nomeProduto = nomeProduto;
		this.quantidadeVendida = quantidadeVendida;
		this.dataUtilmaVenda = dataUtilmaVenda;
	}


	public String getNomeProduto() {
		return nomeProduto;
	}


	public Long getQuantidadeVendida() {
		return quantidadeVendida;
	}


	public LocalDate getDataUtilmaVenda() {
		return dataUtilmaVenda;
	}


	@Override
	public String toString() {
		return "RelatorioDeVendasVo [nomeProduto=" + nomeProduto + ", quantidadeVendida=" + quantidadeVendida
				+ ", dataUtilmaVenda=" + dataUtilmaVenda + "]";
	}
	
	
	
}
