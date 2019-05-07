package br.com.fatec.app;

import br.com.fatec.model.dao.RegionalDAO;
import br.com.fatec.model.dominio.Regional;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Regional regional = new Regional("Sudeste");
		new RegionalDAO().salvar(regional);
	}

}
