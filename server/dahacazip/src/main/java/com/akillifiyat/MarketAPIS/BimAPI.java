package com.akillifiyat.MarketAPIS;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import com.akillifiyat.entity.BimDiscount;
import com.akillifiyat.product.Product;

@Component
public class BimAPI {

    public List<BimDiscount> discountProducts() {
    	
    	List<BimDiscount> sum = new ArrayList();
        try {
            String baseUrl = "https://www.bim.com.tr/";
            Document document2 = Jsoup.connect(baseUrl).get();

            // Find the second element with class "inner triangle"
            Elements innerTriangleElements = document2.getElementsByClass("inner triangle");
            if (innerTriangleElements.size() >= 2) {
                Element secondInnerTriangle = innerTriangleElements.get(1);

                // Find the link inside the second inner triangle with class "subButton"
                Element subButtonElement = secondInnerTriangle.selectFirst(".subButton");
                if (subButtonElement != null) {
                    String hrefLink = baseUrl + subButtonElement.attr("href");

                    // Now you can use hrefLink as the desired link
                    // System.out.println("Desired link: " + hrefLink);

                    // Connect to the new URL using hrefLink
                    Document document = Jsoup.connect(hrefLink).get();

                    // Process elements with class "product col-xl-3 col-lg-3 col-md-4 col-sm-6  col-12"
                    
                   List<BimDiscount> list1 =  processElements1(document.getElementsByClass("product col-xl-3 col-lg-3 col-md-4 col-sm-6  col-12"));
                   List<BimDiscount> list2 = processElements( document.getElementsByClass("product col-xl-3 col-lg-3 col-md-4 col-sm-6 col-12 LoadGroup0"));
                   sum.addAll(list1);
                   sum.addAll(list2);
                    // Process elements with class "product col-xl-3 col-lg-3 col-md-4 col-sm-6 col-12 LoadGroup0"


                    // Continue with the rest of your web scraping logic
                    // ...
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        	return sum;
    }

    public List<BimDiscount> processElements(Elements elements) {

    List<BimDiscount> ProductArrayList = new ArrayList();
    
    	
        for (Element element : elements) {
            try {
         
                String html = element.html();
                Document test = Jsoup.parse(html);
                Element itemNameElement;
                Element itemNameElement2;
                Element itemPriceElement;
                Element itemPriceElement2;
                Element ayrintiLink;
                Element itemPriceEski;
                Element imgElement = test.select("img").first();
                itemPriceEski = element.select(".text.quantify").first();
                String stringEskiFiyat = itemPriceEski.text();
                    itemNameElement = test.select(".subTitle").first();
                    itemNameElement2 = test.select(".title").first();
                   // itemPriceElement = test.select(".quantify").first();
                    Elements textQuantifyElements = element.select(".text.quantify");
                    String itemPrice = "";
                    if (textQuantifyElements.size() >= 2) {
                        itemPriceElement = textQuantifyElements.get(1);
                         itemPrice = itemPriceElement.text();}

                    itemPriceElement2 = test.select(".number").first();
                    String itemName = itemNameElement.text();
                    String itemName2 = itemNameElement2.text();

                    String itemPrice2 = itemPriceElement2.text();
                    String dataSrc = "https://www.bim.com.tr" + imgElement.attr("xsrc");

                    ayrintiLink = test.selectFirst("a");
                    String ayrintLinkString = "https://www.bim.com.tr/" + ayrintiLink.attr("href");
                    if (dataSrc.equals("")) {

                        continue;
                    }

                    
                    BimDiscount bimDiscount = new BimDiscount(itemName + " " + itemName2
                    		, itemPrice + itemPrice2 + " \u20BA"
                    		, stringEskiFiyat + " \u20BA"
                    		, dataSrc);
                ProductArrayList.add(bimDiscount);
                
             
            } catch (Exception e) {
                e.printStackTrace();


            }
        }
        return ProductArrayList;
        
        
    }
    public List<BimDiscount> processElements1(Elements elements) {
    	
    	List<BimDiscount>  ProductArrayList = new ArrayList();
    	
    	
        for (Element element : elements) {
            try {
               
                String html = element.html();
                Document test = Jsoup.parse(html);
                Element itemNameElement;
                Element itemNameElement2;
                Element itemPriceElement;
                Element itemPriceElement2;
                Element ayrintiLink;
                Element itemPriceEski;
                Element imgElement = test.select("img").first();
                itemPriceEski = element.select(".text.quantify").first();
                String stringEskiFiyat = itemPriceEski.text();

                itemNameElement = test.select(".subTitle").first();
                itemNameElement2 = test.select(".title").first();
                // itemPriceElement = test.select(".quantify").first();
                Elements textQuantifyElements = element.select(".text.quantify");
                String itemPrice = "";
                if (textQuantifyElements.size() >= 2) {
                    itemPriceElement = textQuantifyElements.get(1);
                    itemPrice = itemPriceElement.text();}

                itemPriceElement2 = test.select(".number").first();
                String itemName = itemNameElement.text();
                String itemName2 = itemNameElement2.text();

                String itemPrice2 = itemPriceElement2.text();
                String dataSrc = "https://www.bim.com.tr" + imgElement.attr("src");

                ayrintiLink = test.selectFirst("a");
                String ayrintLinkString = "https://www.bim.com.tr/" + ayrintiLink.attr("href");
                if (dataSrc.equals("")) {

                    continue;
                }


                
                BimDiscount bimDiscount = new BimDiscount(itemName + " " + itemName2
                		, itemPrice + itemPrice2 + " \u20BA"
                		, stringEskiFiyat + " \u20BA"
                		, dataSrc);
            ProductArrayList.add(bimDiscount);

            } catch (Exception e) {
                e.printStackTrace();


            }
        }
	
        return ProductArrayList;
        

    }
	
}
