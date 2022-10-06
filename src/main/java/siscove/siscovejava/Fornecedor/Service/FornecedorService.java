package siscove.siscovejava.Fornecedor.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Fornecedor.Dto.FornecedorDto;
import siscove.siscovejava.Fornecedor.Entity.Fornecedor;
import siscove.siscovejava.Fornecedor.Repository.FornecedorDao;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorDao fornecedorDao;

	public EnvelopeResponse<List<FornecedorDto>> getListarFornecedor() {
		List<Fornecedor> listarFornecedor = (List<Fornecedor>) fornecedorDao.findAll();

		List<FornecedorDto> listarFornecedorDto = new ArrayList<FornecedorDto>();
		for (Fornecedor fornecedor : listarFornecedor) {

				listarFornecedorDto.add(FornecedorDto.build(fornecedor));
			
		}
		return new EnvelopeResponse<List<FornecedorDto>>(listarFornecedorDto);
	}

	public EnvelopeResponse<List<FornecedorDto>> getListarAtivos() {
		List<Fornecedor> listarAtivos = (List<Fornecedor>) fornecedorDao.findAll();

		List<FornecedorDto> listarAtivosDto = new ArrayList<FornecedorDto>();
		for (Fornecedor fornecedor : listarAtivos) {
			if (fornecedor.getIndAtivo().equals("S"))
				listarAtivosDto.add(FornecedorDto.build(fornecedor));
		}
		return new EnvelopeResponse<List<FornecedorDto>>(listarAtivosDto);
	}

	public EnvelopeResponse<FornecedorDto> salvar(FornecedorDto fornecedorDto) {
		Fornecedor fornecedor = fornecedorDao.save(FornecedorDto.parse(fornecedorDto));

		fornecedorDto = FornecedorDto.build(fornecedor);

		return new EnvelopeResponse<FornecedorDto>(fornecedorDto);
	}

}