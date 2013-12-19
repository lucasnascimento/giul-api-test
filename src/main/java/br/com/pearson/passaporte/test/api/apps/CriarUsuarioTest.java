package br.com.pearson.passaporte.test.api.apps;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.util.MultiValueMap;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.basic.TokenType;
import br.com.pearson.oauth.request.APICall;
import br.com.pearson.passaporte.test.api.dto.ClassificacaoDTO;
import br.com.pearson.passaporte.test.api.dto.UsuarioDTO;

public class CriarUsuarioTest {
	
	public static final String TOKEN = "e979114d-feeb-4b20-9452-cea17ad9e880";
	public static final String SECRET = "6ojW1Qugt57ygxHQXYSGgVXMjw%2Bum9CxEIvy0Ie69CRMsdssfhTGiQ1PsUOAYyFHA%2BWz4opFowkwfE70tnuqgu79cFAJpQQmT976PAOtOSQ%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";
	
	public static final Long GRUPO_ECONOMICO_ID = 2L;
	public static final Long ESCOLA_ID = 3L;
	public static final Long ESTRUTURA_ID = 11L;
	public static final Long PERFIL_ESCOLA_ID = 1L;

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste - 1", "brust.2", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(ESTRUTURA_ID, PERFIL_ESCOLA_ID, ESTRUTURA_ID);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("X-GRUPO-ECONOMICO", GRUPO_ECONOMICO_ID.toString());		
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken, headers);
		System.out.println(result);
	}
}