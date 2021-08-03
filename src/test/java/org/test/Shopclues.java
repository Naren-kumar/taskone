package org.test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.pages.OppoPage;
import org.pages.SearchPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Shopclues extends BaseClass{
	
	@BeforeClass
	private void beforeClass() {
        browserLaunch("Chrome");
        implicitlyWait(20);
        maximize();
        urlLaunch("https://www.shopclues.com/");
        System.out.println("before class");
	}

	@AfterClass
	private void afterClass() {
       browserQuit();
       System.out.println("after class");
	}
	
	@BeforeMethod
	private void beforeMethod() {
		System.out.println("before method");
       System.out.println(new Date());
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("after method");
	    System.out.println(new Date());
	}
	
	@Test
	private void test1() {
      System.out.println("test 1");
      SearchPage sp = new SearchPage();
      moveToElement(sp.getMveToMobilesAndMore());
      btnClick(sp.getClickOppo());
   
      getWindowHandles(1);      
      
      WebElement oppoProducts = driver.findElement(By.xpath("//div[@id='product_list']")); 
      List<WebElement> products = oppoProducts.findElements(By.className("prod_name"));
      List<WebElement> product = oppoProducts.findElements(By.className("ori_price"));
      
      Map<Integer,String> m = new TreeMap<Integer,String>();
      System.out.println("Total no. of product is "+products.size()+"\n");
      for (int i = 0; i < products.size(); i++) {
	         WebElement productName =  products.get(i);
	       String mobileName = productName.getText();
	       WebElement productPrice = product.get(i);
	       String s =  productPrice.getText();   
	       String s1 = s.replaceAll(",","");
	       String s2 = s1.substring(1, 6);
	       
	       if (s2.contains(" ")) {
	    	  s2 = s1.substring(1, 5);
	       }
	      	         
	       int mobilePrice =  Integer.parseInt(s2);
	       m.put(mobilePrice, mobileName);
	}
      Set<Entry<Integer,String>> list = m.entrySet();
      for (Entry<Integer, String> entry : list) {
		System.out.println(entry);
	}   
	}
}
