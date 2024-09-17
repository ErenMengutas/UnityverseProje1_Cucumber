Feature: US_001 Kullanici registration scenariolari

  Scenario: TC_001 Kullanici registration sayfasindaki alti ozeliigin oldugunu test eder
            (firstname, lastname, email, password, confirm password, sign up button)

    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Sign up linkine tiklar
    When Register now sayfasında olduğunu doğrular
    When Kayit sayfasinda ki 6 özelliğin olduğunu test eder (firstname, lastname, email, password, confirm password, sign up button)


  @e2e
  Scenario:TC_002 Pozitif register - Kullanici basarili bir sekilde kayit olusturabildigini test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Sign up linkine tiklar
    When Register now sayfasında olduğunu doğrular
    When Kayit formunu doldurur
    When Register sayfasi sign up butonuna basar
    Then Basarili kayit yapildigini test eder




  Scenario:TC_003 Negatif register - Kullanici kayit formunu boş bırakarak kayıtt oluşturamadığını test eder
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Sign up linkine tiklar
    When Register now sayfasında olduğunu doğrular
    When Tum bilgileri bos birakir
    When Register sayfasi sign up butonuna basar
    When Tum bilgiler icin required uyarisi verildigini dogrular
    When Kayit yapilamadigi ve Register Now sayfasinda kalindigini test et





  Scenario:TC_004 Negatif register kullanici gecersiz email ile kayit olamamali
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Sign up linkine tiklar
    When Register now sayfasında olduğunu doğrular
    When Gercersiz email girer
    When Register sayfasi sign up butonuna basar
    Then Kayit yapılamadıgını test eder


  Scenario:TC_005 Negatif register testi kullanici farklı sifreler girerek kayıt olamamali
    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Sign up linkine tiklar
    When Register now sayfasında olduğunu doğrular
    When Confirm password passworddan farkli girer
    When Register sayfasi sign up butonuna basar
    When Password hatasi verildigi dogrular
