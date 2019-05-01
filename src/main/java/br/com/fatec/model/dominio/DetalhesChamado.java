package br.com.fatec.model.dominio;

public class DetalhesChamado {
	private byte[] imagem;
	private TipoImagem tipoImagem;
	
	public DetalhesChamado() {
		super();
	}

	public DetalhesChamado(byte[] imagem, TipoImagem tipoImagem) {
		super();
		this.imagem = imagem;
		this.tipoImagem = tipoImagem;
	}

	public TipoImagem getTipoImagem() {
		return tipoImagem;
	}

	public void setTipoImagem(TipoImagem tipoImagem) {
		this.tipoImagem = tipoImagem;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}	
	
}
