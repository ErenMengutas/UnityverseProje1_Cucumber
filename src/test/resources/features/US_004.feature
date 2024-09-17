Feature:US_004 Sepete ürün ekleme scenariolari


  Scenario:TC_001 Kullanici rastgele sectigi 3 ürünü sepete ekleyebildigini test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    Then Selling Products bölümünün görünür olduğunu test eder
    When  Top Selling Products bölümüne gider
    When  View all Products bölümüne tıklar
    When Rastgele 3 ürün seçer ve sepete ekler
    When Sepete gider
    When Sepete ürün eklendiğini test eder



  Scenario:TC_002 Kullanici sepete ekledigi urunler ile sepet sayfasinda ki gorunen urunlerin ayni oldugunu test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Top Selling Products bolumune gider
    When View All Products butonunun tiklanabilirligini test eder
    When View All Products butonuna tiklar
    Then Sayfa url'sinin ''https://www.testotomasyonu.com/trending/all-products'' oldugunu test eder
    When Kategoride 0'dan fazla urun bulundugunu dogrular
    When Listedeki ilk urunun uzerine gider
    When Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonunun tiklanabilirligini test eder
    When Add to cart butonuna tiklar
    When Product Added To Cart! Yazisinin ciktigini dogrular
    When Your Cart butonunun gorunurlugunu test eder
    When Your Cart butonunun sayisininin 1 oldugunu dogrular
    When Your cart butonuna tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/shoppingCart'' oldugunu test eder
    When Sepette urun bulundugunu test eder
    When Sepetteki   urunun isminin listede eklenen urunun ismi ile ayni oldugunu test eder



  Scenario:TC_003 Kullanici sepet içerisindeki urunleri silebildigini test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Top Selling Products bolumune gider
    When View All Products butonunun tiklanabilirligini test eder
    When View All Products butonuna tiklar
    Then Sayfa url'sinin ''https://www.testotomasyonu.com/trending/all-products'' oldugunu test eder
    When Kategoride 0'dan fazla urun bulundugunu dogrular
    When Listedeki ilk urunun uzerine gider
    When Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonunun tiklanabilirligini test eder
    When Add to cart butonuna tiklar
    When Product Added To Cart! Yazisinin ciktigini dogrular
    When Your Cart butonunun gorunurlugunu test eder
    When Your Cart butonunun sayisininin 1 oldugunu dogrular
    When Your cart butonuna tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/shoppingCart'' oldugunu test eder
    When Sepette urun bulundugunu test eder
    When Urun kutusunun kosesindeki X butonunun tiklanabilirligini test eder
    When  X butonuna tiklar
    When Are you sure penceresinin acildigini dogrular
    When Yes, remove it! Butonuna tiklar
    When Wait for it... Yazisi kaybolana kadar bekler
    When Shopping cart is empty yazisi gorunur oldugunu test eder




  Scenario:TC_004 Kullanici ürün sayfasinda ürünü sepete eklmeden once ayarladigi miktar ile sepette ki miktarin ayni oldugunu test eder
      Given Kullanici testOtomasyonu sitesine gider
      When Sayfaya gittigini dogrular
      When Arama kutusunun gorünür oldugunu test eder
      When Arama kutusuna "aranacakKelime" yazar ve Enter'a basar
      When Sayfa url'sinin ''https://www.testotomasyonu.com/search-product?search=phone&search_category=0'' oldugunu test eder
      When 0'dan fazla urun bulundugunu dogrular
      When  ilk urune tiklar
      When Sayfa url'sinin "https://www.testotomasyonu.com/product/34" icerdigini test eder
      When Miktar kutusunun gorunurlugunu dogrular
      When Miktar kutusunda + butonuna 2 kere basar
      When Phone sayfasında Add to cart butonuna tiklar
      When Product Added To Cart! Yazisinin ciktigini dogrular
      When Your Cart butonunun gorunurlugunu test eder
      When Phone Your Cart butonunun sayisininin 3 oldugunu dogrular
      When Your cart butonuna tiklar
      When Sayfa url'sinin ''https://www.testotomasyonu.com/shoppingCart'' oldugunu test eder
      When Sepette urun bulundugunu test eder
      When Urun miktarinin 3 oldugunu test eder



    @e2e
  Scenario:TC_005 Kullanici sepete ekledigi urunlerin siparisini basarili bir sekilde onaylayanabildigini test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Top Selling Products bolumune gider
    When View All Products butonunun tiklanabilirligini test eder
    When View All Products butonuna tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/trending/all-products'' oldugunu test eder
    When Kategoride 0'dan fazla urun bulundugunu dogrular
    When Listedeki ilk urunun uzerine gider
    When Urun kutusunun uzerinde dururken gorunur olan Add to Cart butonunun tiklanabilirligini test eder
    When Add to cart butonuna tiklar
    When Product Added To Cart! Yazisinin ciktigini dogrular
    When Your Cart butonunun gorunurlugunu test eder
    When Your Cart butonunun sayisininin 1 oldugunu dogrular
    When Your cart butonuna tiklar
    When Sayfa url'sinin ''https://www.testotomasyonu.com/shoppingCart'' oldugunu test eder
    When Sepette urun bulundugunu test eder
    When Checkout butonuna tiklar
    When Billing Address gorunurlugunu test eder
    When Billing Add Address butonuna tiklar
    When Name, address, address 2, city, postcode, ülke ve sehir bilgilerini doldurur
    When Form Add Address butonuna tiklar
    When Billing Address listesinde adres bulundugunu test eder
    When Billing Address listesinde adres secer
    When Delivery address same as billing address kutucuguna tiklar
    When Delivery Address bolumunun gorunur olmadigini test eder
    When Delivery address same as billing address kutucugunu unchecked yapar
    When Delivery Address bolumunun gorunur oldugunu test eder
    When Delivery  Add Address butonuna tiklar
    When Name, address, address 2, city, postcode, ülke ve sehir bilgilerini doldur
    When Form Add Address butonuna tiklar
    When Delivery Address listesinde adres bulundugunu test eder
    When Delivery Address listesinde adres secer
    When Billing Address listesinde adres secer
    When Shipping Methods listesinden kargo secer
    When Terms and Conditions boxini checkler
    When Place Order Now butonuna tiklar
    When Your order is successfully done! Yazisinin gorunur oldugunu test eder



