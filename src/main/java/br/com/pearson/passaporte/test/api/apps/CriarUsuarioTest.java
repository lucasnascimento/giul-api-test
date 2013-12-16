package br.com.pearson.passaporte.test.api.apps;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.basic.TokenType;
import br.com.pearson.oauth.request.APICall;
import br.com.pearson.passaporte.test.api.dto.ClassificacaoDTO;
import br.com.pearson.passaporte.test.api.dto.UsuarioDTO;

public class CriarUsuarioTest {
	
	public static final String TOKEN = "e2141ea2-5278-4acc-8a5d-c90a00a4eaa7";
	public static final String SECRET = "SJFaVSpzJFca69lbmQ6KdaW3%2F94ATkLsmFZC25m41ZJ4NYUotLX7grRGnnzKn8EeoEj1Td7OcWbgW%2FCIkbAnO4xqqzcDHnWFZ7yJ4I2MFW0%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste", "brust3", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(878L, 52L, 17L);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		String grupoEconomico = "13";
		
		String resultAssume = apiCall.get("/session/" + grupoEconomico, null, consumer, accessToken);
		System.out.println(resultAssume);
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken);
		System.out.println(result);

	}

}
