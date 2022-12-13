package com.herokuapp.internet.the.pages;

import com.herokuapp.internet.the.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
   // @CacheLookup
@CacheLookup
    @FindBy(name = "username")
    WebElement userName;
    @CacheLookup
    @FindBy(name ="password")
    WebElement password;
    @CacheLookup
    @FindBy(xpath = "//i[contains(text(),'Login')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Secure Area')]")
    WebElement secureArea;
    @CacheLookup
    @FindBy(id = "flash")
    WebElement passwordErrorMessage;

   @CacheLookup
    @FindBy(id = "flash")
    WebElement userNameErrorMessage;

    public void enterUserName(String text) {
        Reporter.log("Enter username " + userName.toString());
       sendTextToElement(userName,text);
    }

    public void enterPassword(String text) {
        Reporter.log("Enter password " + password.toString());
        sendTextToElement(password,text);
    }

    public void clickOnLoginButton() {
        Reporter.log("Click on login button " + loginButton.toString());
        clickOnElement(loginButton);
    }

    public String verifyMessageText() {
        Reporter.log("Verify message is Secure Area : " + secureArea.toString());
        return getTextFromElement(secureArea);
    }

    public String verifyPasswordErrorMessage() {
        Reporter.log("Verify password error Message : " + passwordErrorMessage.toString());
        return getTextFromElement(passwordErrorMessage);
    }
    public String verifyUserNameErrorMessage(){
        Reporter.log("Verify userName error Message : "+userNameErrorMessage.toString());
        return getTextFromElement(userNameErrorMessage);
    }
}
