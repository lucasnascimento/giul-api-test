package br.com.pearson.passaporte.test.api.apps;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.basic.TokenType;
import br.com.pearson.oauth.request.APICall;
import br.com.pearson.passaporte.test.api.dto.ClassificacaoDTO;
import br.com.pearson.passaporte.test.api.dto.UsuarioDTO;

public class CriarUsuarioTest {
	
	public static final String TOKEN = "666e7ddf-fc3a-461b-8026-d3965ed72112";
	public static final String SECRET = "c7iCIsmKosyNCjeoFEyWLYQDMK7nUc25IuTtUOQEbjLTE8oR93%2BfDuOTUDNDiWO%2FkVHLa46REu72F28s340HZqpT4EXxyoe9vPq8fgOanjs%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste - 1", "brust.1", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(455L, 33L, 4L);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		String grupoEconomico = "2";
		
		String resultAssume = apiCall.get("/session/" + grupoEconomico, null, consumer, accessToken);
		System.out.println(resultAssume);
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken);
		System.out.println(result);
	}

}
