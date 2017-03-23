package es.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Update;

import java.util.LinkedHashMap;
import java.util.Map;

import com.google.gson.Gson;

/**
 * @FileName JestClient.java
 * @Description:
 *
 * @Date Sep 5, 2016
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class UpdateDocTest {

	public static void main(String[] args) throws Exception {
		JestClient client=JestCli.getClient();
		String indexStr="twitter211";
		String typeStr="tweet2222";
		String id="abc";
		
		Map<String, Object> source=new LinkedHashMap<>();
		Map<String, String> doc=new LinkedHashMap<>();
		source.put("doc", doc);
		doc.put("name1", "name1");
		doc.put("name2", "name2");

		Update index = new Update.Builder(new Gson().toJson(source)).index(indexStr).type(typeStr).id(id).build();
		DocumentResult result=client.execute(index);
		
		System.out.println(result.getJsonString());
		
		//Search search = new Search.Builder().addIndex("twitter2").addType("tweet2")..id("abc").build();
		Get get = new Get.Builder(indexStr, id).type(typeStr).build();

		JestResult result2 = client.execute(get);
		System.out.println(result2.getJsonString());
		
	}

}
