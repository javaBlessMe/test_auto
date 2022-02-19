package ru.auto.main.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.auto.main.at.base.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SelectNewCarPage extends Page {

    @FindBy(xpath="//div[text()='Skoda']")
    private WebElement newSkodaLink; //

    @FindBy(xpath = "//div[text()='Audi']")
    private WebElement newAudiLink; //

    @FindBy(xpath = "//div[text()='LADA (ВАЗ)']")
    private WebElement newLadaLink; //

    @FindBy(xpath = "//a[text()='Vesta']/following-sibling::div")
    private WebElement newLadaVestaQuantity;

    @FindBy(xpath = "//a[text()='Kodiaq']/following-sibling::div")
    private WebElement newSkodaKodiakQuantity;

    @FindBy(xpath = "//a[text()='A3']/ following-sibling::div")
    private WebElement newAudiA3Quantity;

    @FindBy(xpath = "//span[text()='Новые']")
    private WebElement newCarButton;

     @FindBy(xpath = "//div[text()='Все марки']")
    private WebElement allNewCarLink;

    @FindBy(xpath = "//span[text()='Марка']/../..")
    private WebElement carBrand;

    public SelectNewCarPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public WebElement findElementByText(String elementName) { //Метод, возращающий Webelement
        switch (elementName){                                // в завсимости от переданного значения
            case ("Skoda") -> {
                return newSkodaLink;
            }
            case("Audi") -> {
                return newAudiLink;
            }
            case("LADA (ВАЗ)") -> {
                return newLadaLink;
            }
            case("Vesta") -> {
                return newLadaVestaQuantity;
            }
            case("A3") -> {
                return newAudiA3Quantity;
            }
            case("Kodiaq") -> {
                return newSkodaKodiakQuantity;
            }
            case("Новые") -> {
                return newCarButton;
            }
            case("Все марки") -> {
                return allNewCarLink;
            }
        }
        return null;
    }


}
