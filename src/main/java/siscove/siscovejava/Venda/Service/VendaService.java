package siscove.siscovejava.Venda.Service;

import java.util.Optional;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Usuario.Entity.Usuario;
import siscove.siscovejava.Venda.Dto.VendaDto;
import siscove.siscovejava.Venda.Entity.Venda;

public class VendaService {

	public EnvelopeResponse<VendaDto> salvar(VendaDto vendaDto) {
		Venda venda = VendaDto.parse(vendaDto);
		
		if (vendaDto.getCodVenda() != null) {
			Optional<Venda> usuarioSenha = vendaDao.findById(vendaDto.getCodVenda());
			venda.setTxtSenhaW(usuarioSenha.get().getTxtSenhaW());
		}

		return null;
	}

}
