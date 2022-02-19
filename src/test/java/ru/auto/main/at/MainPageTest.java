package ru.auto.main.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.auto.main.at.base.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.time.Duration;

public class MainPageTest extends BaseTest {

    //Проверка загрузки главной страницы сайта
    @Test
    void mainPageTest(){
        new MainPage(driver).
        checkText("Заголовок","Авто.ру");
    }


}
