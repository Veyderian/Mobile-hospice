package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.enterButton;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getAuthLoginField;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getAuthPasswordField;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getElementsButtonLogOut;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getTextAuthorization;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitFor;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;



public class AuthSteps {


    public static void validAuthorization() {
        try {
            AuthSteps.textAuthorization();
            AuthSteps.clickValidLoginField();
            AuthSteps.clickValidPasswordField();
            AuthSteps.clickButtonSignIn();
        } catch (NoMatchingViewException e) {
            System.out.println("Already auth");
        }
    }

    public static void textAuthorization() {
        Allure.step("страница авторизации");
        waitUntilElement(R.id.nav_host_fragment);
        waitFor(3);
        onView(getTextAuthorization())
                .check(matches(isDisplayed()));
    }


    public static void clickValidLoginField() {
        Allure.step("В поле Логин ввести: login2");
        waitUntilElement(R.id.login_text_input_layout);
        onView(getAuthLoginField())
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));

    }

    public static void clickValidPasswordField() {
        Allure.step("В поле Пароль ввести: password2");
        waitUntilElement(R.id.password_text_input_layout);
        onView(getAuthPasswordField())
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        waitUntilElement(R.id.enter_button);
        enterButton
                .perform(click());

    }

    public static void clickButtonLogOut() {
        Allure.step("Нажать на кнопку Log out");
        waitUntilElement(android.R.id.title);

        onView(getElementsButtonLogOut())
                .perform(click());
    }

    public static void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");
        waitUntilElement(R.id.authorization_image_button);
        waitFor(2);
        onView(withId(resourceId))
                .perform(click());
    }


    public static void textErrorWrong() {

        Allure.step("Отобразилаcь ошибка: Login and password cannot be empty");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }


    public static void textErrorEmpty() {
        Allure.step("Ошибка: Login and password cannot be empty");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    public static void clickLoginEmpty() {
        Allure.step("Поле Логин оставить пустым");
        onView(getAuthLoginField())
                .perform(replaceText(" "), closeSoftKeyboard());
    }

    public static void clickLoginSpace() {
        Allure.step("Поле Логин заполнить пробелами");
        onView(getAuthLoginField())
                .perform(replaceText("pass"), closeSoftKeyboard());

    }

    //
    public static void clickLoginFieldUnregisteredUser() {
        Allure.step("Ввести в поле Логин данные незарегистрированного пользователя");
        onView(getAuthLoginField())
                .perform(replaceText("loginer123"), closeSoftKeyboard());
//
    }

    public static void clickLoginFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Логин спецсимволы");
        onView(getAuthLoginField())
                .perform(replaceText("@#$^&**"), closeSoftKeyboard());
        //onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickLoginFieldOneSymbol() {
        Allure.step("Ввести в поле Логин один символ");
        onView(getAuthLoginField())
                .perform(replaceText("l"), closeSoftKeyboard());
//
    }

    public static void clickLoginFieldTwoSymbols() {
        Allure.step("Ввести в поле Логин 2 символа");
        onView(getAuthLoginField())
                .perform(replaceText("La"), closeSoftKeyboard());
    }

    public static void clickLoginFieldOfNumbers() {
        Allure.step("Ввести в поле Логин цифры");
        onView(getAuthLoginField())
                .perform(replaceText("12365436"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldIsEmpty() {
        Allure.step("Поле Пароль оставить пустым");
        onView(getAuthPasswordField())
                .perform(replaceText(" "), closeSoftKeyboard())
                .check(matches(isDisplayed()));

    }

    public static void clickPasswordFieldWrongPassword() {
        Allure.step("Ввести в поле Пароль невалидные данные");
        onView(getAuthPasswordField())
                .perform(replaceText("password123"), closeSoftKeyboard())
                .check(matches(isDisplayed()));

    }

    public static void clickPasswordFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Пароль спецсимволы");
        onView(getAuthPasswordField())
                .perform(replaceText("$^&%^&(*^@"), closeSoftKeyboard())
                .check(matches(isDisplayed()));

    }

    public static void clickPasswordFieldOneSymbol() {
        Allure.step("Ввести в поле Пароль один символ");
        onView(getAuthPasswordField())
                .perform(replaceText("Q"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
        //    onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickPasswordFieldTwoSymbols() {
        Allure.step("Ввести в поле Пароль 2 символа");
        onView(getAuthPasswordField())
                .perform(replaceText("Qn"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickPasswordFieldOfNumbers() {
        Allure.step("Ввести в поле Пароль 2 символа");
        onView(getAuthPasswordField())
                .perform(replaceText("12365436"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }
}





