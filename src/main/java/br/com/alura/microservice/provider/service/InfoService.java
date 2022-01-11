package br.com.alura.microservice.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.model.InfoProvider;
import br.com.alura.microservice.provider.repository.InfoRepository;

@Service
public class InfoService {

	@Autowired
	private InfoRepository infoRepository;
	
	public InfoProvider getInfoByState(String state) {
		return infoRepository.findByState(state);
	}

}
