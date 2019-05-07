package br.com.fatec.test;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.fatec.model.dao.RegionalDAO;
import br.com.fatec.model.dominio.Regional;


@RunWith(Suite.class)
@SuiteClasses({ TesteConexao.class })
public class GerenciarRegional implements IPersistencias {

	protected Regional regional;

	@After
	public void gerarRegional(){
		this.regional = new Regional("Sul");
	}
	
	@Test
	public void salvar() {
		new RegionalDAO().salvar(regional);;
	}

	@Test
	public void atualizar() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void excluir() {
		// TODO Auto-generated method stub
		
	}

	@Test
	public void consultar() {
		// TODO Auto-generated method stub
		
	}

}
