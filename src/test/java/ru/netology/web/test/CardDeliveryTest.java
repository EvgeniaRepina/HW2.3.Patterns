package ru.netology.web.test;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.LocalDate;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


class CardDeliveryTest {

    @Test
    void shouldBookingACard() throws InterruptedException {
        Faker faker = new Faker(new Locale("RU"));

        String name = faker.name().fullName();
        String city = faker.address().city();
        PhoneNumber phone = faker.phoneNumber();
//        Date date = faker.date().future(10, 5, DAYS);


        open("http://localhost:9999");
        $("[data-test-id='city']  input").setValue(city);

        String text = $("[formnovalidate][view]").getAttribute("value");
//        $("[data-test-id='date']  input").clear();
//        $("[data-test-id='date']  input").setValue(String.valueOf(text));
        LocalDate text2 = LocalDate.now().plusYears(1);

        $("[data-test-id='name']  input").setValue(name);
        $("[data-test-id='phone']  input").setValue(phone.phoneNumber());
        $("[data-test-id='agreement']").click();
        $(".grid-col button[role='button']").click();

        $(withText("Успешно!")).shouldBe(visible);
        Assertions.assertTrue($(withText("Встреча успешно запланирована на")).exists());
        Assertions.assertTrue($(By.cssSelector(".notification__content")).shouldHave(Condition.text(text)).exists());

//        String text2 = $("[formnovalidate][view]").getAttribute("value");
//        $("[data-test-id='date']  input").setValue(text2);

        $(".form-field > span > span> input").setValue(String.valueOf(text2));

        $(".grid-col button[role='button']").click();
        Assertions.assertTrue($(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).exists());
        $(".notification_status_error .button_view_extra").click();

        $(withText("Успешно!")).shouldBe(visible);
        Assertions.assertTrue($(withText("Встреча успешно запланирована на")).exists());
//        Assertions.assertTrue($(By.cssSelector(".notification__content")).shouldHave(Condition.text(String.valueOf(text2))).exists());


    }
}
