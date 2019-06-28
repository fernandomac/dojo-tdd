package br.edu.client;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteClient {
	
	private RestTemplate restTemplate;
	
	public RemoteClient() {
		restTemplate = new RestTemplate();
	}
	
	public int getIndice() {
		ResponseEntity<Map> entity = 
				restTemplate.getForEntity("https://us-central1-fernando-machado.cloudfunctions.net/indice-validacao", 
				Map.class);
		return (int) entity.getBody().get("indice");
	}

}
