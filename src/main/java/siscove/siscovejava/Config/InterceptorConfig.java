package siscove.siscovejava.Config;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;
import siscove.siscovejava.Token.Dto.TokenDto;
import siscove.siscovejava.Token.Service.TokenService;

@Slf4j
@Component
public class InterceptorConfig implements HandlerInterceptor{

	@Autowired
	private TokenService tokenService;
	
	private final static Integer TEMPO_LIMITE = 1500000;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	tokenService.excluiTokensInvalidos(TEMPO_LIMITE);
    	log.info("Authorization: "+request.getHeader("Authorization"));
    	HttpSession session = request.getSession();
    	String txtToken = request.getHeader("Authorization");
    	if (null!=txtToken && (!"null".equals(txtToken))) {
	    	if (request.getHeader("Authorization").equals("getToken")) {
	    		return true;
	    	}else {
		    	TokenDto tokenDto = tokenService.getByToken(txtToken).getObjeto();
		    	if (null==tokenDto) {
			        response.setContentType("application/json; charset=UTF-8");
			        response.getWriter().write("{ \"objeto\": null, \"retorno\": false, \"mensagem\": \"usuário não logado no sistema!\"}");
			        response.setStatus(HttpServletResponse.SC_OK);
		    		return false;
		    	}else {
			    	long diferenca = ChronoUnit.MINUTES.between(tokenDto.getDtaToken(), LocalDateTime.now());
			 
			    	if (diferenca>TEMPO_LIMITE) {
			    		tokenService.excluiTokenByTxtToken(txtToken);
				        response.setContentType("application/json; charset=UTF-8");
				        response.getWriter().write("{ \"objeto\": null, \"retorno\": false, \"mensagem\": \"usuário não logado no sistema!\"}");
				        response.setStatus(HttpServletResponse.SC_OK);
				        return false;
			    	}else {
			    		session.setAttribute("token", txtToken);
			    		tokenDto.setDtaToken(LocalDateTime.now());
			    		tokenService.salvar(tokenDto);
			    	}
		    	}
	    	}
    	}else {
	        response.setContentType("application/json; charset=UTF-8");
	        response.getWriter().write("{ \"objeto\": null, \"retorno\": false, \"mensagem\": \"Token não enviado!\"}");
	        response.setStatus(HttpServletResponse.SC_OK);
    		return true;   		
    	}
        return true;
    }


}