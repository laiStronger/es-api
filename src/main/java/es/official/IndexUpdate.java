package es.official;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;

import com.google.common.collect.Maps;
import com.google.gson.Gson;

public class IndexUpdate {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		TransportClient client = EsClient.getClient();
		indexCreate(client);
		update(client);
		bulkUpdate(client);

		// on shutdown
		client.close();

	}
	
	public static void indexCreate(Client client) {
		Map<String, Object> map = Maps.newHashMap();
		map.put("title", "title-01");
		map.put("body", "body test");
		map.put("publish", "publish_date");
		String s = new Gson().toJson(map);
		IndexResponse res = null;
		res = client.prepareIndex("api_test", "type_test").setId("2").setSource(s).execute().actionGet();
		System.out.println("======== creating =========");
		System.out.println(res);

	}
	
	public static void update(Client client ) throws IOException, InterruptedException, ExecutionException {
		UpdateRequest req = new UpdateRequest();
		req.index("api_test");
		req.type("type_test");
		req.id("2");
		req.doc(jsonBuilder().startObject().field("title", "updated title123").field("body", "updated body").endObject());
		client.update(req).get();
		System.out.println(req.doc());
		//GET /api_test/type_test/2
	}
	
	public static void bulkUpdate(Client client ) throws IOException, InterruptedException, ExecutionException {
		
		BulkRequestBuilder req = client.prepareBulk();
		req.add(client.prepareIndex("search_test","article","2")
					.setSource(jsonBuilder()
							.startObject()
							.field("title","bulk title 02 04-05")));
		req.add(client.prepareIndex("search_test","article","3")
				.setSource(jsonBuilder()
						.startObject()
						.field("title","bulk title 03 04-05")));
		req.add(client.prepareIndex("search_test","article","4")
				.setSource(jsonBuilder()
						.startObject()
						.field("title","bulk title 04 04-05")));
        BulkResponse res = req.execute().actionGet();		
        
        if (res.hasFailures()){
        	System.out.println("Error");
        } else {
        	System.out.println("Done");
        }
        //GET /search_test/article/_search

	}
	

	
	

}
