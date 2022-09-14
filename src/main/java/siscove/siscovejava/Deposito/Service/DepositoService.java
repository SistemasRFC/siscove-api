package siscove.siscovejava.Deposito.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.ClienteFinal.Dto.ClienteFinalDto;
import siscove.siscovejava.ClienteFinal.Service.ClienteFinalService;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Deposito.Dto.DepositoDto;
import siscove.siscovejava.Deposito.Entity.Deposito;
import siscove.siscovejava.Deposito.Repository.DepositoDao;

@Service
public class DepositoService {

	@Autowired
	private DepositoDao depositoDao;

	@Autowired
	private ClienteFinalService clienteFinalService;

	public EnvelopeResponse<List<DepositoDto>> getListaDepositoAtivos() {
		List<Deposito> listaDeposito = (List<Deposito>) depositoDao.findAll();

		List<DepositoDto> listaDepositoDto = new ArrayList<DepositoDto>();
		for (Deposito deposito : listaDeposito) {
			if (null != deposito.getIndAtivo() && deposito.getIndAtivo().equals("S")) {
				listaDepositoDto.add(DepositoDto.build(deposito));
			}
		}
		return new EnvelopeResponse<List<DepositoDto>>(listaDepositoDto);
	}

	public EnvelopeResponse<List<DepositoDto>> getListaDeposito() {
		List<Deposito> listaDeposito = (List<Deposito>) depositoDao.findAll();

		List<DepositoDto> listaDepositoDto = new ArrayList<DepositoDto>();
		for (Deposito deposito : listaDeposito) {
			DepositoDto dto = DepositoDto.build(deposito);

			if(null != deposito.getCodClienteFinal()) {
				ClienteFinalDto clienteFinalDto = clienteFinalService.findByCodClienteFinal(deposito.getCodClienteFinal())
					.getObjeto();
				dto.setDscClienteFinal(clienteFinalDto.getNmeClienteFinal());				
			}

			listaDepositoDto.add(dto);
		}
		return new EnvelopeResponse<List<DepositoDto>>(listaDepositoDto);

	}

	public EnvelopeResponse<DepositoDto> salvar(DepositoDto depositoDto) {
		Deposito deposito = depositoDao.save(DepositoDto.parse(depositoDto));

		depositoDto = DepositoDto.build(deposito);

		return new EnvelopeResponse<DepositoDto>(depositoDto);
	}
}
