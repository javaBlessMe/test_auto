package ru.auto.main.at;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.auto.main.at.base.Page;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MainPage extends Page {

    @FindBy(css="div.Header__logo > a")
    private WebElement mainHeader; //Поиск элемента по селектору

    public MainPage(WebDriver driver) {
        super(driver);
    }


    @Override
    public WebElement findElementByText(String elementName) { //Метод, возращающий Webelement загловока сайта
        if(elementName.equals("Заголовок")){
            return mainHeader;
        }
        return null;
    }

}
