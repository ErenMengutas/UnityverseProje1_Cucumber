package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.TestOtomasyonuPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestotomasyonStepdefinitions {

    TestOtomasyonuPage testOtomasyonuPage=new TestOtomasyonuPage();
    Faker faker=new Faker();
    String fakeName;
    String fakeLastname;
    String fakeEmail=faker.internet().emailAddress();
    String fakePass=faker.internet().password();
    List<String> aramaKutusuKategoriElemanlariList=new ArrayList<>();
    List<String> anaSayfaKategoriLinkleriList=new ArrayList<>();
    Actions actions=new Actions(Driver.getDriver());
    List<String> mostPopulerKategorilist=new ArrayList<>();


    WebDriverWait wait=new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));

    @Given("Kullanici testOtomasyonu sitesine gider")
    public void kullanici_test_otomasyonu_sitesine_gider() {
        Driver.getDriver().get(ConfigReader.getProperty("toUrl"));

    }
    @When("Sayfaya gittigini dogrular")
    public void sayfaya_gittigini_dogrular() {
        String expectedTitle="Test Otomasyonu";
        String actualTitle=Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @When("Account linkine tiklar")
    public void account_linkine_tiklar() {
        testOtomasyonuPage.toAnaSayfaAccLinki.click();
    }

    @When("Sign up linkine tiklar")
    public void sign_up_linkine_tiklar() {
        testOtomasyonuPage.toLoginSayfasiSignUpButonu.click();
    }
    @When("Register now sayfasında olduğunu doğrular")
    public void register_now_sayfasında_olduğunu_doğrular() {
        Assert.assertTrue(testOtomasyonuPage.registerNowYaziElementi.isDisplayed());
    }

    @When("Kayit sayfasinda ki {int} özelliğin olduğunu test eder \\(firstname, lastname, email, password, confirm password, sign up button)")
    public void kayit_sayfasinda_ki_özelliğin_olduğunu_test_eder_firstname_lastname_email_password_confirm_password_sign_up_button(Integer int1) {
        Assert.assertTrue(testOtomasyonuPage.firtNameButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.lastNameButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.emailAddressButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.passwordButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.confirmPasswordButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.registerSayfasiSignUpButonu.isDisplayed());
    }


    @When("Sayfayi kapatir")
    public void sayfayi_kapatir() {
        Driver.quitDriver();
    }

    @When("Kayit formunu doldurur")
    public void kayit_formunu_doldurur() {
        testOtomasyonuPage.firtNameButonu.sendKeys(faker.name().firstName());
        testOtomasyonuPage.lastNameButonu.sendKeys(faker.name().lastName());
        testOtomasyonuPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuPage.confirmPasswordButonu.sendKeys(fakePass);
    }
    @When("Register sayfasi sign up butonuna basar")
    public void register_sayfasi_sign_up_butonuna_basar() {
        testOtomasyonuPage.registerSayfasiSignUpButonu.click();

    }
    @Then("Basarili kayit yapildigini test eder")
    public void basarili_kayit_yapildigini_test_eder() {
        ReusableMethods.bekle(2);
        testOtomasyonuPage.loginSayfasıEmailButonu.sendKeys(fakeEmail);
        testOtomasyonuPage.loginSayfasıPassButonu.sendKeys(fakePass);
        testOtomasyonuPage.loginSayfasıSigninButonu.click();
        ReusableMethods.bekle(2);
        Assert.assertTrue(testOtomasyonuPage.profilYazıElementi.isDisplayed());
    }

    @When("Gercersiz email girer")
    public void gercersiz_email_girer() {
        fakeEmail=fakeEmail.replace("@","");
        testOtomasyonuPage.firtNameButonu.sendKeys(faker.name().firstName());
        testOtomasyonuPage.lastNameButonu.sendKeys(faker.name().lastName());
        testOtomasyonuPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuPage.confirmPasswordButonu.sendKeys(fakePass);



    }
    @Then("Kayit yapılamadıgını test eder")
    public void kayit_yapılamadıgını_test_eder() {
        ReusableMethods.bekle(2);
      Assert.assertTrue(testOtomasyonuPage.loginSayfasıEmailButonu.isDisplayed());
    }

    @When("Tum bilgileri bos birakir")
    public void tum_bilgileri_bos_birakir() {

    }
    @When("Tum bilgiler icin required uyarisi verildigini dogrular")
    public void tum_bilgiler_icin_required_uyarisi_verildigini_dogrular() {
        Assert.assertTrue(testOtomasyonuPage.firstNameRequiredYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.lastNameRequiredYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.emailAdressRequiredYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.passwordRequiredYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.confirmPasswordRequiredYaziElementi.isDisplayed());
    }
    @When("Kayit yapilamadigi ve Register Now sayfasinda kalindigini test et")
    public void kayit_yapilamadigi_ve_register_now_sayfasinda_kalindigini_test_et() {
       Assert.assertTrue(testOtomasyonuPage.registerNowYaziElementi.isDisplayed());
    }


    @When("Confirm password passworddan farkli girer")
    public void confirm_password_passworddan_farkli_girer() {
        testOtomasyonuPage.firtNameButonu.sendKeys(faker.name().firstName());
        testOtomasyonuPage.lastNameButonu.sendKeys(faker.name().lastName());
        testOtomasyonuPage.emailAddressButonu.sendKeys(fakeEmail);
        testOtomasyonuPage.passwordButonu.sendKeys(fakePass);
        testOtomasyonuPage.confirmPasswordButonu.sendKeys(faker.internet().password());
    }

    @When("Password hatasi verildigi dogrular")
    public void password_hatasi_verildigi_dogrular() {
        Assert.assertTrue((testOtomasyonuPage.confirmPasswordUyariYazisi.isDisplayed()));


    }

    @When("Login now sayfasinda olduğunu test eder")
    public void login_now_sayfasinda_olduğunu_test_eder() {
        String expectedLoginYazisi="Login Now";
        String actualLoginYazisi=testOtomasyonuPage.loginSayfasıLoginNowYaziElementi.getText();
        Assert.assertEquals(actualLoginYazisi,expectedLoginYazisi);
    }

    @When("Email ve password alanlarinin göründüğünü doğrular")
    public void email_ve_password_alanlarinin_göründüğünü_doğrular() {
        Assert.assertTrue(testOtomasyonuPage.loginSayfasıEmailButonu.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.loginSayfasıPassButonu.isDisplayed());
    }
    @When("gecerli email ve password girer")
    public void gecerli_email_ve_password_girer() {

        testOtomasyonuPage.loginSayfasıEmailButonu.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuPage.loginSayfasıPassButonu.sendKeys(ConfigReader.getProperty("gecerliPass"));
    }

    @When("Sign in butonuna tiklar")
    public void sign_in_butonuna_tiklar() {
        testOtomasyonuPage.loginSayfasıSigninButonu.click();
    }

    @When("Login succes yazisinin görünüğünü doğrular")
    public void login_succes_yazisinin_görünüğünü_doğrular() {
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuPage.loginSuccessElementi));
        Assert.assertTrue(testOtomasyonuPage.loginSuccessElementi.isDisplayed());
    }

    @When("Kullanici profilinde oldugunu dogrular")
    public void kullanici_profilinde_oldugunu_dogrular() {
        Assert.assertTrue(testOtomasyonuPage.profilYazıElementi.isDisplayed());
    }

    @Then("Kullanici firstName lastName ve emailin göründügünü dogrular")
    public void kullanici_first_name_last_name_ve_emailin_göründügünü_dogrular() {

        Assert.assertTrue(testOtomasyonuPage.profilFirstNameYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.profilLastNameYaziElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.profilEmailYaziElementi.isDisplayed());
    }

    @When("Kullanici profilinde MyProfile,My Orders,Wishlist,Manage Adress, change password ve Logout butonlarinin gorunebildiğini test eder")
    public void kullanici_profilinde_my_profile_my_orders_wishlist_manage_adress_change_password_ve_logout_butonlarinin_gorunebildiğini_test_eder() {

        Assert.assertTrue(testOtomasyonuPage.myProfileElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.wishListElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.manageAdressElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.changePasswordElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.logoutElementi.isDisplayed());
        Assert.assertTrue(testOtomasyonuPage.myOrderElementi.isDisplayed());

    }

    @When("Electronics kategorisinin kullanilabilir olduğunu test eder")
    public void electronics_kategorisinin_kullanilabilir_olduğunu_test_eder() {

        Assert.assertTrue(testOtomasyonuPage.electronicLinki.isEnabled());

    }
    @When("Electronics linkine tiklar")
    public void electronics_linkine_tiklar() {
        testOtomasyonuPage.electronicLinki.click();
    }

    @When("Sayfa url'sinin '{string}' oldugunu test eder")
    public void sayfa_url_sinin_oldugunu_test_eder(String istenilenUrl) {
        String expectedElectronicUrl=istenilenUrl;
        String actualElectronicUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(expectedElectronicUrl,actualElectronicUrl);


    }
    @When("Acilan sayfanin Electronics bolumu oldugunu test eder")
    public void acilan_sayfanin_electronics_bolumu_oldugunu_test_eder() {
        String expectedElectronicTitle="Test Otomasyonu - Electronics";
        String actualElectronicTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedElectronicTitle,actualElectronicTitle);
    }
    @When("Sayfada Men Fashion kategorisinin kullanılabilir oldugunu test eder")
    public void sayfada_men_fashion_kategorisinin_kullanılabilir_oldugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.menFashionLinki.isEnabled());
    }

    @Then("Men Fashion kategorisine tiklar")
    public void men_fashion_kategorisine_tiklar() {
        testOtomasyonuPage.menFashionLinki.click();
    }

    @When("Acilan sayfanin Men Fashion bolumu oldugunu test eder")
    public void acilan_sayfanin_men_fashion_bolumu_oldugunu_test_eder() {

        String expectedMenFashionTitle="Test Otomasyonu - Men Fashion";
        String actualMenFashionTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedMenFashionTitle,actualMenFashionTitle);
    }


    @When("Sayfada Women Fashion kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_women_fashion_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.womenFashionLinki.isEnabled());
    }
    @Then("Women Fashion kategorisine tiklar")
    public void women_fashion_kategorisine_tiklar() {

        testOtomasyonuPage.womenFashionLinki.click();
    }

    @When("Acilan sayfanin Women Fashion bolumu oldugunu test eder")
    public void acilan_sayfanin_women_fashion_bolumu_oldugunu_test_eder() {
        String expectedWomenFashionTitle="Test Otomasyonu - Women Fashion";
        String actualWomenFashionTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedWomenFashionTitle,actualWomenFashionTitle);
    }

    @When("Sayfada Shoes kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_shoes_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.shoesLinki.isEnabled());
    }
    @When("Shoes kategorisine tiklar")
    public void shoes_kategorisine_tiklar() {
        testOtomasyonuPage.shoesLinki.click();
    }
    @When("Acilan sayfanin Shoes bolumu oldugunu test eder")
    public void acilan_sayfanin_shoes_bolumu_oldugunu_test_eder() {

        String expectedShoesTitle="Test Otomasyonu - Shoes";
        String actualShoesTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedShoesTitle,actualShoesTitle);
    }

    @When("Sayfada Furniture kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_furniture_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.furnitureLinki.isEnabled());
    }
    @When("Furniture kategorisine tiklar")
    public void furniture_kategorisine_tiklar() {

        testOtomasyonuPage.furnitureLinki.click();
    }
    @When("Acilan sayfanin Furniture bolumu oldugunu test eder")
    public void acilan_sayfanin_furniture_bolumu_oldugunu_test_eder() {

        String expectedFurnitureTitle="Test Otomasyonu - Furniture";
        String actualFurnitureTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedFurnitureTitle,actualFurnitureTitle);
    }

    @When("Sayfada Travel kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_travel_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.travelLinki.isEnabled());
    }

    @When("Travel kategorisine tiklar")
    public void travel_kategorisine_tiklar() {
        testOtomasyonuPage.travelLinki.click();

    }
    @When("Acilan sayfanin Travel bolumu oldugunu test eder")
    public void acilan_sayfanin_travel_bolumu_oldugunu_test_eder() {

        Assert.assertTrue(testOtomasyonuPage.travelLinki.isEnabled());
    }
    @When("Sayfada Kids Wear kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_kids_wear_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.kidsWearLinki.isEnabled());
    }
    @When("Kids Wear kategorisine tiklar")
    public void kids_wear_kategorisine_tiklar() {
        testOtomasyonuPage.kidsWearLinki.click();
    }
    @When("Acilan sayfanin Kids Wear bolumu oldugunu test eder")
    public void acilan_sayfanin_kids_wear_bolumu_oldugunu_test_eder() {
        String expectedKidsWearTitle="Test Otomasyonu - Kids Wear";
        String actualKidsWearTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedKidsWearTitle,actualKidsWearTitle);

    }
    @When("Sayfada Grocery kategorisinin kullanilabilir olduğunu test eder")
    public void sayfada_grocery_kategorisinin_kullanilabilir_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.groceryLinki.isEnabled());
    }
    @When("Grocery kategorisine tiklar")
    public void grocery_kategorisine_tiklar() {
        testOtomasyonuPage.groceryLinki.click();
    }
    @When("Acilan sayfanin Grocery bolumu oldugunu test eder")
    public void acilan_sayfanin_grocery_bolumu_oldugunu_test_eder() {
        String expectedGroceryTitle="Test Otomasyonu - Grocery";
        String actualGroceryTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedGroceryTitle,actualGroceryTitle);
    }






    @When("Arama kutusundaki Select Category butonunun gorunurlugunu test eder")
    public void arama_kutusundaki_select_category_butonunun_gorunurlugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.aramaKutusuKategoriButonu.isDisplayed());
    }
    @When("Select Category butonuna tiklar")
    public void select_category_butonuna_tiklar() {
        testOtomasyonuPage.aramaKutusuKategoriButonu.click();
    }
    @When("Kategori listesinin gorunur oldugunu test eeder")
    public void kategori_listesinin_gorunur_oldugunu_test_eeder() {
        Assert.assertTrue(testOtomasyonuPage.aramaKutusuDropDownMenu.isDisplayed());

    }
    @When("Kategori listesindeki isimleri liste olarak kaydeder")
    public void kategori_listesindeki_isimleri_liste_olarak_kaydeder() {


        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuElectronicsElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuMenFashionElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuWomenFashionElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuShoesElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuFurnitureElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuTravelElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuKidsWearElementi.getText());
        aramaKutusuKategoriElemanlariList.add(testOtomasyonuPage.aramaKutusuGroceryElementi.getText());
    }
    @When("Anasayfa kategori listesi ile Arama kutusu kategori listesi uzunluklarinin ayni oldugunu dogrular")
    public void anasayfa_kategori_listesi_ile_arama_kutusu_kategori_listesi_uzunluklarinin_ayni_oldugunu_dogrular()
    {

        Assert.assertEquals(anaSayfaKategoriLinkleriList.size(),aramaKutusuKategoriElemanlariList.size());
    }


    @When("Anasayfada kategorilerin gorunurlugunu test eder ve liste olarak kaydeder")
    public void anasayfada_kategorilerin_gorunurlugunu_test_eder_ve_liste_olarak_kaydeder() {


        boolean anaSayfaKategorilinkleri=false;


        for (WebElement each: testOtomasyonuPage.anasayfaKategoriList)
        {
            if (each.isDisplayed())
            {
                anaSayfaKategoriLinkleriList.add(each.getText());
                anaSayfaKategorilinkleri=true;
            }
        }

        Assert.assertTrue(anaSayfaKategorilinkleri);


    }


    @When("Anasayfa kategori listesindeki Electronics,Men Fashion,Women Fashion,Shoes,Furniture,Travel,Kids Wear,Grocery kategorisinin Arama kutusu kategori listesinde oldugunu dogrular")
    public void anasayfaKategoriListesindekiElectronicsMenFashionWomenFashionShoesFurnitureTravelKidsWearGroceryKategorisininAramaKutusuKategoriListesindeOldugunuDogrular()
    {
        Collections.sort(anaSayfaKategoriLinkleriList);
        Collections.sort(aramaKutusuKategoriElemanlariList);
        Assert.assertTrue(anaSayfaKategoriLinkleriList.containsAll(aramaKutusuKategoriElemanlariList));
    }

    @When("Ana sayfada Most Popular Products bolumune gider")
    public void ana_sayfada_most_popular_products_bolumune_gider() {
        actions.moveToElement(testOtomasyonuPage.mostPopulerLinki).perform();
    }
    @When("Bolumdeki kategorilerin gorunurlugunu test eder ve isimleri list olarak kaydeder")
    public void bolumdeki_kategorilerin_gorunurlugunu_test_eder_ve_isimleri_list_olarak_kaydeder() {

        boolean mostPopulerKategori=false;

        for (WebElement each: testOtomasyonuPage.mostPopulerKategorliList)
        {
            if (each.isDisplayed())
            {
                mostPopulerKategorilist.add(each.getText());
                mostPopulerKategori=true;
            }

        }
        Assert.assertTrue(mostPopulerKategori);

    }
    @When("Anasayfa kategori listesi ile Most Popular Products kategori listesi uzunluklarinin ayni oldugunu dogrular")
    public void anasayfa_kategori_listesi_ile_most_popular_products_kategori_listesi_uzunluklarinin_ayni_oldugunu_dogrular() {

        Assert.assertEquals(anaSayfaKategoriLinkleriList.size(),mostPopulerKategorilist.size());

    }
    @When("Anasayfa kategori listesindeki Electronics,Men Fashion,Women Fashion,Shoes,Furniture,Travel,Kids Wear,Grocery kategorisinin Most Popular Products listesinde oldugunu dogrular")
    public void anasayfa_kategori_listesindeki_electronics_men_fashion_women_fashion_shoes_furniture_travel_kids_wear_grocery_kategorisinin_most_popular_products_listesinde_oldugunu_dogrular() {
        Collections.sort(mostPopulerKategorilist);
        Collections.sort(anaSayfaKategoriLinkleriList);
        Assert.assertTrue(anaSayfaKategoriLinkleriList.containsAll(mostPopulerKategorilist));

    }

    @Then("Selling Products bölümünün görünür olduğunu test eder")
    public void selling_products_bölümünün_görünür_olduğunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.topSellingProducts.isDisplayed());
    }
    @When("Top Selling Products bölümüne gider")
    public void top_selling_products_bölümüne_gider() {
        actions.moveToElement(testOtomasyonuPage.topSellingProducts).perform();
    }

    @When("Rastgele {int} ürün seçer ve sepete ekler")
    public void rastgele_ürün_seçer_ve_sepete_ekler(Integer int1) {
        List<WebElement> topSellingList=new ArrayList<>();

        for (WebElement each:testOtomasyonuPage.topSellinUrunElementleriList)
        {
            topSellingList.add(each);

        }

        for (int i = 0; i <3 ; i++)
        {
            int randomNum=faker.number().numberBetween(0,16);

            actions.moveToElement(topSellingList.get(randomNum)).perform();

            topSellingList.get(randomNum).click();
            testOtomasyonuPage.addToCart.click();
            Driver.getDriver().navigate().back();

        }
    }

    @When("Sepete gider")
    public void sepete_gider() {

        ReusableMethods.click(testOtomasyonuPage.yourCartButonu);

    }
    @When("Sepete ürün eklendiğini test eder")
    public void sepete_ürün_eklendiğini_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.continueButonu.isDisplayed());
    }


    @And("{int} saniye bekler")
    public void saniyeBekler(int sayi) {
        ReusableMethods.bekle(sayi);
    }

    @When("Top Selling Products bolumune gider")
    public void top_selling_products_bolumune_gider() {

        actions.moveToElement(testOtomasyonuPage.topSellingProducts).perform();
        Assert.assertTrue(testOtomasyonuPage.topSellingProducts.isDisplayed());
    }
    @When("View All Products butonunun tiklanabilirligini test eder")
    public void view_all_products_butonunun_tiklanabilirligini_test_eder() {

       Assert.assertTrue(testOtomasyonuPage.topSellingProductsViewAll.isDisplayed());

    }
    @When("View All Products butonuna tiklar")
    public void view_all_products_butonuna_tiklar() {
        testOtomasyonuPage.topSellingProductsViewAll.click();
    }

    @When("Kategoride {int}'dan fazla urun bulundugunu dogrular")
    public void kategoride_dan_fazla_urun_bulundugunu_dogrular(Integer int1) {

        List<WebElement> ürünListesi=new ArrayList<>();

        for (WebElement each:testOtomasyonuPage.topSellinUrunElementleriList)
        {
            ürünListesi.add(each);

        }

        Assert.assertTrue(ürünListesi.size()>0);
    }
    @When("Listedeki ilk urunun uzerine gider")
    public void listedeki_ilk_urunun_uzerine_gider() {

        actions.moveToElement(testOtomasyonuPage.topSellingIlkUrun).perform();

    }
    @When("Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonunun tiklanabilirligini test eder")
    public void urun_kutusunun_uzerinde_dururken_gorunur_olan_add_to_cart_butonunun_tiklanabilirligini_test_eder() {

        Assert.assertTrue(testOtomasyonuPage.urunUzerindekiSepeteEklemeButonu.isEnabled());
    }

    @When("Add to cart butonuna tiklar")
    public void add_to_cart_butonuna_tiklar() {
        testOtomasyonuPage.urunUzerindekiSepeteEklemeButonu.click();
    }
    @When("Product Added To Cart! Yazisinin ciktigini dogrular")
    public void product_added_to_cart_yazisinin_ciktigini_dogrular() {
        wait.until(ExpectedConditions.visibilityOf(testOtomasyonuPage.productAddedToCartYazıElementi));
        Assert.assertTrue(testOtomasyonuPage.productAddedToCartYazıElementi.isDisplayed());
    }
    @When("Your Cart butonunun gorunurlugunu test eder")
    public void your_cart_butonunun_gorunurlugunu_test_eder() {
        ReusableMethods.bekle(1);
        Assert.assertTrue(testOtomasyonuPage.yourCartButonu.isDisplayed());
    }
    @When("Your Cart butonunun sayisininin {int} oldugunu dogrular")
    public void your_cart_butonunun_sayisininin_oldugunu_dogrular(Integer sayi) {
        String istenenSayi=Integer.toString(sayi);
        Assert.assertEquals(testOtomasyonuPage.addCartüzerindekiSayiElementi.getText(),(istenenSayi));
    }
    @When("Your cart butonuna tiklar")
    public void your_cart_butonuna_tiklar() {
        ReusableMethods.click(testOtomasyonuPage.yourCartButonu);

    }
    @When("Sepette urun bulundugunu test eder")
    public void sepette_urun_bulundugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.continueButonu.isDisplayed());
    }
    @When("Sepetteki   urunun isminin listede eklenen urunun ismi ile ayni oldugunu test eder")
    public void sepetteki_urunun_isminin_listede_eklenen_urunun_ismi_ile_ayni_oldugunu_test_eder() {
        Assert.assertEquals(testOtomasyonuPage.trendingIlkUrunYaziElementi, testOtomasyonuPage.sepettekiIlkurunYaziElementi);

    }

    @When("Urun kutusunun kosesindeki X butonunun tiklanabilirligini test eder")
    public void urun_kutusunun_kosesindeki_x_butonunun_tiklanabilirligini_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.sepettekiUrunIptalButonu.isDisplayed());
    }
    @When("X butonuna tiklar")
    public void x_butonuna_tiklar() {
        testOtomasyonuPage.sepettekiUrunIptalButonu.click();

    }
    @When("Are you sure penceresinin acildigini dogrular")
    public void are_you_sure_penceresinin_acildigini_dogrular() {
        Assert.assertTrue(testOtomasyonuPage.areYouSureYaziElementi.isDisplayed());

    }
    @When("Yes, remove it! Butonuna tiklar")
    public void yes_remove_it_butonuna_tiklar() {
        testOtomasyonuPage.yesRemoveButonu.click();
    }

    @When("Shopping cart is empty yazisi gorunur oldugunu test eder")
    public void shopping_cart_is_empty_yazisi_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.shoppingCartIsEmpty.isDisplayed());

    }


    @When("Wait for it... Yazisi kaybolana kadar bekler")
    public void waitForItYazisiKaybolanaKadarBekler() {
        wait.until(ExpectedConditions.invisibilityOf(testOtomasyonuPage.waitForItYaziElementi));

    }

    @When("View all Products bölümüne tıklar")
    public void viewAllProductsBölümüneTıklar() {
        testOtomasyonuPage.topSellingProductsViewAll.click();
    }

    @When("Arama kutusunun gorünür oldugunu test eder")
    public void arama_kutusunun_gorünür_oldugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.aramaKutusu.isDisplayed());
    }



    @When("{int}'dan fazla urun bulundugunu dogrular")
    public void dan_fazla_urun_bulundugunu_dogrular(Integer int1) {
        List<String> bulunanUrunList=new ArrayList<>();
        for (WebElement each:testOtomasyonuPage.bulunanUrunListesi)
        {
            bulunanUrunList.add(each.getText());
        }

        Assert.assertTrue(bulunanUrunList.size()>0);


    }
    @When("ilk urune tiklar")
    public void ilk_urune_tiklar() {

        testOtomasyonuPage.bulunanIlkUrunElementi.click();
    }

    @When("Sayfa url'sinin {string} icerdigini test eder")
    public void sayfa_url_sinin_icerdigini_test_eder(String expectedurl) {
        String expectedProductUrl=expectedurl;
        String actualProductUrl=Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualProductUrl.contains(expectedProductUrl));
    }
    @When("Miktar kutusunun gorunurlugunu dogrular")
    public void miktar_kutusunun_gorunurlugunu_dogrular() {
        Assert.assertTrue(testOtomasyonuPage.urunMiktarKutusu.isDisplayed());
    }



    @When("Urun miktarinin {int} oldugunu test eder")
    public void urun_miktarinin_oldugunu_test_eder(Integer int1) {
        Assert.assertEquals(testOtomasyonuPage.sepettekiUrunMiktari.getAttribute("value"),"3");
    }


    @When("Arama kutusuna {string} yazar ve Enter'a basar")
    public void aramaKutusunaYazarVeEnterABasar(String aranacakKelime) {
        testOtomasyonuPage.aramaKutusu.sendKeys(ConfigReader.getProperty("aranacakKelime")+Keys.ENTER);

    }

    @When("Miktar kutusunda + butonuna {int} kere basar")
    public void miktarKutusundaButonunaKereBasar(int arg0) {
        testOtomasyonuPage.urunMiktarArttırmaButonu.click();
        testOtomasyonuPage.urunMiktarArttırmaButonu.click();
    }

    @When("Phone sayfasında Add to cart butonuna tiklar")
    public void phoneSayfasındaAddToCartButonunaTiklar() {
        testOtomasyonuPage.addToCart.click();
    }

    @When("Phone Your Cart butonunun sayisininin {int} oldugunu dogrular")
    public void phoneYourCartButonununSayisinininOldugunuDogrular(int sayi) {
        String expectedSayi=Integer.toString(sayi);
        Assert.assertEquals(testOtomasyonuPage.addCartüzerindekiSayiElementi.getText(),(expectedSayi));

    }

    @When("Checkout butonuna tiklar")
    public void checkout_butonuna_tiklar() {
        testOtomasyonuPage.checkoutButonu.click();

    }
    @When("Billing Address gorunurlugunu test eder")
    public void billing_address_gorunurlugunu_test_eder() {
        testOtomasyonuPage.billingAddressButonu.isDisplayed();
    }

    @When("Name, address, address {int}, city, postcode, ülke ve sehir bilgilerini doldurur")
    public void name_address_address_city_postcode_ülke_ve_sehir_bilgilerini_doldurur(Integer int1) {
        testOtomasyonuPage.addAddressName.sendKeys(ConfigReader.getProperty("addAddresName"));
        testOtomasyonuPage.addAddressEmail.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuPage.addAddressPhone.sendKeys(ConfigReader.getProperty("addAddressPhone"));
        testOtomasyonuPage.addAddres.sendKeys(ConfigReader.getProperty("addAddressAddress"));
        Select selectCountry=new Select(testOtomasyonuPage.addAddresSelectCountry);
        selectCountry.selectByIndex(faker.number().numberBetween(1,9));
        Select selecetState=new Select(testOtomasyonuPage.addAddresSelectCountry);
        selecetState.selectByIndex(faker.number().numberBetween(1,9));
        testOtomasyonuPage.addAddresCity.sendKeys(ConfigReader.getProperty("addAddressCity"));
        testOtomasyonuPage.addAddresPostCode.sendKeys(ConfigReader.getProperty("addAddressZipCode"));
        ReusableMethods.bekle(1);
    }
    @When("Billing Address listesinde adres bulundugunu test eder")
    public void billing_address_listesinde_adres_bulundugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.addressBox.isDisplayed());
    }
    @When("Billing Address listesinde adres secer")
    public void billing_address_listesinde_adres_secer() {
        testOtomasyonuPage.addresSecmeButonu.click();
    }
    @When("Delivery address same as billing address kutucuguna tiklar")
    public void delivery_address_same_as_billing_address_kutucuguna_tiklar() {
        ReusableMethods.bekle(2);
        testOtomasyonuPage.deliveryaddressButonu.click();

    }


    @When("Delivery Address bolumunun gorunur olmadigini test eder")
    public void delivery_address_bolumunun_gorunur_olmadigini_test_eder() {
        ReusableMethods.bekle(1);
        Assert.assertFalse(testOtomasyonuPage.deliveryAddressYazisi.isDisplayed());

    }
    @When("Delivery address same as billing address kutucugunu unchecked yapar")
    public void delivery_address_same_as_billing_address_kutucugunu_unchecked_yapar() {
        testOtomasyonuPage.deliveryaddressButonu.click();
    }
    @When("Delivery Address bolumunun gorunur oldugunu test eder")
    public void delivery_address_bolumunun_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.deliveryAddressYazisi.isDisplayed());
    }
    @When("Name, address, address {int}, city, postcode, ülke ve sehir bilgilerini doldur")
    public void name_address_address_city_postcode_ülke_ve_sehir_bilgilerini_doldur(Integer int1) {

        Select selectCountry=new Select(testOtomasyonuPage.addAddresSelectCountry);
        Select selecetState=new Select(testOtomasyonuPage.addAddresSelectCountry);

        testOtomasyonuPage.addAddressName.sendKeys(ConfigReader.getProperty("addAddresName"));
        testOtomasyonuPage.addAddressEmail.sendKeys(ConfigReader.getProperty("gecerliEmail"));
        testOtomasyonuPage.addAddressPhone.sendKeys(ConfigReader.getProperty("addAddressPhone"));
        testOtomasyonuPage.addAddres.sendKeys(ConfigReader.getProperty("addAddressAddress"));
        selectCountry.selectByIndex(faker.number().numberBetween(1,9));
        selecetState.selectByIndex(faker.number().numberBetween(1,9));
        testOtomasyonuPage.addAddresCity.sendKeys(ConfigReader.getProperty("addAddressCity"));
        testOtomasyonuPage.addAddresPostCode.sendKeys(ConfigReader.getProperty("addAddressZipCode"));
        ReusableMethods.bekle(1);


    }
    @When("Delivery Address listesinde adres bulundugunu test eder")
    public void delivery_address_listesinde_adres_bulundugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.deliveryAddressBox.isDisplayed());
    }
    @When("Delivery Address listesinde adres secer")
    public void delivery_address_listesinde_adres_secer() {
        testOtomasyonuPage.deliveryAddresCheckbox.click();

    }
    @When("Shipping Methods listesinden kargo secer")
    public void shipping_methods_listesinden_kargo_secer() {
        actions.moveToElement(testOtomasyonuPage.shippingMethodsFree).perform();
        testOtomasyonuPage.shippingMethodsFree.click();

    }
    @When("Terms and Conditions boxini checkler")
    public void terms_and_conditions_boxini_checkler() {

        testOtomasyonuPage.termAndCondition.click();
    }
    @When("Place Order Now butonuna tiklar")
    public void place_order_now_butonuna_tiklar() {

        testOtomasyonuPage.placeOrderNow.click();

    }
    @When("Your order is successfully done! Yazisinin gorunur oldugunu test eder")
    public void your_order_is_successfully_done_yazisinin_gorunur_oldugunu_test_eder() {
        Assert.assertTrue(testOtomasyonuPage.youOrderYaziElementi.isDisplayed());

    }


    @When("Delivery  Add Address butonuna tiklar")
    public void deliveryAddAddressButonunaTiklar() {
        testOtomasyonuPage.deliveriAddAdress.click();
    }

    @When("Form Add Address butonuna tiklar")
    public void formAddAddressButonunaTiklar() {
        testOtomasyonuPage.addAddressConfirmButonu.click();

    }

    @When("Billing Add Address butonuna tiklar")
    public void billingAddAddressButonunaTiklar() {
        testOtomasyonuPage.bilAddAddressButonu.click();
    }
}













