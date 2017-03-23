package es.official;

import java.net.UnknownHostException;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;

public class CompoundQueryTest {

	public static void main(String[] args) throws UnknownHostException {
		TransportClient client = EsClient.getClient();
		//constantScoreQuery(client);
		//booQuery(client);
		disMaxQuery(client);
		client.close();
	}
	
	public static void constantScoreQuery(Client client ) {
		SearchResponse res = null;
		QueryBuilder qb = QueryBuilders
				.constantScoreQuery(QueryBuilders.termQuery("title","article"))
				.boost(2.0f);
		
		res = client.prepareSearch("search_test")
				.setTypes("article")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(qb)
				.setFrom(0)
				.setSize(10)
				.execute().actionGet();
		for (SearchHit hit: res.getHits().getHits()) {
			System.out.println(hit.getSourceAsString());
		}
	}
	
	public static void booQuery(Client client ) {
		SearchResponse res = null;
		QueryBuilder qb = QueryBuilders.boolQuery()
				.must(QueryBuilders.termQuery("title","article"))
				.mustNot(QueryBuilders.termQuery("title","relevance"))
				.should(QueryBuilders.termQuery("title","article"))
				.filter(QueryBuilders.termQuery("title","article"));
		
		
		res = client.prepareSearch("search_test")
				.setTypes("article")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(qb)
				.setFrom(0)
				.setSize(10)
				.execute().actionGet();
		for (SearchHit hit: res.getHits().getHits()){
			System.out.println(hit.getSourceAsString());
		}
		
	}
	
	public static void disMaxQuery(Client client ) {
		SearchResponse res = null;
		QueryBuilder qb = QueryBuilders
				.disMaxQuery()
				.add(QueryBuilders.termQuery("title","article"))
				.add(QueryBuilders.termQuery("title","relevance")).boost(1.2f).tieBreaker(0.7f);
		
		res = client.prepareSearch("search_test")
				.setTypes("article")
				.setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
				.setQuery(qb)
				.setFrom(0)
				.setSize(10)
				.execute().actionGet();
		for (SearchHit hit: res.getHits().getHits()) { 
			System.out.println(hit.getSourceAsString());
		}
		
	}
	
}
