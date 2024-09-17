Feature:US_002 Kullanici Sign in scenariolari

  Scenario:TC_001 Kullanıcı gecerli email ve sifre ile giriş yapar ve
            First Name, Last Name ve email bilgilerinin gorunebildiğini test eder

    Given Kullanici testOtomasyonu sitesine gider
    When Sayfaya gittigini dogrular
    When Account linkine tiklar
    When Login now sayfasinda olduğunu test eder
    When Email ve password alanlarinin göründüğünü doğrular
    When gecerli email ve password girer
    When Sign in butonuna tiklar
    When Login succes yazisinin görünüğünü doğrular
    When Kullanici profilinde oldugunu dogrular
    Then Kullanici firstName lastName ve emailin göründügünü dogrular

  @e2e
  Scenario:TC_002 Kullanici gecerli email ve password girdiginde  MyProfile, My Orders, Wishlist,
              Manage Adress,change password ve Logout butonlarinin gorunebildiğini test eder

      Given Kullanici testOtomasyonu sitesine gider
      When Sayfaya gittigini dogrular
      When Account linkine tiklar
      When Login now sayfasinda olduğunu test eder
      When Email ve password alanlarinin göründüğünü doğrular
      When gecerli email ve password girer
      When Sign in butonuna tiklar
      When Login succes yazisinin görünüğünü doğrular
      When Kullanici profilinde oldugunu dogrular
      When Kullanici profilinde MyProfile,My Orders,Wishlist,Manage Adress, change password ve Logout butonlarinin gorunebildiğini test eder

