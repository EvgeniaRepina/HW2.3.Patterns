package ru.netology.web.test;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

class CardDeliveryTest {

    @Test
    void shouldBookingACard() {
        Faker faker = new Faker(new Locale("RU"));

        String name = faker.name().fullName();
//        String city = faker.address().city();
        String city = Cities.getRandomCity();
        PhoneNumber phone = faker.phoneNumber();
        String planningDate1 = LocalDate.now().plusDays(4).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        String planningDate2 = LocalDate.now().plusDays(5).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

        open("http://localhost:9999");
        $("[data-test-id='city']  input").setValue(city);
        $("[data-test-id='date']  input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date']  input").setValue(planningDate1);
        $("[data-test-id='name']  input").setValue(name);
        $("[data-test-id='phone']  input").setValue(phone.phoneNumber());
        $("[data-test-id='agreement']").click();
        $(".grid-col button[role='button']").click();

        $(withText("Успешно!")).shouldBe(visible);
        $(withText("Встреча успешно запланирована на")).shouldBe(visible);
        $(withText(planningDate1)).shouldBe(visible);
//      $(".notification__content").shouldBe(visible).shouldHave(exactText("Встреча успешно запланирована на " + planningDate1));

        $("[data-test-id='date']  input").doubleClick().sendKeys(Keys.BACK_SPACE);
        $("[data-test-id='date']  input").setValue(planningDate2);

        $(".grid-col button[role='button']").click();

        $(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).shouldBe(visible);
//      $("[data-test-id=replan-notification] .notification__content").shouldBe(visible).shouldHave(exactText("У вас " +
//              "уже запланирована встреча на другую дату. Перепланировать?"));

        $(".notification_status_error .button_view_extra").click();

        $(withText("Успешно!")).shouldBe(visible);
        $(withText("Встреча успешно запланирована на")).shouldBe(visible);
        $(withText(planningDate2)).shouldBe(visible);
//     $("[data-test-id='success-notification'] .notification__content").shouldBe(visible).shouldHave
//     (exactText("Встреча успешно забронирована на " + planningDate2));


    }
}
