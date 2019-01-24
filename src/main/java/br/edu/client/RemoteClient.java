package br.edu.client;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteClient {
	
	private static final String GET_INDICE_URL = "https://us-central1-fernando-machado.cloudfunctions.net/indice-validacao";
	
	private RestTemplate restTemplate;
	
	public RemoteClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Integer getRemoteIndice() {
		Integer result = -1;
		
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> response = restTemplate.getForEntity(GET_INDICE_URL, Map.class);
		if (HttpStatus.OK.equals(response.getStatusCode()) ) {
			result =  (Integer) response.getBody().get("indice");
		}
		
		System.out.println(String.format("GET INDICE REMOTE: %s - %s ", response.getStatusCode(), response.getBody() ));
		
		return result;
		
	}

}
