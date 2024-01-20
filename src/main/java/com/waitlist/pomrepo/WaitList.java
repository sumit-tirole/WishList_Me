package com.waitlist.pomrepo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitList {
	
	WebDriver driver;
	
	public WaitList(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
	
	public void synchronised(By locator, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		wait.until(ExpectedConditions.elementToBeClickable(element));	
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	@FindBy(xpath="//button[@data-tip='Settings']")
	WebElement settingsButton;

	@FindBy(xpath="//button[@data-tip='Show History']")
	WebElement showHistoryButton;
	
	@FindBy(xpath="//button[@data-tip='Add Party']")
	WebElement addPartyButton;
	
	@FindBy(xpath="//td[text()='Richard']")
	WebElement waitListparty;
	
	
	public WebElement getWaitListparty() {
		synchronised(By.xpath("//td[text()='Richard']"),waitListparty);
		return waitListparty;
	}

	public WebElement getAddPartyButton() {
		synchronised(By.xpath("//button[@data-tip='Add Party']"),addPartyButton);
		return addPartyButton;
	}

	public WebElement getSettingsButton() {
		synchronised(By.xpath("//button[@data-tip='Settings']"),settingsButton);
		return settingsButton;
	}

	public WebElement getShowHistoryButton() {
		synchronised(By.xpath("//button[@data-tip='Show History']"),showHistoryButton);
		return showHistoryButton;
	}
	
	
}
