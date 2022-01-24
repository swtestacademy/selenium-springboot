//package tests;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.parallel.Execution;
//import org.junit.jupiter.api.parallel.ExecutionMode;
//import pages.HomePage;
//
//@Execution(ExecutionMode.CONCURRENT)
//public class CopyOfLoginTest extends BaseTest {
//    @Test
//    public void invalidLoginTest_InvalidUserNameInvalidPassword2() {
//        System.out.println("Driver of invalidLoginTest_InvalidUserNameInvalidPassword2" + driver.toString());
//        page.getPage(HomePage.class)
//            .givenIAmAtHomePage()
//            .whenIGoToLoginPage()
//            .andILoginToN11("onur@swtestacademy.com", "11223344")
//            .thenIVerifyLogEntryFailMessage();
//    }
//
//    @Test
//    public void invalidLoginTest_EmptyUserEmptyPassword2() {
//        System.out.println("Driver of invalidLoginTest_EmptyUserEmptyPassword2" + driver.toString());
//
//        page.getPage(HomePage.class)
//            .givenIAmAtHomePage()
//            .whenIGoToLoginPage()
//            .andILoginToN11("", "")
//            .thenIVerifyLoginUserNameErrorMessage("Lütfen e-posta adresinizi girin.")
//            .thenIVerifyPasswordErrorMessage("Bu alanın doldurulması zorunludur.");
//    }
//}
