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

	public EnvelopeResponse<List<ClienteDto>> getListaClienteAtivos() {
		List<Cliente> listaCliente = (List<Cliente>) clienteDao.findAll();

		List<ClienteDto> listaClienteDto = new ArrayList<ClienteDto>();
		for (Cliente cliente : listaCliente) {
			listaClienteDto.add(ClienteDto.build(cliente));

		}
		return new EnvelopeResponse<List<ClienteDto>>(listaClienteDto);
	}

	public EnvelopeResponse<List<ClienteDto>> getListaCliente() {
		List<Cliente> listaCliente = (List<Cliente>) clienteDao.findAll();

		List<ClienteDto> listaClienteDto = new ArrayList<ClienteDto>();
		for (Cliente cliente : listaCliente) {
			listaClienteDto.add(ClienteDto.build(cliente));
		}
		return new EnvelopeResponse<List<ClienteDto>>(listaClienteDto);

	}

	public EnvelopeResponse<ClienteDto> salvar(ClienteDto clienteDto) {
		Cliente cliente = clienteDao.save(ClienteDto.parse(clienteDto));

		clienteDto = ClienteDto.build(cliente);

		return new EnvelopeResponse<ClienteDto>(clienteDto);
	}

}