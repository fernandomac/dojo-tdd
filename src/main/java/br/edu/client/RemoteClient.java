package br.edu.client;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RemoteClient {
	
	private final RestTemplate rest ;
	
	public RemoteClient(RestTemplate rest) {
		super();
		this.rest = rest;
	}

	public Integer getRemoteIndex() {
		ResponseEntity<Map> response = 
				rest.getForEntity("https://us-central1-fernando-machado.cloudfunctions.net/indice-validacao", Map.class);
		Integer remoteIndice = (Integer) response.getBody().get("indice");
		System.out.println(remoteIndice);
		return remoteIndice;
	}

}
