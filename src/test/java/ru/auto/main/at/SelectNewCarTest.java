package ru.auto.main.at;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import ru.auto.main.at.base.BaseTest;

public class SelectNewCarTest extends BaseTest {

    @DisplayName("Проверка количества автомобилей в результатах поиска")
    @ParameterizedTest
    @CsvFileSource(resources = "/new_car_quantity_test.csv",numLinesToSkip = 1)
    public void selectTest(String brand,String model,int quantity) {

        new PageElement(driver, actions).
                clickButton("Новые").
                clickButton("Все марки").
                //checkModelQuantity("Audi","A3",79);
                checkModelQuantity(brand,model,quantity);
    }

}
