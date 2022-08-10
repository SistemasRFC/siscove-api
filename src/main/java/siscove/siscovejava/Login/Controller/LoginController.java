package siscove.siscovejava.Login.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import siscove.siscovejava.Config.response.BaseController;
import siscove.siscovejava.Config.response.EnvelopeResponse;
import siscove.siscovejava.Login.Dto.LoginDto;
import siscove.siscovejava.Login.Service.LoginService;


@RestController
@RequestMapping(value="/login")
public class LoginController extends BaseController{

	@Autowired
	private LoginService loginService;

	@RequestMapping(value="/validar", method = RequestMethod.POST, consumes = {"*/*"})
	public EnvelopeResponse<Boolean> validaLogin(@RequestBody LoginDto loginDto) {
		return loginService.validaLogin(loginDto);
	}

}