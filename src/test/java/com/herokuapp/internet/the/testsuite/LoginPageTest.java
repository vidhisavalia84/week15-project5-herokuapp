package com.herokuapp.internet.the.testsuite;

import com.herokuapp.internet.the.customlisteners.CustomListeners;
import com.herokuapp.internet.the.pages.LoginPage;
import com.herokuapp.internet.the.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

LoginPage loginPage;
@BeforeMethod(alwaysRun = true)
    public void inIt(){
    loginPage=new LoginPage();
}
@Test(groups = {"sanity","regression"})
    public void verifyUsershouldLoginSuccessfully()throws InterruptedException{
    Thread.sleep(2000);

loginPage.enterUserName("tomsmith");
    loginPage.enterPassword("SuperSecretPassword!");
    loginPage.clickOnLoginButton();
    Assert.assertEquals(loginPage.verifyMessageText(),"Secure Area");
}
@Test(groups = {"smoke","regression"})
public void verifyThePasswordErrorMessage() throws InterruptedException{
    Thread.sleep(2000);
    loginPage.enterUserName("tomsmith");
    loginPage.enterPassword("SuperSecretPassword");
    loginPage.clickOnLoginButton();
    Assert.assertEquals(loginPage.verifyPasswordErrorMessage(), "Your password is invalid!\n" + "×");
}
    @Test(groups = {"regression"})
    public void verifyTheErrorMessage()throws InterruptedException{
    Thread.sleep(2000);
        loginPage.enterUserName("tomsmith1");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.verifyUserNameErrorMessage(),"Your username is invalid!\n" + "×");
    }


}
