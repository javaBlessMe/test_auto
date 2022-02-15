package ru.auto.main.at;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.PageFactory;
import ru.auto.main.at.base.BaseTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import java.time.Duration;

public class MainPageTest extends BaseTest {


    @Test
    void mainPageTest(){



        new PageElement(driver,actions).
                checkText("Авто.ру");

    }


}
