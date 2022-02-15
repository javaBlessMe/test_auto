package ru.auto.main.at;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class PageElement {
    public PageElement(WebDriver driver, Actions actions) {
        this.driver=driver;
        this.actions=actions;
        PageFactory.initElements(driver,this);
    }
    protected WebDriver driver;
    private boolean isNewCar;
    private Actions actions;
    @FindBy(xpath="//div[text()='Skoda' and @class='IndexMarks__item-name']")
    private WebElement newSkodaLink;

    @FindBy(xpath="//a[text()='Kodiaq']")
    private WebElement newSkodaKodiakLink;

    @FindBy(xpath = "//a[text()='Kodiaq']/following-sibling::div")
    private WebElement newSkodaKodiakQuantity;

    @FindBy(css="div.Header__logo > a")
    private WebElement mainHeader;

    @FindBy(xpath = "//span[text()='Новые']")
    private WebElement newCarButton;

    @FindBy(xpath = "//span[text()='С пробегом']/..")
    private WebElement useCarButton;

    @FindBy(css = "h1")
    private WebElement newCarHeader;

     @FindBy(xpath = "//div[@class='Dropdown HeaderBurger']")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[@class='HeaderSitemap__itemLink' and text()='Снегоходы']/..")
    private WebElement atvMenuField;

    @FindBy(xpath = "//div[text()='Мотовездеходы' and @class='ListingHead__title']")
    private WebElement atvHeader;

    @FindBy(xpath = "//div[text()='Все марки']")
    private WebElement allNewCarLink;

    @FindBy(xpath = "//span[text()='Марка']/../..")
    private WebElement carBrand;


    public void checkText(String elementName){
        switch (elementName) {
            case ("Авто.ру") -> assertThat(mainHeader.getText(), equalTo(elementName));
            case ("Новые легковые автомобили") -> assertThat(newCarHeader.getText(), containsString(elementName));
            case ("Мотовездеходы") -> assertThat(atvHeader.getText(), containsString(elementName));
            default -> throw new NotFoundException();
        }
    }
    public PageElement clickButton(String buttonName){
        switch (buttonName) {
            case ("Новые") -> {
                newCarButton.click();
                this.isNewCar=true;
            }
            case ("Skoda") -> actions.click(newSkodaLink).build().perform();
            case ("Все марки") -> actions.click(allNewCarLink).build().perform();
            //case ("Сохранить") -> actions.click(saveSearchButton).build().perform();
            case ("Мотовездеходы") -> actions.click(atvMenuField).build().perform();


          //  default -> throw new NotFoundException();
        }
        return this;
    }
    public void checkModelQuantity(String carModel, int trueQuantity){

      if(carModel.equals("Kodiaq")&& this.isNewCar){
          assertThat(newSkodaKodiakQuantity.getText(),equalTo(String.valueOf(trueQuantity)));
      }

    }
    public PageElement hoverOn(String elementName){
        switch (elementName){
            case("Главное меню") -> actions.moveToElement(mainMenu).build().perform();
            case("Мотовездеходы") -> actions.moveToElement(atvMenuField).build().perform();
            default -> throw new NotFoundException();
        }
        return this;
    }

    public PageElement selectFromList(String elementName){
      /*  Select dropdown = new Select(carBrand);
        dropdown.selectByValue(elementName);*/
        carBrand.sendKeys("Baltmotors"+ Keys.ENTER);
        return this;
    }

}