package com.scrape.WebScrape;

import com.google.gson.Gson;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHeaders;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.*;
import java.net.*;
import java.util.*;

@SpringBootApplication
public class WebScrapeApplication {
	private static String apiKey = "784caf04-f15b-44bf-b2a2-b03265f8dc46";

	public static void main(String[] args) throws IOException {
		SpringApplication.run(WebScrapeApplication.class, args);

		//Scrape();

		String uri = "https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest";
		List<NameValuePair> parameters = new ArrayList<NameValuePair>();
		parameters.add(new BasicNameValuePair("start","1"));
		parameters.add(new BasicNameValuePair("limit","5000"));
		parameters.add(new BasicNameValuePair("convert","USD"));

		try{
			CryptoDTO[] capturedCrypto;
			capturedCrypto = makeAPIcall(uri, parameters);
			for(int i = 0; i < capturedCrypto.length; i++){
				try{
					System.out.println(capturedCrypto[i].name);
					System.out.println(capturedCrypto[i].id);
					System.out.println(capturedCrypto[i].quote.USD.price);
					System.out.println(capturedCrypto[i].quote.USD.percent_change_1hr);
					System.out.println(capturedCrypto[i].quote.USD.percent_change_24hr);
					System.out.println(capturedCrypto[i].quote.USD.percent_change_7d);
					System.out.println(capturedCrypto[i].quote.USD.volume_24hr);


					System.out.println(" ");
				}catch(Exception e){
					System.out.println(" ");
				}


			}
		}catch(IOException e){
			System.out.println("ERROR: Cannot access content - " + e.toString());
		}catch(URISyntaxException ex){
			System.out.println("ERROR: Invalid URL - " + ex.toString());
		}
	}
	public static CryptoDTO[] makeAPIcall(String uri, List<NameValuePair> parameters) throws URISyntaxException, IOException{
		String response_content = "";

		URIBuilder query = new URIBuilder(uri);
		query.addParameters(parameters);

		CloseableHttpClient client = HttpClients.createDefault();
		HttpGet request = new HttpGet(query.build());

		request.setHeader(HttpHeaders.ACCEPT, "application/json");
		request.addHeader("X-CMC_PRO_API_KEY", apiKey);

		CloseableHttpResponse response = client.execute(request);

		try{
			System.out.println(response);
			HttpEntity entity = response.getEntity();
			response_content = EntityUtils.toString(entity);
			EntityUtils.consume(entity);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		Gson gson = new Gson();
		DataDTO result = gson.fromJson(response_content, DataDTO.class);

		return result.data;
	}

//	public static void Scrape() {
//		String url = "https://coinmarketcap.com/";
//		Document document = null;
//		try {
//			document = Jsoup.connect(url).get();
//			for(Element row : document.select(
//					// inspect the table to see what it's class is. Remove spaces with .
//					// add a space + tr on the end, to select the tablerows
//					"table.cmc-table.cmc-table___11lFC.cmc-table-homepage___2_guh tr")){
//				if(row.select("td:nth-child(3)").text().equals("")){
//					continue;
//				}else{
//					String name = row.select("td:nth-child(3)").text();
//					String tempPrice = row.select("td:nth-child(4)").text();
//
//					System.out.println(name + " - " + tempPrice);
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

	class DataDTO{
		public CryptoDTO[] data;
	}

	class CryptoDTO{
		public Long id;
		public String name;
		public String price;
		public Quote quote;
	}
	class Quote{
		public USD USD;
	}
	class USD{
		public double price;
		public double volume_24hr;
		public double percent_change_1hr;
		public double percent_change_24hr;
		public double percent_change_7d;
	}

}