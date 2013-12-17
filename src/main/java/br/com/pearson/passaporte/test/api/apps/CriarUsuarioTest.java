package br.com.pearson.passaporte.test.api.apps;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.pearson.oauth.basic.OAuthConsumer;
import br.com.pearson.oauth.basic.OAuthToken;
import br.com.pearson.oauth.basic.TokenType;
import br.com.pearson.oauth.request.APICall;
import br.com.pearson.passaporte.test.api.dto.ClassificacaoDTO;
import br.com.pearson.passaporte.test.api.dto.UsuarioDTO;

public class CriarUsuarioTest {
	
	public static final String TOKEN = "1c34b515-e3da-44bf-8594-d512db95b2f0";
	public static final String SECRET = "RgAU2d3OeaaRWmqsW2udY%2Bf%2FBrOZmz9DSy9z5%2FOm3qJ4VhTJNODogVprA1t2ocSVShSkZlNK2VlHxs8lmZT%2B0qIZJjqOBdYrGQhUQuvnfBQ%3D";
	public static final String BASE_URL = "http://coc.dclick.com.br/giul/api";

	public static void main(String[] args) throws Exception {
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		ObjectMapper mapper = new ObjectMapper();
		
		UsuarioDTO usuario = new UsuarioDTO("Saulo Brust - Teste", "brust3", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(1125L, 53L, 17L);
		usuario.addClassificacao(classificacao);
		String request = mapper.writeValueAsString(usuario);
		String grupoEconomico = "13";
		
		String resultAssume = apiCall.get("/session/" + grupoEconomico, null, consumer, accessToken);
		System.out.println(resultAssume);
		
		String result = apiCall.put("/usuario", request, null, consumer, accessToken);
		System.out.println(result);
	}

}
