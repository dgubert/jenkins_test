import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static io.qameta.allure.Allure.step;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utils.RandomUtils.*;

public class RegistrationPageTests extends BaseTest {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        String firstName = getFirstName(),
                lastName = getLastName(),
                email = getEmail(),
                gender = getGender(),
                number = getNumber(),
                dayOfBirth = getDayOfBirthDate(),
                monthOfBirth = getMonthOfBirthDate(),
                yearOfBirth = getYearOfBirthDate(),
                subject = getSubject(),
                hobby = getHobby(),
                picture = getPicture(),
                address = getAddress(),
                state = getState(),
                city = getCity(state);

        step("Открываем страницу формы", () -> {
            registrationPage.openPage();
        });

        step("Заполняем форму данными и сохраняем", () -> {
            registrationPage.setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .selectGender(gender)
                .setUserNumber(number)
                .setDateOfBirth(dayOfBirth, monthOfBirth, yearOfBirth)
                .setSubject(subject)
                .setHobby(hobby)
                .setPicture(picture)
                .setAddress(address)
                .setState(state)
                .setCity(city)
                .submitForm();
        });

        step("Проверяем данные в таблице", () -> {
            registrationPage.checkResult("Student Name", firstName + " " + lastName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", number)
                .checkResult("Date of Birth", dayOfBirth + " " + monthOfBirth + "," + yearOfBirth)
                .checkResult("Subjects", subject)
                .checkResult("Hobbies", hobby)
                .checkResult("Picture", picture)
                .checkResult("Address", address)
                .checkResult("State and City", state + " " + city);
        });
    }

    @Test
    void someNegativeTest() {
        assertTrue(false);
    }

    @Test
    void someNegativeTest1() {
        assertTrue(false);
    }

    @Test
    void someNegativeTest2() {
        assertTrue(false);
    }

    @Test
    @Disabled
    void someSkippedTest() {
        assertTrue(false);
    }

    @Test
    @Disabled("Some reason")
    void someSkippedTest1() {
        assertTrue(false);
    }

}
