//package ru.netology.web.test;
//
//import com.codeborne.selenide.Condition;
//import com.github.javafaker.Faker;
//import com.github.javafaker.PhoneNumber;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.openqa.selenium.By;
////import ru.netology.web.data.DataGenerator;
//
//import java.time.LocalDate;
//import java.util.Locale;
//
//import static com.codeborne.selenide.Condition.visible;
//import static com.codeborne.selenide.Selectors.withText;
//import static com.codeborne.selenide.Selenide.$;
//import static com.codeborne.selenide.Selenide.open;
//
//
//class CardDeliveryTest2 {
//
//    @Test
//    void shouldBookingACard() {
//        var validUser = DataGenerator.Registration.generateUser("ru");
//        var daysToAddForFirstMeeting = 4;
//        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
//        var daysToAddForSecondMeeting = 7;
//        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
//        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
//        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
//        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
//        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
//        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
//
//        Faker faker = new Faker(new Locale("RU"));
//
//        String name = faker.name().fullName();
//        String city = faker.address().city();
//        PhoneNumber phone = faker.phoneNumber();
////        Date date = faker.date().future(10, 5, DAYS);
//
//
//        open("http://localhost:9999");
//        $("[data-test-id='city']  input").setValue(city);
//
//        String text = $("[formnovalidate][view]").getAttribute("value");
////        $("[data-test-id='date']  input").clear();
////        $("[data-test-id='date']  input").setValue(String.valueOf(text));
//        LocalDate text2 = LocalDate.now().plusYears(1);
//
//        $("[data-test-id='name']  input").setValue(name);
//        $("[data-test-id='phone']  input").setValue(phone.phoneNumber());
//        $("[data-test-id='agreement']").click();
//        $(".grid-col button[role='button']").click();
//
//        $(withText("Успешно!")).shouldBe(visible);
//        Assertions.assertTrue($(withText("Встреча успешно запланирована на")).exists());
//        Assertions.assertTrue($(By.cssSelector(".notification__content")).shouldHave(Condition.text(text)).exists());
//
////        String text2 = $("[formnovalidate][view]").getAttribute("value");
////        $("[data-test-id='date']  input").setValue(text2);
//
////        $(".form-field > span > span> input").setValue(String.valueOf(text));
//        $(".form-field > span > span> input").setValue(text);
//
//        $(".grid-col button[role='button']").click();
//        Assertions.assertTrue($(withText("У вас уже запланирована встреча на другую дату. Перепланировать?")).exists());
//        $(".notification_status_error .button_view_extra").click();
//
//        $(withText("Успешно!")).shouldBe(visible);
//        Assertions.assertTrue($(withText("Встреча успешно запланирована на")).exists());
////        Assertions.assertTrue($(By.cssSelector(".notification__content")).shouldHave(Condition.text(String.valueOf(text2))).exists());
//
//
//    }
//}
