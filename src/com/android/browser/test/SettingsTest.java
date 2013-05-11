package com.android.browser.test;

 
import java.util.ArrayList;

import android.content.Intent;
import android.net.Uri;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

 
@SuppressWarnings("rawtypes")
public class SettingsTest extends ActivityInstrumentationTestCase2 {
	private static final String TARGET_PACKAGE_ID="com.test.sendsms";
	private static final String  LAUNCHER_ACTIVITY_FULL_CLASSNAME="com.android.browser.BrowserActivity";
	 
	private static Class launcherActivityClass;
	private Solo solo; 
	private WebView webview;
 
	static{
		
		try {
			launcherActivityClass=Class.forName(LAUNCHER_ACTIVITY_FULL_CLASSNAME);
			} catch (ClassNotFoundException e){ 
				throw new RuntimeException(e); 
			}
		}  
	 
 
	@SuppressWarnings({ "unchecked", "deprecation" })
	public SettingsTest()throws ClassNotFoundException{
		super(TARGET_PACKAGE_ID,launcherActivityClass);
	}
	
	public void setUp()throws Exception{
		solo = new Solo(getInstrumentation(),getActivity());
		solo.sleep(3000);
		webview=solo.getCurrentViews(WebView.class).get(0);
		solo.sleep(2000);

		}

	public void testSnsphsot() throws Exception {
		solo.sleep(2000);
		webview.loadUrl("http://imps.tcl-ta.com/stream/stream.html");
	    solo.sleep(5000);
	    boolean actual=solo.waitForText("SDP");
	    solo.sleep(2000);
	    assertEquals("Not found",true,actual);
	    
	    solo.clickOnText("SDP");
	    solo.sleep(2000);
	    View testView=solo.waitForViewFromText("SDP");
	    int[] locationView=new int[2];
	    testView.getLocationOnScreen(locationView);
	    
	    Log.e(Integer.valueOf(locationView[0]).toString(),"test");
	    Log.e(Integer.valueOf(locationView[1]).toString(),"test");
	    //solo.clickOnView(solo.waitForViewFromText("hao123"));
	    solo.sleep(2000);
	    solo.sendKey(KeyEvent.KEYCODE_BACK);
	    //Log.d(tag, msg)
	    assertEquals("Not found",true,actual);
		//solo.sendKey(KeyEvent.KEYCODE_VOLUME_UP);
		solo.sleep(4000);
		//solo.takeScreenshot("test");
		//solo.sleep(1000);
		//solo.screenshotTaker.takeScreenshot(solo.getCurrentViews().get(0), "test", 100);
		for(WebElement web:solo.getCurrentWebElements()){
	    	Log.e(web.getTagName(), "tagName");
	    	Log.e(web.getvalue() + "/" +web.getText(), "tagName");
	    }

	}
   public void testAlertButton() throws Exception{
	    webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/anchor/attribute.html");
	    solo.sleep(3000);
	    solo.clickOnWebElement(new By.TagName("INPUT"));
	    boolean actual_result=solo.waitForText("Yahoo");
	    solo.sleep(2000);
		assertEquals("Sohu doesn't displayed", true, actual_result);
		solo.sendKey(KeyEvent.KEYCODE_BACK);
		}
   public void testDomWriteText() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/write_text.html");
	   boolean actual_result_writetext=solo.waitForText("Hello World");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writetext);
	   solo.sleep(3000);
   }
   
   public void testDomWriteTextWithFormat() throws Exception {
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/text_with_format.html");
	   boolean actual_result_writetextwithFormat=solo.waitForText("This is a header");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writetextwithFormat);
	   solo.sleep(3000);
   }
   
   public void testDomWriteTitle() throws Exception {
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/title.html");
	   boolean actual_result_writeTitle=solo.waitForText("My title");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_writeTitle);
	   solo.sleep(3000);
	   
   }
   public void testReturnUrl() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/url.html");
	   boolean actual_result_returnUrl=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/document/url.html");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result_returnUrl);
	   solo.sleep(3000);

   }
  
  public void testDomReturnReffer() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/referrer.html");
	   solo.sleep(2000);
	   boolean actual_result=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/document/document.html");
	   solo.sleep(2000);
	   assertEquals("reffer url doesn't is", true, actual_result);
	   solo.sleep(3000);
   }
  public void testDomReturnDomain() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/domain.html");
	   boolean actual_result=solo.waitForText("123.71.192.55");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result);
	   solo.sleep(3000);
  }
  
/*  public void testDomGetElementByID() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/getelementbyid.html");
	   solo.sleep(3000);
	   solo.clickOnWebElement(new By.Id("myHeader"));
	   boolean actual_result=solo.waitForText("This is a header");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result);
	   solo.sleep(10000);
	   webview=null;
	   this.tearDown();
	   

 }*/
  public void testDomGetElementName() throws Exception{
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/text_with_format.html");
	   solo.sleep(3000);
	   boolean actual_result=solo.waitForText("This is a header");
	   solo.sleep(2000);
	   assertEquals("Sohu doesn't displayed", true, actual_result);
	   solo.sleep(2000);

}
 
  public void testgetElementsByName() throws Exception {
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/getelementsbyname.html");
	   solo.sleep(3000);
	   solo.clickOnWebElement("How many elements named 'myInput'?", 0, true);
	   solo.sleep(3000);

  }
  public void testDomAnchorOpenNewDocument() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/open.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Learning about the DOM is FUN!");
	  assertEquals("Learning about the DOM is FUN", true, actual_result);
	  solo.sleep(2000);
  }
  public void testDomAchorReturnNumberOfAnchor() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_anchors.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("3");
	  assertEquals("Number of Anchor", true, actual_result);
  }
  
  public void testDomAchorReturnFirstAnchor() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/1st_anchor.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("First anchor", 2, 3000);
	  assertEquals("Number of First Anchor", true, actual_result);
	  solo.sleep(3000);
  }
  
  public void testDomAchorReturnNumberOfForms() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_forms.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("3 forms");
	  assertEquals("Number of forms", true, actual_result);
	  solo.sleep(2000);

  }
  
  public void testDomAchorReturnAccessItemInCollection() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/access_item.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("The first form's name is: Form1", 2, 3000);
	  assertEquals("Number of forms", true, actual_result);
	  solo.sleep(2000);
  }
  
  public void testDomAchorReturnCountOfImage() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/document/number_of_images.html");
	  
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("2 images");
	  assertEquals("Number of forms", true, actual_result);
	  solo.sleep(2000);

  }
  
  public void testFormChangeURL() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/change_action.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Change action attribute and submit form", 0, true);
	  solo.sleep(2000);
	  solo.clickOnText("OK");
	  solo.sleep(2000);
	  solo.clickOnText("OK");
	  solo.sleep(2000);
	  boolean actual_result=webview.getUrl().equals("http://123.71.192.55:8001/Browser/DOM/form/default.php");
	  solo.sleep(2000);
	  assertEquals("Current url is not the expected", true, actual_result);
	  solo.sleep(2000);
  }
  
  public void testFormViewMethod() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/show_method.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Show method", 0, true);
	  boolean actual_result=solo.waitForText("post");
	  assertEquals("Number of forms", true, actual_result);
	  solo.clickOnText("OK", 0, true);
	  solo.sleep(2000);

  }
  
  
  public void testFormAlertIdNameValue() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/alert_disable.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Click me!", 0, true);
	  boolean actual_result=solo.waitForText("Id: myButton, type: button, value: Click me");
	  assertEquals("Cannot get Id, type, value information", true, actual_result);
	  solo.clickOnText("OK");
	  solo.sleep(2000);
	  
  }
  public void testFormCheckBox() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/check_uncheck.html");
	  boolean actual_result=false;
	  solo.clickOnWebElement("Check Checkbox", 0, true);
	  solo.sleep(2000);
	  WebElement webelement=solo.getCurrentWebElements(new By.CheckBox("myCheck")).get(0);
	  if(webelement.getvalue().equals("true")){
		  actual_result=true;
		  Log.e(webelement.getvalue(),"value1");
	  }
	  assertEquals("The check box is not checked",actual_result,true);
	  solo.sleep(3000);
	  solo.clickOnWebElement("Uncheck Checkbox", 0, true);
	  solo.sleep(2000);
	 
  }
  public void testFormDropDown() throws Exception {
	  boolean actual_result=false;
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.Id("myList"));
	  solo.sleep(3000);
	  solo.clickOnText("Netscape");
	  solo.sleep(3000);
	  for(WebElement web:solo.getCurrentWebElements()){
		  if(web.getId().equals("favorite"))
			  if(web.getvalue().equals("Netscape"))
				  actual_result=true;	  
		  }
	  assertEquals("The check box is not checked",actual_result,true);
	  solo.sleep(2000);


	 
  }
  
  public void testDomFormResetForm() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/reset.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Name("name"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Name("age"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement("Reset", 0, true);
	  solo.sleep(4000);
	  boolean actual_result = false;
	  boolean actual_result_age = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  Log.e(web.getName()+"/"+web.getvalue(), "value1");
	  if(web.getName().equals("name")&&web.getvalue() ==null){
			actual_result=true;
	    }
	  if(web.getName().equals("age")&&web.getvalue() == null){
				actual_result_age=true;
	  }
		}
	  if(actual_result&actual_result_age)
		  actual_result = true;
	  assertEquals("Cannot reset form", true, actual_result);
	  solo.sleep(2000);
  }
  
  public void testDomFormAnotherDropDown() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown2.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.Id("no"));
	  solo.sleep(2000);
	  solo.clickOnText("1");
	  solo.sleep(2000);
	  solo.clickOnWebElement("-->", 0, true);
	  solo.sleep(3000);
	  boolean actual_result = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  if(web.getId().equals("result")&&web.getvalue().equals("1"))
			  actual_result = true;

	  }
	  assertEquals("Cannot get Id, type, value information", true, actual_result);
  }
  public void testDomFormValidateForm() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/validate.html");
	  solo.sleep(3000);
	  boolean actual_result = false;
	  solo.clickOnWebElement("Submit", 0, true);
	  solo.sleep(3000);
	  actual_result = solo.waitForText("The age must be a number between 1 and 100");
	  solo.clickOnText("OK");
	  actual_result = solo.waitForText("Not a valid e-mail!");
	  solo.clickOnText("OK");
	  solo.enterTextInWebElement(new By.Id("fname"), "aaa");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("age"), "12");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("email"), "aaa@gmail.com");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Submit", 0, true);
	  actual_result = solo.waitForText("our input has been submitted");
	  assertEquals("Submit false", true, actual_result);
	  
  }
  public void testDomFormSelectText() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/select_text.html");
	  solo.sleep(3000);
	  boolean actual_result = false;
	  solo.takeScreenshot("slectedtext");
	  solo.clickOnWebElement("Select text", 0, true);
	  solo.sleep(3000);
	  solo.takeScreenshot("slectedtext01");
	  solo.sleep(3000);
	  actual_result = solo.imageCompare("slectedtext.jpg", "slectedtext01.jpg", 0, 0, 95);
	  assertEquals("Submit false", false, actual_result);
	  
  }
  
  public void testDomFormSubmitForm() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/submit.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Name("firstname"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Name("lastname"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement("Submit", 0, true);
	  solo.sleep(2000);
	  boolean actual_result=webview.getUrl().equals("http://123.71.192.55:8001/Browser/DOM/form/js_form_action.php?firstname=aaa&lastname=bbb");
	  solo.sleep(2000);
	  assertEquals("Current URL is wrong ", true, actual_result);
	  solo.sleep(2000);
  }
  
  public void testDomFormCheckBox() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/checkbox.html");
	  solo.sleep(3000);
	  solo.enterTextInWebElement(new By.Id("fname"), "aaa");
	  solo.sleep(2000);
	  solo.enterTextInWebElement(new By.Id("lname"), "bbb");
	  solo.sleep(2000);
	  solo.clickOnWebElement(new By.Name("checkbox"));
	  solo.sleep(4000);
	  boolean actual_result = false;
	  for(WebElement web:solo.getCurrentWebElements()){
		if(web.getId().equals("fname")&&web.getvalue().equals("AAA")){
			actual_result=true;
			 }
		  else if(web.getId().equals("lname")&&web.getvalue().equals("BBB"))
				  actual_result=true;
	   }
	  assertEquals("Convert to upper false", true, actual_result);
	  
  }
  
  public void testDomFormSelectDropDownlist() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/dropdown_menu.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.Id("menu"));
	  solo.sleep(2000);
	  solo.clickOnText("Sina");
	  solo.sleep(3000);
	  boolean actual_result = webview.getUrl().equals("http://sina.cn/");
	  assertEquals("Convert to upper false", true, actual_result);
	  solo.sleep(3000);
	  
  }
  
  public void testDomFormCheckboxInForm() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/checkbox_in_form.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("cream", 0, true);
	  solo.sleep(3000);
	  solo.clickOnWebElement("sugar", 0, true);
	  solo.sleep(3000);
	  solo.clickOnWebElement("Send order",0,true);
	  solo.sleep(3000);
	  boolean actual_result=false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  if(web.getId().equals("order"))
			  if(web.getvalue().equals("You ordered a coffee with cream sugar "))
				  actual_result=true;
			  
	  }
	  assertEquals("Convert to upper false", true, actual_result);
	  
  }
  
  
  public void testDomFormRadioButton() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/radio.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Internet Explorer", 0, true);
	  solo.sleep(3000);
	  boolean actual_result=false;
	  for(WebElement web:solo.getCurrentWebElements()){
		  if(web.getId().equals("answer"))
			  if(web.getvalue().equals("Internet Explorer"))
				  actual_result=true;
			  
	  }
	  assertEquals("Convert to upper false", true, actual_result);
	  
  }
  
  public void testDomFrameChangeSourceOfTwoFrame() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/image/source.html");
	  solo.sleep(3000);
	  for(WebElement web:solo.getCurrentWebElements()){
		  Log.e(web.getTagName()+"/"+web.getText(), "value2");
			  
	  }
	  
  }
  public void testDomImageChangeImageHeightAndWidth() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/image/height_width.html");
	  solo.sleep(3000);
	  WebElement webelement=solo.getCurrentWebElements(new By.TagName("INPUT")).get(0);
	  int xpath=webelement.getLocationX();
	  int ypath=webelement.getLocationY();
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  boolean actual_result=false;
	  for(WebElement web:solo.getCurrentWebElements(new By.TagName("INPUT"))){
		  if(web.getLocationX()!=xpath&&web.getLocationY()!=ypath){
			  actual_result=true; 
		  }
		  Log.e(web.getTagName()+"/"+web.getText(), "value2");
			  
	  }
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  public void testDomFrameScroll() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/scroll.html");
	  solo.sleep(3000);
	  //solo.clickOnWebElement(new By.GetFrameItem("leftFrame", "INPUT"));
	  for(WebElement web:solo.getCurrentWebElements(new By.GetFrameItem("leftFrame","INPUT"))){
		  Log.e(web.getTagName()+"/"+web.getText(), "value2");
		  if(web.getvalue().equals("Scroll bars")){
			  solo.clickOnScreen(web.getLocationX(), web.getLocationY());
			  solo.sleep(3000);
		  
		  }
		  else
			  Log.e("Not found web item", "Webtest");
	  }
  }
  public void testDomFrameChangeSrc() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/source.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.GetFrameItem("leftFrame","INPUT"));
	  solo.sleep(20000);
	  boolean actual_result=false;
	  Log.e("test", "value2");
	  String src = solo.getCurrentWebElements().get(0).getText();
      Log.e(src,"value2");
      Log.e("test1", "value2");
	  
  }
  
  public void testDomFrameBreakOut() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/breakout.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("breakout");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.GetFrameItem("leftFrame","INPUT"), 0);
	  solo.sleep(3000);
	  solo.takeScreenshot("breakout01");
	  solo.sleep(3000);
	  boolean actual_result=true;
	  actual_result = solo.imageCompare("breakout.jpg", "breakout01.jpg",150,300,95);
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);

	  
  }
  
  public void testDomFrameUpdateTwoFrame() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/frame/iframe_source.html");
	  solo.sleep(3000);
	  //solo.clickOnFrameWebElement(new By.GetFrameItem("leftFrame"), 0);
	 // solo.sleep(3000);new By.GetFrameItem("leftFrame")
	  solo.clickOnWebElement("Change source of the two iframes", 0, true);
	  solo.sleep(3000);
	  boolean actual_result=false;
	  for(WebElement web:solo.getCurrentWebElements(new By.GetFrameItem("frame1","H3"))){
		  Log.e(web.getTagName()+"/"+web.getText(), "value2");
		  if(web.getText().equals("Frame C"))
			  actual_result=true;
	  }
	  assertEquals("Convert to upper false", true, actual_result);
	  
  }
  
  public void testcompareImage() throws Exception {
	 //solo.takeScreenshot("d");
	 boolean actual_result = solo.imageCompare("c.jpg","a.jpg",0,0,30);
	 assertEquals("Convert to upper false", true, actual_result);
  }
  
  
  public void tesDomLinkCharest() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/charset.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Charset=ISO-8859-1");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  public void testDomLinkDisableStyle() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/disable.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("linkDisable");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("linkDisable01");
      solo.sleep(3000);
      boolean actual_result = solo.imageCompare("linkDisable.jpg", "linkDisable01.jpg", 0, 0, 80);
      solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
  }
  
  public void testDomLinkHref() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/href.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkHref");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkHref01");
      solo.sleep(3000);
      boolean actual_result = solo.imageCompare("LinkHref.jpg", "LinkHref01.jpg", 0, 0, 80);
      solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
	  
  }
  
  public void testDomLinkHrefLang() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/hreflang.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Language code=us-en");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  public void testDomLinkID() throws Exception{
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/id.html");
	  solo.sleep(3000);
	  boolean actual_result=solo.waitForText("Id of link=style1");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  
  public void testDomLinkMedia() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/media.html");
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkMedia");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  solo.takeScreenshot("LinkMedia01");
      solo.sleep(3000);
      boolean actual_result = solo.imageCompare("LinkMedia.jpg", "LinkMedia01.jpg", 0, 0, 80);
      solo.sleep(3000);
	  assertEquals("Convert to upper false", false, actual_result);
  }
  
  public void testDomLinkAlertID() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/name.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement(new By.TagName("INPUT"));
	  solo.sleep(3000);
	  boolean actual_result = solo.waitForText("undefined");
	  solo.clickOnText("OK");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
	  
  }
  
  public void testDomLinkRel() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/rel.html");
	  boolean actual_result=solo.waitForText("Relationship: stylesheet");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  public void testDomLinkType() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/link/type.html");
	  boolean actual_result=solo.waitForText("MIME type: text/css");
	  solo.sleep(3000);
	  assertEquals("Convert to upper false", true, actual_result);
  }
  
  
  public void testDomLocationSendToNew() throws Exception {
	  webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/location/change.html");
	  solo.sleep(3000);
	  solo.clickOnWebElement("Show current URL", 0, true);
	  solo.sleep(3000);
	  boolean actual_result=false;
	  actual_result=solo.waitForText("http://123.71.192.55:8001/Browser/DOM/location/change.html");                                                                                                                                                                                                                                                                  
	  solo.sleep(3000);
	  solo.clickOnText("OK");
	  solo.sleep(2000);
	  solo.clickOnWebElement("Change URL", 0, true);
	  solo.sleep(3000);
	  if(webview.getUrl().equals("http://wap.yahoo.com"))
		  actual_result=true;
	 else
		 actual_result=false;
	 //assertEquals("Curren url is wrong", true, actual_result);
  }
  
  
  
/*  
  public void testDomChangeImage() throws Exception{
	   //ArrayList<WebView> webView = solo.getCurrentViews(WebView.class);
	  // webView.get(0).loadUrl("http://123.71.192.55:8001/Browser/DOM/image/source.html");
	   webview.loadUrl("http://123.71.192.55:8001/Browser/DOM/form/change_action.html");
	   solo.sleep(3000);
	   solo.clickOnWebElement("Change image", 0, true);
	   solo.sleep(3000);
	   //boolean actual_result=solo.waitForText("This is a header");
	   //solo.sleep(2000);
	   //assertEquals("Sohu doesn't displayed", true, actual_result);
}*/
  
	public void tearDown()throws Exception{
		try {
			solo.finalize();
			solo.finishOpenedActivities();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		//this.getActivity().finish();
		super.tearDown();
		
	}
 
   
}
	

	
