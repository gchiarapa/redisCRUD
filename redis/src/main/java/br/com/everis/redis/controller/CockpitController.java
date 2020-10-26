package br.com.everis.redis.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.everis.redis.model.Cockpit;
import br.com.everis.redis.repository.CockpitRepository;

@RestController
@RequestMapping("/api/v1/cache/keys")
public class CockpitController {
	
	@Autowired
	private CockpitRepository cockpitRepository;


	
	@GetMapping
	@ResponseBody
	public ResponseEntity<Set<String>> getAll(){
			Set<String> keys = cockpitRepository.getKeys();
			return new ResponseEntity<Set<String>>(keys, HttpStatus.OK);
		}
	
	@DeleteMapping("/{key}")
	@ResponseBody
	public Long delKey(@PathVariable String key) {
		Long deleted = cockpitRepository.delKey(key);
		return deleted;
	}
	
	@RequestMapping("/{key}")
	@ResponseBody
	public ResponseEntity<String> getKey(@PathVariable String key){
		String keyValue = cockpitRepository.getKey(key);
			return new ResponseEntity<String>(keyValue, HttpStatus.OK);
		}
	
	@PostMapping("/{key}/{value}")
	@ResponseBody
	public ResponseEntity<String> setKey(@PathVariable String key, @PathVariable String value){
		String result = cockpitRepository.setKey(key, value);
			return new ResponseEntity<String>(result, HttpStatus.OK);
		}
}
