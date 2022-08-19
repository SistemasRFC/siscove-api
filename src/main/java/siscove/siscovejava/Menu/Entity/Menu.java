package siscove.siscovejava.Menu.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity (name = "SE_MENU")
public class Menu {
	
	@Id
	@Column(name="COD_MENU_W")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codMenuW;
	
	@Column(name="DSC_MENU_W")
	private String dscMenuW;
	
	@Column(name="NME_CONTROLLER")
	private String nmeController;
	
	@Column(name="IND_MENU_ATIVO_W")
	private String indMenuAtivoW;
	
	@Column(name="COD_MENU_PAI_W")
	private Integer codMenuPaiW;
	
	@Column(name="NME_METHOD")
	private String nmeMethod;

	@Column(name="DSC_CAMINHO_IMAGEM")
	private String dscCaminhoImagem;
	
	@Column(name="IND_ATALHO")
	private String indAtalho;
	
	


}
