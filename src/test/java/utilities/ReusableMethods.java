package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class ReusableMethods {

    public static List<String> stringListeDonustur(List<WebElement> donusturulecekListe){

        List<String> stingListe = new ArrayList<>();


        for (WebElement eachElement : donusturulecekListe
             ) {

            stingListe.add(eachElement.getText());
        }

        return stingListe;

    }

    public static void bekle(int saniye){

        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
            System.out.println("bekletme isleminde sorun olustu");
        }

    }

    public static void windowDegistir(WebDriver driver, String yeniWindowUrl) {

        Set<String> tumWHDleriSeti = driver.getWindowHandles();

        for ( String eachWhd : tumWHDleriSeti
             ) {

            driver.switchTo().window(eachWhd);
            String url = driver.getCurrentUrl();
            if (url.equals(yeniWindowUrl)){
                break;
            }
        }
    }

    public static void tumSayfaScreenshot(WebDriver driver,String screenshotIsmi){

        // 1.adim TakesScreenShot objesi olusturun
        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.screenShoot'i kaydedecegimiz File olusturun

        // raporlara tarih etiketi ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenshotIsmi = screenshotIsmi.replaceAll("\\s","");
        File tumSayfaScreenshot = new File("target/Screenshoots/"+screenshotIsmi+tarihEtiketi+".png");

        // 3.screenshot'i alip gecici bir dosyaya kaydedelim
        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4. gecici dosyayi asil kaydetmek istedigimiz dosyaya kopyalayalim
        try {
            FileUtils.copyFile(geciciDosya,tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void webelementScreenshot(WebElement scrennshotAlinacakWebelement, String screenshotIsmi){
        // 1- screenshot almak istediginiz webelementi locate edin

        // 2- Screenshot'i kaydedecegimiz file'i olusturun

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyyMMdd");
        String tarihEtiketi = ldt.format(format1);

        screenshotIsmi = screenshotIsmi.replaceAll("\\s","");
        File webelementScreenshot = new File("target/Screenshoots/"+screenshotIsmi+tarihEtiketi+".png");

        // 3- webelementi kullanarak screenshot alip, gecici dosyaya kaydedin
        File geciciDosya = scrennshotAlinacakWebelement.getScreenshotAs(OutputType.FILE);

        // 4- gecici dosyayi, asil dosyaya kopyalayin
        try {
            FileUtils.copyFile(geciciDosya,webelementScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/test-raporlari/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

    public static void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
            js.executeScript("arguments[0].click();", element);
        }
    }

    //JS Scroll
    public static void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //JS Sayfa Sonu Scroll
    public static void scrollEnd() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }

    //JS Sayfa Başı Scroll
    public static void scrollHome() {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
    }

    //JS SendKeys
    public static void sendKeysJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].value='" + text + "'", element);
    }

    //JS SetAttributeValue
    public static void setAttributeJS(WebElement element, String text) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].setAttribute('value','" + text + "')", element);
    }

    //JS GetAttributeValue
    public static void getValueByJS(String id, String attributeName) {
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        String attribute_Value = (String) js.executeScript("return document.getElementById('" + id + "')." + attributeName);
        System.out.println("Attribute Value: = " + attribute_Value);
    }


}
