package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static tests.TestData.*;

public class RegistrationWithRemoteDriverTests extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successfulRegistrationTest() {
        step("Open form", () -> {
            registrationPage.openPage();
        });
        step("Remove Banner", () -> {
            registrationPage.removeBanners();
        });
        step("Set full name", () -> {
            registrationPage.setFirstName(firstName)
                    .setLastName(lastName);
        });
        step("Set email", () -> {
            registrationPage.setEmail(email);
        });
        step("Set gender", () -> {
            registrationPage.setGender(gender);
        });
        step("Set phone number", () -> {
            registrationPage.setMobile(mobile);
        });
        step("Set date of birth", () -> {
            registrationPage.setBirthDate(dayOfBirthDate, monthOfBirthDate, yearOfBirthDate);
        });
        step("Set subject", () -> {
            registrationPage.setSubject(subject);
        });
        step("Set hobbies", () -> {
            registrationPage.setHobbies(hobbies);
        });
        step("Set upload picture", () -> {
            registrationPage.setUploadPicture(picture);
        });
        step("Set address", () -> {
            registrationPage.setAddress(address);
        });
        step("Set state and city", () -> {
            registrationPage.setState(state)
                    .setCity(city);
        });
        step("Submit form", () -> {
            registrationPage.submitButton();
        });

        step("Verify results", () -> {
            registrationPage.verifyResultsModalAppears()
                    .verifyResults("Student Name", firstName + " " + lastName)
                    .verifyResults("Student Email", email)
                    .verifyResults("Gender", gender)
                    .verifyResults("Mobile", mobile)
                    .verifyResults("Date of Birth", dayOfBirthDate + " " +
                            monthOfBirthDate + "," + yearOfBirthDate)
                    .verifyResults("Subjects", subject)
                    .verifyResults("Hobbies", hobbies)
                    .verifyResults("Picture", picture)
                    .verifyResults("Address", address)
                    .verifyResults("State and City", state + " " + city);
        });
    }
}

