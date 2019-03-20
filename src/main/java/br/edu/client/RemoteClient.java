package br.edu.client;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteClient {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Integer getIndice() {
		ResponseEntity<Map> response = restTemplate.
		getForEntity("https://us-central1-fernando-machado.cloudfunctions.net/indice-validacao", Map.class);
		
		return (Integer) response.getBody().get("indice");
		
	}
	
	public Integer outroIndice() {
		return 34;
	}
}
