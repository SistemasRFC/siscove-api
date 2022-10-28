package siscove.siscovejava.Veiculo.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Veiculo.Dto.VeiculoDto;
import siscove.siscovejava.Veiculo.Entity.Veiculo;
import siscove.siscovejava.Veiculo.Repository.VeiculoDao;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoDao veiculoDao;
	
	public EnvelopeResponse<List<VeiculoDto>> getListarVeiculo(String dscVeiculo) {
		List<Veiculo> listarVeiculo = (List<Veiculo>) veiculoDao.findBydscVeiculo(dscVeiculo);

		List<VeiculoDto> listarVeiculoDto = new ArrayList<VeiculoDto>();
		for (Veiculo veiculo : listarVeiculo) {
			VeiculoDto veiculoDto = VeiculoDto.build(veiculo);
			listarVeiculoDto.add(veiculoDto);
		}
		
		return new EnvelopeResponse<List<VeiculoDto>>(listarVeiculoDto);
	}
}
