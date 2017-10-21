package es.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;

/**
 * @FileName JestClient.java
 * @Description:
 *
 * @Date Sep 5, 2016 
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class JestCli {

	public static JestClient getClient() {
		JestClientFactory factory = new JestClientFactory();
		factory.setHttpClientConfig(new HttpClientConfig.Builder("http://192.168.1.12:9200").multiThreaded(true).build());

		JestClient client = factory.getObject();
		return client;
	}
	

}
