package br.com.alura.microservice.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.model.InfoProvider;
import br.com.alura.microservice.provider.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);

	@Autowired
	private InfoService infoService;
	
	@RequestMapping("/{state}")
	public InfoProvider getInfoByState(@PathVariable String state) {
		
		LOG.info("received info order of provider localized in {}", state);
		return infoService.getInfoByState(state);
	}
}
