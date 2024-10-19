package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static pages.component.CalendarComponent.setDate;
import static pages.component.TableComponent.checkTableData;

public class RegistrationPage {

    private final SelenideElement firstNameInput =  $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        genderSelect = $("#genterWrapper"),
        userNumberInput = $("#userNumber"),
        dateOfBirthInput = $("#dateOfBirthInput"),
        subjectsInput = $("#subjectsContainer input"),
        hobbiesSelect = $("#hobbiesWrapper"),
        uploadPictureInput = $("#uploadPicture"),
        currentAddressInput = $("#currentAddress"),
        stateInput = $("#state input"),
        cityInput = $("#city input"),
        submitButton = $("#submit"),
        modalTitle = $(".modal-title"),
        tableResponsive = $(".table-responsive");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        firstNameInput.setValue(firstName);

        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        lastNameInput.setValue(lastName);

        return this;
    }

    public RegistrationPage setUserEmail(String email) {
        emailInput.setValue(email);

        return this;
    }

    public RegistrationPage selectGender(String gender) {
        genderSelect.$(byText(gender)).click();

        return this;
    }

    public RegistrationPage setUserNumber(String userNumber) {
        userNumberInput.setValue(userNumber);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.click();
        setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String subject) {
        subjectsInput.click();
        subjectsInput.sendKeys(subject);
        subjectsInput.pressEnter();

        return this;
    }

    public RegistrationPage setHobby(String hobby) {
        hobbiesSelect.$(byText(hobby)).click();

        return this;
    }

    public RegistrationPage setPicture(String picturePath) {
        uploadPictureInput.uploadFromClasspath(picturePath);

        return this;
    }

    public RegistrationPage setAddress(String address) {
        currentAddressInput.setValue(address);

        return this;
    }

    public RegistrationPage setState(String state) {
        stateInput.sendKeys(state);
        stateInput.pressEnter();

        return this;
    }

    public RegistrationPage setCity(String city) {
        cityInput.sendKeys(city);
        cityInput.pressEnter();

        return this;
    }

    public void submitForm() {
        submitButton.click();
    }

    public void checkUnsuccessfulRegistration() {
        modalTitle.shouldNotBe(exist);
    }

    public RegistrationPage checkResult(String key, String value) {
        checkTableData(tableResponsive, key, value);

        return this;
    }
}
