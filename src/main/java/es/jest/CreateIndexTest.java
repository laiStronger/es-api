package es.jest;

import io.searchbox.client.JestClient;
import io.searchbox.client.JestResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.DeleteIndex;

/**
 * @FileName JestClient.java
 * @Description:
 *
 * @Date Sep 5, 2016
 * @author YangShengJun
 * @version 1.0
 * 
 */
public class CreateIndexTest {

	public static void main(String[] args) throws Exception {
		JestClient client=JestCli.getClient();
		String index="articles_1";
		client.execute(new DeleteIndex.Builder(index).build());
		JestResult result=client.execute(new CreateIndex.Builder(index).build());
		System.out.println(result.getJsonString());
		
	}

}
