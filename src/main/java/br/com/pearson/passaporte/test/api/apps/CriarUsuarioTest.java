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
	
	public static final String TOKEN = "9c9dd1bb-0aa7-414e-acc1-cfc68cb1388d";
	public static final String SECRET = "DtCNKPBh4KEwd%2F1ZacrQDNVNxHeU57PMfFG0wEM3eOWcxx204Id4VxWaN7aSYhomgjyd814LGAVBPltlMJUERnVACXwufvcEDpSpPToE1m8%3D";
	public static final String BASE_URL = "http://homolog.passaporte.coc.com.br/giul/api";
	
	public static final Long GRUPO_ECONOMICO_ID = 2L;
	public static final Long ESCOLA_ID = 6L;
	public static final Long ESTRUTURA_ID = 1341L;
	public static final Long PERFIL_ESCOLA_ID = 28L;

	public static void main(String[] args) throws Exception {
		
		//Instanciando os dados necessário para o API Call
		APICall apiCall = new APICall(BASE_URL);
		OAuthConsumer consumer = new OAuthConsumer("key", "secret");
		OAuthToken accessToken = new OAuthToken(TOKEN, SECRET, TokenType.ACCESS);
		
		//Classe utilitária que será responsável pela conversão de JSON para objeto e vice-versa - API JACKSON
		ObjectMapper mapper = new ObjectMapper();
		
		//Setup do GRUPO ECONOMICO, necessário passar em todos os HEADER
		MultiValueMap<String, String> headers = new HttpHeaders();
		headers.add("X-GRUPO-ECONOMICO", GRUPO_ECONOMICO_ID.toString());		
		
		//Instânciando um novo usuário
		UsuarioDTO usuario = new UsuarioDTO("Lucas Nascimento", "lucas.nascimento123", "1234");
		ClassificacaoDTO classificacao = new ClassificacaoDTO(ESCOLA_ID, ESTRUTURA_ID, PERFIL_ESCOLA_ID);
		usuario.addClassificacao(classificacao);

		//Escrevendo o DTO como JSON
		String request = mapper.writeValueAsString(usuario);
		
		//Chamndo a API para inserir e guardando o resultado o JSON
		String result = apiCall.put("/usuario", request, null, consumer, accessToken, headers);
		
		//Convertendo o Resultado do JSON para o DTO
		UsuarioDTO usuarioInserido = mapper.readValue(result, UsuarioDTO.class);
		
		//Recuperando esse usuário que foi inserido através da API -ara exemplificar e já transformando no DTO
		UsuarioDTO usuarioInseridoFromAPI = mapper.readValue( apiCall.get("/usuario/"+ usuarioInserido.getId(), null, consumer, accessToken), UsuarioDTO.class);
		
		//Criando uma nova Classificiação
		ClassificacaoDTO classificacaoNova = new ClassificacaoDTO(ESCOLA_ID, ESTRUTURA_ID, PERFIL_ESCOLA_ID);
		
		//Adicionando no Usuário para posterior envio do usuário
		usuarioInseridoFromAPI.addClassificacao(classificacaoNova);
		
		String requestToUpdate = mapper.writeValueAsString(usuarioInseridoFromAPI);
		
		//Chamando a API para update
		String resultUpdate = apiCall.put("/usuario",requestToUpdate, null, consumer, accessToken, headers);

		UsuarioDTO usuarioAlterado = mapper.readValue( resultUpdate, UsuarioDTO.class);
		System.out.println(usuarioAlterado);
		
		//Chamando API para excluir o usuário que acabou de ser adicionado e alterado.
		String resultDelete = apiCall.delete("/usuario"+usuarioAlterado.getId(), resultUpdate, null, consumer, accessToken, headers);
		System.out.println(resultDelete);
		

	}
}