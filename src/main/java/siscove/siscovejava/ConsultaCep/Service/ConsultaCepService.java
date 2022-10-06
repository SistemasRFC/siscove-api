package siscove.siscovejava.ConsultaCep.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.ConsultaCep.Dto.ConsultaCepDto;

@Service
public class ConsultaCepService {

	@Autowired
	private RestTemplate restTemplate;

	public EnvelopeResponse<ConsultaCepDto> getEndereco(String nroCep){
		String url = "http://viacep.com.br/ws/"+nroCep+"/json/";
		
		HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<ConsultaCepDto> response = restTemplate.exchange(url, HttpMethod.GET, entity, ConsultaCepDto.class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return new EnvelopeResponse<ConsultaCepDto>(response.getBody());
        }
        return new EnvelopeResponse<ConsultaCepDto>(null, false, "Erro ao consultar o cep");
	}
}
