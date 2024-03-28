package com.akillifiyat.MarketAPIS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.akillifiyat.entity.MigrosDiscount;
import com.akillifiyat.product.Product;

@Component
public class MigrosAPI {

	public List<MigrosDiscount> discountProducts() {

		List<MigrosDiscount> migrosDiscountProducts = new ArrayList<MigrosDiscount>();
		
		try {
			// URL of the JSON API
			String apiUrl = "https://www.migros.com.tr/rest/home/screens";

			// Create a URL object
			URL url = new URL(apiUrl);

			// Open a connection to the URL
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();

			// Set request method to GET
			connection.setRequestMethod("GET");

			// Get the response code
			int responseCode = connection.getResponseCode();

			// If response code is successful (200)
			if (responseCode == HttpURLConnection.HTTP_OK) {
				// Read the JSON response
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
				String inputLine;
				StringBuilder response = new StringBuilder();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();

				// Parse JSON response
				JSONObject jsonResponse = new JSONObject(response.toString());

				// Get the data array
				JSONArray mainShoppingLists = jsonResponse.getJSONObject("data").getJSONArray("tabShoppingLists")
						.getJSONObject(0).getJSONArray("itemInfos");

				// Loop through each item
				for (int i = 0; i < mainShoppingLists.length(); i++) {

					JSONObject item = mainShoppingLists.getJSONObject(i);
					String photo = item.getJSONArray("images").getJSONObject(0).getJSONObject("urls").getString("PRODUCT_DETAIL");
					
					MigrosDiscount p = new MigrosDiscount(item.getString("name")
							,item.getFloat("regularPrice")/100
							,item.getFloat("shownPrice")/100
							,item.getInt("discountRate")
							, photo);		
//					discountProducts.add(p);
					
					migrosDiscountProducts.add(p);
					
					
					
					

				}
			} else {
				System.out.println("Failed to retrieve JSON. Response code: " + responseCode);
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	return migrosDiscountProducts;
	}
	
	 
}
