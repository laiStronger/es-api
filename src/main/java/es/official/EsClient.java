package es.official;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;

public class EsClient {

	public static TransportClient getClient() throws UnknownHostException {

		// Client client = TransportClient.builder().build()
		// .addTransportAddress(new
		// InetSocketTransportAddress(InetAddress.getByName("192.168.22.82"),
		// 9300));

		// you have to set the cluster name if you use one different than
		// "elasticsearch":
		Settings settings = Settings.settingsBuilder().put("cluster.name", "my-application").build();

		TransportClient client = TransportClient.builder().settings(settings).build()
				.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("192.168.22.82"), 9300));

		return client;

	}
}
