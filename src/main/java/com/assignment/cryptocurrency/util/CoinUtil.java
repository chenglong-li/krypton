package com.assignment.cryptocurrency.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

public class CoinUtil 
{
	//---------------------------------------------------------------------
	public String getCoinPriceByName(String name)
	{
		CloseableHttpClient httpClient=null;
		try 
		{
			httpClient = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet("https://api.coinmarketcap.com/v1/ticker/"+name);
		    request.addHeader("content-type", "application/json");
		    HttpResponse  response = httpClient.execute(request);
		    if(response.getStatusLine().getStatusCode()==200)
		    {
		    	BufferedReader reader = null;
				try 
				{
					reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
					StringBuilder builder = new StringBuilder();
					for (String line = null; (line = reader.readLine()) != null;) 
					{
					    builder.append(line).append("\n");
					}
					JSONArray arr = new JSONArray(builder.toString());
					JSONObject json= arr.getJSONObject(0);
					return json.getString("price_usd");
				}
				catch (Exception ex) 
				{
				} 
				finally 
				{
					
				}
		    }
		} 
		catch (Exception ex) 
		{
		} 
		finally 
		{
			try 
			{
				httpClient.close();
			} 
			catch (IOException e1) 
			{
			}
		}
		return null;
	}
	//---------------------------------------------------------------------
}
