package es.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Get;
import io.searchbox.core.Index;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @FileName JestClient.java
 * @Description:
 *
 * @Date Sep 5, 2016
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class CreateDocTest {

	public static void main(String[] args) throws Exception {
		JestClient client=JestCli.getClient();
		String indexStr="twitter211";
		String typeStr="tweet2222";
		String id="abc11";
		
		Map<String, String> source=new LinkedHashMap<>();
		source.put("title", "ceo");
		source.put("content", "jeckaaa");
		source.put("content11", "jeckaaa1");

		//新增记录
		Index index = new Index.Builder(source).index(indexStr).type(typeStr).id(id).build();
		DocumentResult result=client.execute(index);
		
		System.out.println(result.getJsonString());
		
		//查看记录
		//Search search = new Search.Builder().addIndex("twitter2").addType("tweet2")..id("abc").build();
		Get get = new Get.Builder(indexStr, id).type(typeStr).build();

		JestResult result2 = client.execute(get);
		System.out.println(result2.getJsonString());
		
	}

}
