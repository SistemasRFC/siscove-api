package siscove.siscovejava.Config.response;

public class EnvelopeResponse<T> {

	private String mensagem;
	private boolean retorno;
	private T objeto;
	
	public EnvelopeResponse(T objetoParam){
		this.objeto = objetoParam;
		this.retorno = true;
		this.mensagem = "";
	}

	public EnvelopeResponse(T objetoParam, boolean ret, String msg){
		this.objeto = objetoParam;
		this.retorno = ret;
		this.mensagem = msg;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public boolean isRetorno() {
		return retorno;
	}
	public void setRetorno(boolean retorno) {
		this.retorno = retorno;
	}
	public T getObjeto() {
		return objeto;
	}
	public void setObjeto(T objeto) {
		this.objeto = objeto;
	}
}
