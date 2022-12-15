package siscove.siscovejava.Venda.Enum;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum TipoOperacaoEnum {

	INCLUSAO("I", "Inclusão"),
	ALTERACAO("A", "Alteração");
	
	private String tpoOperacao;
	private String dscOperacao;
	
	TipoOperacaoEnum(String tpoOperacao, String dscOperacao) {
		this.tpoOperacao = tpoOperacao;
		this.dscOperacao = dscOperacao;
	}
	
	public String getTpoOperacao() {
		return this.tpoOperacao;
	}
	
	public String getDscOperacao() {
		return this.dscOperacao;
	}
}
