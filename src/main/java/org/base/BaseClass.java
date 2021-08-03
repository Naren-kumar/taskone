package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.server.handler.CloseWindow;
import org.openqa.selenium.support.ui.Select;

public class BaseClass {
 public static WebDriver driver;
 
 
	public static WebDriver browserLaunch(String browserName) {     //browserlaunch(1)
		switch (browserName) {
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\NarenKumar\\eclipse-workspace1\\TestNG\\chromedriver\\chromedriver.exe");
	        driver = new ChromeDriver();
			break;
		case"Firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\NarenKumar\\eclipse-workspace1\\MavenProject\\Driver\\geckodriver.exe");
	        driver = new FirefoxDriver();
			break;
		case"Ie":
			System.setProperty("webdriver.ie.driver", "C:\\Users\\NarenKumar\\eclipse-workspace1\\MavenProject\\Driver\\IEDriverServer.exe");
	        driver = new InternetExplorerDriver();
			break;
		case"Edge":
			System.setProperty("webdriver.edge.driver", "C:\\Users\\NarenKumar\\eclipse-workspace1\\MavenProject\\Driver\\msedgedriver.exe");
	        driver = new EdgeDriver();
			break;
			
		default:
			System.err.println("invalid browser");
			break;
		}
		return driver;
	}
	
	public static void urlLaunch(String url) {  //driver.get Url(2)
        driver.get(url);
	}
	
	public static String getTitle() {   //driver.get Title[3]
       String title = driver.getTitle();
       System.out.println(title);
	return title;
      }
	
	public static String getCurrentUrl() {//driver.getCurrentUrl [4]
         String url = driver.getCurrentUrl();
         System.out.println(url);
		return url;
	}
	
	public static void browserQuit() {//driver.browserQuit[5]
         driver.quit();
	}
	
	public static void fillTextBox(WebElement element,String value ) {//.sendkeys[6]
        element.sendKeys(value);
	}
	
	public static void btnClick(WebElement element) {//click[7]
            element.click();
	}
	
	public static String getText(WebElement element) {//getText[8]
		String text = element.getText();
		System.out.println(text);
		return text;
	}
	
	public static String getAttribute(WebElement element, String value) {//getAttribute[9]
         String attribute =  element.getAttribute(value);
         System.out.println(attribute);
		return attribute;
	}
	
	public static void maximize() {//maximize[10]
         driver.manage().window().maximize();
	}
	
	public static void moveToElement(WebElement element) {//moveToElement[11]
         Actions a = new Actions(driver);
         a.moveToElement(element).perform();
	}
	
	public static void dragAndDrop(WebElement src, WebElement des) {//dragAndDrop[12]
        Actions a = new Actions(driver);
        a.dragAndDrop(src, des).perform();
	}
	
	public static void contextClick( WebElement element) {//contextclick with webelement[13]
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}
	
	public static void contextClick( ) {//contextclick [14]
		Actions a = new Actions(driver);
		a.contextClick().perform();
	}	
	
	public static void doubleClick() {//doubleclick[15]
		Actions a = new Actions(driver);
		a.doubleClick().perform();
	}
	
	public static void doubleClick(WebElement element) {//doubleclick with element[16]
		Actions a = new Actions(driver);
		a.doubleClick(element);
	}
	
	public static void upperCase(WebElement element, CharSequence input) {//uppercase[17]
		Actions a = new Actions(driver);
		a.keyDown(element,Keys.SHIFT).sendKeys(input).keyUp(element,Keys.SHIFT).build().perform();
	}
	
	public static void acceptAlert() {//acceptAlert[18]
              Alert a = driver.switchTo().alert();
              System.out.println(a.getText());
              a.accept();
	}
	
	public static void dismissAlert() {//dismissAlert[19]
        Alert a = driver.switchTo().alert();
        System.out.println(a.getText());
        a.dismiss();
    }
	
	public static void promptAlert(String input, boolean accept) {//promptAlert[20]
        Alert a = driver.switchTo().alert();
        a.sendKeys(input);
        System.out.println(a.getText());
        if (accept) {
			a.accept();
		}
        else {
			a.dismiss();
		}
      
    }
	
	public static void selectByIndex(WebElement element, int index) {//selectbyIndex[21]
        Select s = new Select(element);
         s.selectByIndex(index);	
	}
	
	public static void selectByValue(WebElement element, String value) {//selectbyValue[22]
        Select s = new Select(element);
         s.selectByValue(value);	
	}
	
	public static void selectByVisibleText(WebElement element, String text) {//selectbyText[23]
        Select s = new Select(element);
         s.selectByVisibleText(text);	
	}
	
	public static boolean selectIsMultiple(WebElement element) {//selectIsMultiple[24]
        Select s = new Select(element);
        boolean mt = s.isMultiple();
         System.out.println(element+"is multiple: "+mt);
         return mt;
	}
	
	public static int optionSize(WebElement element) {//size of dropdown[25]
		Select s = new Select(element);
		List<WebElement> l = s.getOptions();
		int size = l.size();
		return size;
	}
	
	public static String getOptions(WebElement element) {//getOptions[26]
		Select s = new Select(element);
		List<WebElement> l = s.getOptions();
		for (int i = 0; i < l.size(); i++) {
			WebElement e =l.get(i);
			String options =e.getText();
			System.out.println(options);
			return options;
		}
		return null;
	}
	
	public static void deselectByIndex(WebElement element, int index) {//deselectbyIndex[27]
        Select s = new Select(element);
         s.deselectByIndex(index);	
	}
	
	public static void deselectByValue(WebElement element, String value) {//deselectbyValue[28]
        Select s = new Select(element);
         s.deselectByValue(value);	
	}
	
	public static void deselectByVisibleText(WebElement element, String text) {//deselectbyText[29]
        Select s = new Select(element);
         s.deselectByVisibleText(text);	
	}
	
	public static void deselectAll(WebElement element) {//deselectAll[30]
        Select s = new Select(element);
         s.deselectAll();	
	}
	
	public static String getSelectedOptions(WebElement element) {//getselectedoptions[31]
		Select s = new Select(element);
		List<WebElement> l = s.getAllSelectedOptions();
		for (int i = 0; i < l.size(); i++) {
			WebElement e =l.get(i);
			String options =e.getText();
			System.out.println(options);
			return options;
		}
		return null;
	}
	
	public static String getFirstSelected(WebElement element) {//getfirstselectedoptions[32]
		Select s = new Select(element);
		WebElement e =s.getFirstSelectedOption();
		String option =e.getText();
		System.out.println(option);
		return option;
	}
	
	public static void selectAllOptions(WebElement element) {//select all options[33]
		Select s = new Select(element);
		    List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			s.selectByIndex(i);
		}
	}
	
	public static void takeScreenShot(String copyPath, String name) throws IOException {// Take screenshot[34]
        TakesScreenshot tk = (TakesScreenshot)driver;
        
        File src = tk.getScreenshotAs(OutputType.FILE);
        
        long tt = System.currentTimeMillis();
        
        File des = new File(copyPath+"\\"+name+tt+".png");
        FileUtils.copyFile(src, des);
	}
	
	public static void sendKeysByJavaScriptExecutor( String attribute, String input, WebElement element) {//send keys by java script executor[35]
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('"+attribute+"','"+input+"')" ,element);
	}
	
	public static void clickByJavaScriptExecutor(WebElement element) {//click by java script executor[36]
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()" ,element);
	}
	
	public static String getAttributeByJavaScriptExecutor( String attribute, WebElement element) {//getAttribute by java script executor[37]
		JavascriptExecutor js = (JavascriptExecutor) driver;
      Object obj =  js.executeScript("return arguments[0].getAttribute('"+attribute+"')" ,element);
      String s1 = (String) obj;
      System.out.println(s1);
	  return s1;
        
	}
	
	public static void scrollUpByJavaScriptExecutor(WebElement element) {//scroll up by java script executor [38]
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	
	public static void scrollDownByJavaScriptExecutor(WebElement element) {//scroll down by java script executor [39]
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}
	
	public static  void navigateTo(String Url) {//navigate to [40]
          driver.navigate().to(Url);
	}
	
	public static  void navigateForward() {//navigate forward [41]
        driver.navigate().forward();
	}
	
	public static  void navigateBack() {//navigate back [42]
        driver.navigate().back();
	}
	
	public static  void navigateRefresh() {//navigate refresh [43]
        driver.navigate().refresh();
	}
	
	public static boolean isDisplayed(WebElement element) {//is displayed[44]
     boolean  b =   element.isDisplayed();
     System.out.println(b);
	 return b;
	}
	
	public static boolean isSelected(WebElement element) {//is selected[45]
	     boolean  b =   element.isSelected();
	     System.out.println(b);
		 return b;
		}
	
	public static boolean isEnabled(WebElement element) {//is enabled[46]
	     boolean  b =   element.isEnabled();
	     System.out.println(b);
		 return b;
		}
	
	public static void implicitlyWait(long seconds ) {//implicity wait[47]
		
          driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);	
	}
	
	public static void getWindowHandles(int windowIndex) {//window Handles[48]
	   Set<String> allId = driver.getWindowHandles();
	   List<String> l= new LinkedList<String>(); 
	   l.addAll(allId);
	   driver.switchTo().window(l.get(windowIndex));
	}
	
	public static void closeWindow() {//close window[49]
       driver.close();
	}
	
	public static void switchToFrameByIndex(int index) {//frame [50]
		driver.switchTo().frame(index);
	}
	
    public static void switchToFrameByString(String NameorId) {//frame [51]
    	driver.switchTo().frame(NameorId);
	}

    public static void switchToFrameByElement(String element) {//frame [52]
    	driver.switchTo().frame(element);
   }
    
    public static void switchToDefaultContent(String element) {//frame [53]
    	driver.switchTo().defaultContent();
    } 	
    
    public static void switchToParentFrame(String element) {//frame [54]
    	driver.switchTo().parentFrame();
    }
    
    public static String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws IOException {//get Excel Data [55]
        File f = new File("C:\\Users\\NarenKumar\\eclipse-workspace1\\MavenProject\\Excel\\Book.xlsx");
        FileInputStream sf = new FileInputStream(f);
        Workbook w = new XSSFWorkbook(sf);
        Sheet s = w.getSheet(sheetName);
        Row row = s.getRow(rowNo);
        Cell cell = row.getCell(cellNo);
        int type = cell.getCellType();
        String value;
        if (type==1) {
		  value = cell.getStringCellValue();
		}
        else {
			if (DateUtil.isCellDateFormatted(cell)) {
				Date date =cell.getDateCellValue();
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
				value = sdf.format(date);
			}
			else {
				double db = cell.getNumericCellValue();
				long ln = (long) db;
				value =String.valueOf(ln);
			}
		}
      
		return value;
	}    
   
 
}

