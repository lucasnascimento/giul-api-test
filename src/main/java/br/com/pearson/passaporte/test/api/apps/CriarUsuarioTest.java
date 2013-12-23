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
	
	public static final String TOKEN = "aa7088cf-f46e-47d2-83e0-f44a8b14436e";
	public static final String SECRET = "%2Bcp3B%2B18i8WpqqGL%2FCygPk3a5wWhYXDpyjTJsEglzPj%2BINHCAKJalPN45nkWda4tIAGMzpFa60DyFx72X0fmd%2FiQrd5JLKDRyY3LmTqSsKI%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";
	
	public static final Long GRUPO_ECONOMICO_ID = 1L;
	public static final Long ESCOLA_ID = 1L;
	public static final Long ESTRUTURA_ID = 17L;
	public static final Long PERFIL_ESCOLA_ID = 1L;

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste - 1", "brust.20", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(ESCOLA_ID, ESTRUTURA_ID, PERFIL_ESCOLA_ID);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("X-GRUPO-ECONOMICO", GRUPO_ECONOMICO_ID.toString());		
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken, headers);
		System.out.println(result);
	}
}