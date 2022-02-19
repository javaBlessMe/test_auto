package ru.auto.main.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import ru.auto.main.at.base.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SelectAtvPage extends Page {

    @FindBy(xpath = "//div[@class='Dropdown HeaderBurger']")
    private WebElement mainMenu;

    @FindBy(xpath = "//a[@class='HeaderSitemap__itemLink' and text()='Мотовездеходы']")
    private WebElement atvLink;

    @FindBy(xpath = "//span[text()='С пробегом']")
    private WebElement useVehicle;

    @FindBy(xpath = "//span[contains(text(),'Все марки')]")
    private WebElement allAtvLink;

    @FindBy(xpath = "//a[text()='Yamaha']")
    private WebElement atvYamaha;

    @FindBy(xpath = "//a[text()='Grizzly 660']/following-sibling::div")
    private WebElement yamahaGrizzlyQnt;

    @FindBy(xpath = "//a[text()='Baltmotors']")
    private WebElement atvBaltmotors;

    @FindBy(xpath = "//a[text()='Jumbo 700']/following-sibling::div")
    private WebElement baltmotorsJumboQnt;

    @FindBy(xpath = "//a[text()='BRP']")
    private WebElement atvBRP;

    @FindBy(xpath = "//a[text()='Can-Am Outlander 650']/following-sibling::div")
    private WebElement atvCanOut;



    public SelectAtvPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    @Override
    public WebElement findElementByText(String elementName) { //Метод, возращающий Webelement
        switch (elementName){                                 // в завсимости от переданного значения
            case("Главное меню") -> {
                return mainMenu;
            }
            case("С пробегом") -> {
                return useVehicle;
            }
            case ("Мотовездеходы") -> {
                return atvLink;
            }
            case ("Все марки") -> {
                return allAtvLink;
            }
            case ("Yamaha") -> {
                return atvYamaha;
            }
            case ("Baltmotors") -> {
                return atvBaltmotors;
            }
            case ("BRP") -> {
                return atvBRP;
            }
            case ("Grizzly 660") -> {
                return yamahaGrizzlyQnt;
            }
            case ("Jumbo 700") -> {
                return baltmotorsJumboQnt;
            }
            case ("Can-Am Outlander 650") -> {
                return atvCanOut;
            }

        }
        return null;
    }
}
