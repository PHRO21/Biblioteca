package br.com.gep.biblioteca.config.handler;

public class ErroValidacaoOutput {
	
	private String campo;
	private String erro;
	
	public ErroValidacaoOutput(String campo, String erro) {
		this.campo = campo;
		this.erro = erro;
	}

	public ErroValidacaoOutput() {
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
	
}
