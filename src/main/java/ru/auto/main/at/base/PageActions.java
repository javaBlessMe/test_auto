package ru.auto.main.at.base;

import org.openqa.selenium.WebElement;

public interface PageActions {
    void checkText(String elementName,String text); //Сравнение текста элемента и переданного значения
    Page clickButton(String elementName); //Нажатие на кнопку
    Page hoverOn(String elementName);
    void checkModelQuantity(String ModelName, int quantity);
    WebElement findElementByText(String elementName);
    Page waitUpload(int seconds);

}
