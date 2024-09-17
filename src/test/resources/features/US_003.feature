Feature:US_003 Ana sayfadaki kategori linkleri doğrulama scenariolari

  Scenario:TC_001 Kullanici kategori linklerine tikladiktan sonra dogrulama yapilabildigini test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Electronics kategorisinin kullanilabilir olduğunu test eder
    When Electronics linkine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/7/products'' oldugunu test eder
    When Acilan sayfanin Electronics bolumu oldugunu test eder
    When Sayfada Men Fashion kategorisinin kullanılabilir oldugunu test eder
    Then Men Fashion kategorisine tiklar
    Then Sayfa url'sinin ''https://www.testotomasyonu.com/category/1/products'' oldugunu test eder
    When Acilan sayfanin Men Fashion bolumu oldugunu test eder
    When Sayfada Women Fashion kategorisinin kullanilabilir olduğunu test eder
    Then Women Fashion kategorisine tiklar
    Then Sayfa url'sinin ''https://www.testotomasyonu.com/category/2/products'' oldugunu test eder
    When Acilan sayfanin Women Fashion bolumu oldugunu test eder
    When Sayfada Shoes kategorisinin kullanilabilir olduğunu test eder
    When Shoes kategorisine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/3/products'' oldugunu test eder
    When Acilan sayfanin Shoes bolumu oldugunu test eder
    When Sayfada Furniture kategorisinin kullanilabilir olduğunu test eder
    When Furniture kategorisine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/8/products'' oldugunu test eder
    When Acilan sayfanin Furniture bolumu oldugunu test eder
    When  Sayfada Travel kategorisinin kullanilabilir olduğunu test eder
    When Travel kategorisine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/5/products'' oldugunu test eder
    When Acilan sayfanin Travel bolumu oldugunu test eder
    When Sayfada Kids Wear kategorisinin kullanilabilir olduğunu test eder
    When Kids Wear kategorisine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/6/products'' oldugunu test eder
    When Acilan sayfanin Kids Wear bolumu oldugunu test eder
    When Sayfada Grocery kategorisinin kullanilabilir olduğunu test eder
    When Grocery kategorisine tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/category/4/products'' oldugunu test eder
    When Acilan sayfanin Grocery bolumu oldugunu test eder



   Scenario:TC_002 Kullanici anasayfada listelenen kategoriler ile arama butonu yanindaki kategori listesi ayni oldugunu test eder
     Given Kullanici testOtomasyonu sitesine gider
     When Sayfaya gittigini dogrular
     When Anasayfada kategorilerin gorunurlugunu test eder ve liste olarak kaydeder
     When Arama kutusundaki Select Category butonunun gorunurlugunu test eder
     When Select Category butonuna tiklar
     When Kategori listesinin gorunur oldugunu test eeder
     When Kategori listesindeki isimleri liste olarak kaydeder
     When Anasayfa kategori listesi ile Arama kutusu kategori listesi uzunluklarinin ayni oldugunu dogrular
     When Anasayfa kategori listesindeki Electronics,Men Fashion,Women Fashion,Shoes,Furniture,Travel,Kids Wear,Grocery kategorisinin Arama kutusu kategori listesinde oldugunu dogrular



  Scenario:TC_003 Kullanici anasayfada listelenen kategoriler ile Most Popular Products bolumundeki kategori listesinin ayni oldugunu test eder
     Given Kullanici testOtomasyonu sitesine gider
     When Sayfaya gittigini dogrular
     When Anasayfada kategorilerin gorunurlugunu test eder ve liste olarak kaydeder
     When Ana sayfada Most Popular Products bolumune gider
     When Bolumdeki kategorilerin gorunurlugunu test eder ve isimleri list olarak kaydeder
     When Anasayfa kategori listesi ile Most Popular Products kategori listesi uzunluklarinin ayni oldugunu dogrular
     When Anasayfa kategori listesindeki Electronics,Men Fashion,Women Fashion,Shoes,Furniture,Travel,Kids Wear,Grocery kategorisinin Most Popular Products listesinde oldugunu dogrular
