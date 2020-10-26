package br.com.everis.redis.repository;

import java.util.Set;

import org.springframework.stereotype.Repository;

import br.com.everis.redis.model.Cockpit;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Repository
public class CockpitRepository {

	String hostname = "localhost";
	int port = 6379;
	Integer db = 0;

	JedisPool pool = new JedisPool(new JedisPoolConfig(), hostname, port);
	Jedis jedis = pool.getResource();
	Cockpit cockpit = new Cockpit();

	public Set<String> getKeys() {
		try {
			jedis.connect();
			jedis.select(db);
			cockpit.setKeys(jedis.keys("*"));
			jedis.disconnect();
			return cockpit.getKeys();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			jedis.disconnect();
			return null;
		}
	}
	
	
	public Long delKey(String key) {
		try {
			jedis.connect();
			jedis.select(db);
			Long deleted = jedis.del(key);
			jedis.disconnect();
			return deleted;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			jedis.disconnect();
			return null;
		}
	}
	
	public String getKey(String key) {
		try {
			jedis.connect();
			jedis.select(db);
			cockpit.setValue(jedis.get(key));
			jedis.disconnect();
			String keyValue = cockpit.getValue();
			return keyValue;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			jedis.disconnect();
			return null;
		}
	}
	
	public String setKey(String key, String value) {
		try {
			jedis.connect();
			jedis.select(db);
			cockpit.setKey(key);
			cockpit.setValue(value);
			String result = jedis.set(cockpit.getKey(), cockpit.getValue());
			jedis.disconnect();
			return result;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			jedis.disconnect();
			return null;
		}
	}

}
