package siscove.siscovejava.Cliente.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import siscove.siscovejava.Cliente.Dto.ClienteDto;
import siscove.siscovejava.Cliente.Entity.Cliente;
import siscove.siscovejava.Cliente.Repository.ClienteDao;
import siscove.siscovejava.Config.response.EnvelopeResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteDao clienteDao;

	public EnvelopeResponse<List<ClienteDto>> getListarClientes(String txtTermo) {
		List<Cliente> listarClientes = (List<Cliente>) clienteDao.findBydscCliente(txtTermo);

		List<ClienteDto> listarClientesDto = new ArrayList<ClienteDto>();
		for (Cliente cliente : listarClientes) {
			ClienteDto clienteDto = ClienteDto.build(cliente);
			listarClientesDto.add(clienteDto);
		}
		
		return new EnvelopeResponse<List<ClienteDto>>(listarClientesDto);
	}

	public EnvelopeResponse<ClienteDto> salvar(ClienteDto clienteDto) {
		Cliente cliente = clienteDao.save(ClienteDto.parse(clienteDto));

		clienteDto = ClienteDto.build(cliente);

		return new EnvelopeResponse<ClienteDto>(clienteDto);
	}

}