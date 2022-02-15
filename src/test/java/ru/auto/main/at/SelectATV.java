package ru.auto.main.at;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.auto.main.at.base.BaseTest;

public class SelectATV extends BaseTest {

    @Disabled
    @Test
    public void checkAtvQuantityTest(){
        new PageElement(driver,actions).
                hoverOn("Главное меню").
                clickButton("Мотовездеходы").
                selectFromList("Baltmotors").
                checkText("Baltmotors");
        //sc-cOajty sc-feIgJR eQArkj eZPhgt
    }
}
