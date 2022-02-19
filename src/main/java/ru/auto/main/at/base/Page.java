package ru.auto.main.at.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public abstract class Page implements PageActions {
    protected WebDriver driver;
    protected Actions actions;

    public Page(WebDriver driver){ //Объявляем первый контруктор
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public Page(WebDriver driver, Actions actions){ //Объявляем второй конструктор
        this.driver=driver;
        this.actions=actions;
        PageFactory.initElements(driver,this);
    }

    @Override
    public Page waitUpload(int seconds) {   //Метод, который реализует небольшую паузу
        try {
            Thread.sleep(seconds* 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Override
    public Page clickButton(String elementName) { //Метод, который реализует нажатие на кнопку или ссылку
        WebElement webElement = findElementByText(elementName); //Поиск элемента по строке
        webElement.click();
        return this;
    }

    @Override
    public Page hoverOn(String elementName) { //Метод, который реализует наведение на элемент
        WebElement webElement = findElementByText(elementName); //Поиск элемента по строке
        actions.moveToElement(webElement).build().perform();
         return this;
    }
    @Override
    public void checkText(String elementName,String text) { //Проверка текста, который содержит заданный элемент
        WebElement webElement = findElementByText(elementName);
        assertThat(text,equalTo(webElement.getText()));
    }
    @Override
    public void checkModelQuantity(String modelName, int quantity) { //Проверка текста, который содержит заданный элемент
        WebElement webElement = findElementByText(modelName);
        assertThat(webElement.getText(),equalTo(String.valueOf(quantity)));
    }

}
