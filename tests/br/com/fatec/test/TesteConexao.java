package br.com.fatec.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fatec.model.factory.FabricaConexao;

@RunWith(Suite.class)
@SuiteClasses({})
public class TesteConexao{
	@Test
	public void validaConexao() {
		FabricaConexao.getConexao();
	}
}
