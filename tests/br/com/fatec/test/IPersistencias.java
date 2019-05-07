package br.com.fatec.test;

import org.junit.Test;

public interface IPersistencias {
	
	@Test
	public void salvar();
	@Test
	public void atualizar();
	@Test
	public void excluir();
	@Test
	public void consultar();
}
