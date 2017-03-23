package es.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.core.Delete;
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
public class DelDocTest {

	public static void main(String[] args) throws Exception {
		JestClient client=JestCli.getClient();
		String indexStr="twitter211";
		String typeStr="tweet2222";
		String id="abc";
		
		Get get = new Get.Builder(indexStr, id).type(typeStr).build();

		Delete index = new Delete.Builder(get.toString()).index(indexStr).type(typeStr).id(id).build();
        DocumentResult result=client.execute(index);
        
        System.out.println(result.getJsonString());
		
	}

}
