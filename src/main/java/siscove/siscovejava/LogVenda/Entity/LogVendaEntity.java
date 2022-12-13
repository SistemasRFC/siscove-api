 package siscove.siscovejava.LogVenda.Entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

	
	@NoArgsConstructor
	@Data
	@Entity(name = "EN_LOG_VENDA")
	public class LogVendaEntity {

		@Id
		@Column(name = "COD_OPERACAO")
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer codOperacao;
		
		@Column(name = "COD_VENDA")
		private Integer codVenda;
		
		@Column(name = "COD_USUARIO")
		private Integer codUsuario;
		
		@Column(name = "DTA_OPERACAO")
		private LocalDateTime dtaOperacao;
		
		@Column(name = "TIPO_OPERACAO")
		private String tipoOperacao;
	}

