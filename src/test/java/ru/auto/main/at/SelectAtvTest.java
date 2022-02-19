package ru.auto.main.at;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.auto.main.at.base.BaseTest;

public class SelectAtvTest extends BaseTest {

    /*
        Тестирование поиска мотовездеходов методом парных значений.
        На основе входные параметров Марка (brand), Модель (model) и количество (quantity),
        тест осуществляет поиск и сравнивает найденное кол-во объявлений с переданным.
     */
    @ParameterizedTest
    @CsvFileSource(resources = "/use_atv_quantity_test.csv", numLinesToSkip = 1)
    public void checkAtvQuantityTest(String brand, String model, int quantity){
        new SelectAtvPage(driver,actions).
                hoverOn("Главное меню").
                clickButton("Мотовездеходы").
                clickButton("Все марки").
                clickButton(brand).
                waitUpload(2).
                checkModelQuantity(model,quantity);

    }
}
