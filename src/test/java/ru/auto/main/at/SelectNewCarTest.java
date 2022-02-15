package ru.auto.main.at;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.auto.main.at.base.BaseTest;

public class SelectNewCarTest extends BaseTest {

    @DisplayName("Проверка количества автомобилей в результатах поиска")
    @Test
    public void selectTest() {


        new PageElement(driver, actions).
                clickButton("Новые").
                clickButton("Все марки").
                clickButton("Skoda").
                checkModelQuantity("Kodiaq", 133);


    }

}
