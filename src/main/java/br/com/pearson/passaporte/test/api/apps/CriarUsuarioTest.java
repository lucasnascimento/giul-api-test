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
	
	public static final String TOKEN = "0018eb71-f3f6-4272-a04a-fcd35b94780c";
	public static final String SECRET = "VgtiaG%2FvDDAije1%2FkbwPdYMmnaDEA9hvKWWh4cGENAPyj1B%2BNrD1nzSu0Y%2BpH%2FqL5Zw6YRdsZayUhtzjCRYu2QtTNi4rh8QgpPmziIaVXTY%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";
	
	public static final Long GRUPO_ECONOMICO_ID = 13L;
	public static final Long ESCOLA_ID = 16L;
	public static final Long ESTRUTURA_ID = 1175L;
	public static final Long PERFIL_ESCOLA_ID = 31L;

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste - 1", "brust.2", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(ESTRUTURA_ID, PERFIL_ESCOLA_ID, ESCOLA_ID);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("X-GRUPO-ECONOMICO", GRUPO_ECONOMICO_ID.toString());		
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken, headers);
		System.out.println(result);
	}
}