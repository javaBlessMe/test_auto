package ru.auto.main.at;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.auto.main.at.base.BaseTest;

public class SelectNewCarTest extends BaseTest {

    @DisplayName("Проверка количества автомобилей в результатах поиска")
    @ParameterizedTest
    @CsvFileSource(resources = "/new_car_quantity_test.csv", numLinesToSkip = 1)
    public void selectTest(String brand, String model, int quantity) {

        new SelectNewCarPage(driver).
                clickButton("Новые"). //Выбрать раздел новые
                clickButton("Все марки"). //Загрузить весь список, нажав все Марки
                clickButton(brand). //С помощью техники парный значений, тестируем различные тестовые наборы из списка
                waitUpload(3).
                checkModelQuantity(model, quantity);
    }
}
