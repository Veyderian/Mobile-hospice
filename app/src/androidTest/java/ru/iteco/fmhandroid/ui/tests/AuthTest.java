//package ru.iteco.fmhandroid.ui.tests;
//import androidx.test.espresso.NoMatchingViewException;
//import androidx.test.ext.junit.rules.ActivityScenarioRule;
//import androidx.test.filters.LargeTest;
//import androidx.test.rule.ActivityTestRule;
//
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//
//import io.qameta.allure.android.runners.AllureAndroidJUnit4;
//import io.qameta.allure.kotlin.Description;
//import io.qameta.allure.kotlin.Epic;
//import io.qameta.allure.kotlin.Story;
//import ru.iteco.fmhandroid.ui.AppActivity;
//import ru.iteco.fmhandroid.pages.AuthPage;
//import ru.iteco.fmhandroid.steps.AuthSteps;
//import ru.iteco.fmhandroid.ui.pages.AuthPage;
//
//@LargeTest
////@RunWith(AndroidJUnit4.class)
//@RunWith(AllureAndroidJUnit4.class)
//
//@Epic("Тест-кейсы для проведения функционального тестирования вкладки Авторизация")
//
//
//
//public class AuthTest {
//
//    @Rule
//    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
//            new ActivityScenarioRule<>(AppActivity.class);
//
//    @Before
//    public void authorizationVerification() {
//        try {
//            AuthPage.textAuthorization();
//        } catch (NoMatchingViewException e) {
//            AuthPage.clickButtonExit(AuthPage.getAuthorizationElementsButtonExit());
//            AuthSteps.clickButtonLogOut();
//        }
//    }
//
//    // Тест-кейсы для проведения функционального тестирования вкладки "Авторизация" мобильного приложения "Мобильный хоспис".
//
//    //  TC - 1 - Авторизация в мобильном приложении "Мобильный хоспис"(Позитивный).
//    @Test
//    @Story("TC - 1")
//    @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
//
//    @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
//    public void successfulAuthorization() {
//        Authteps.textAuthorization();
//        AuthSteps.clickLoginField();
//        AuthSteps.clickPasswordField();
//        AuthPage.clickButton(AuthPage.getAuthorizationElementsButton());
//        AuthPage.clickButtonExit(AuthPage.getAuthorizationElementsButtonExit());
//        Auth.clickButtonLogOut();
//    }
//
//    //  TC - 2 - Поле "Логин" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 2")
//    @Description("Поле Логин пустое, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void loginFieldIsEmpty() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginEmpty();
//        AuthorizationSteps.clickPasswordField();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 3 - Поле "Логин" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 3")
//    @Description("Поле Логин заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void loginFieldUnregisteredUser() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginFieldUnregisteredUser();
//        AuthorizationSteps.clickPasswordField();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 4 - Поле "Логин" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 4")
//    @Description("Поле Логин состоит из спецсимволов, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void loginFieldWithSpecialCharacters() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginFieldWithSpecialCharacters();
//        AuthorizationSteps.clickPasswordField();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 5 - Поле "Логин" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 5")
//    @Description("Поле Логин состоит из одного символа, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void loginFieldOneLetter() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginFieldOneLetter();
//        AuthorizationSteps.clickPasswordField();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 6 - Поле "Логин" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 6")
//    @Description("Поле Логин состоит из букв разного регистра, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void loginFieldLettersOfDifferentCase() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginFieldLettersOfDifferentCase();
//        AuthorizationSteps.clickPasswordField();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 7 - Поле "Пароль" пустое, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 7")
//    @Description("Поле Пароль пустое, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void passwordFieldIsEmpty() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginField();
//        AuthorizationSteps.clickPasswordFieldIsEmpty();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 8 - Поле "Пароль" заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 8")
//    @Description("Поле Пароль заполнено данными незарегистрированного пользователя, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void passwordFieldUnregisteredUser() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginField();
//        AuthorizationSteps.clickPasswordFieldUnregisteredUser();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 9 - Поле "Пароль" состоит из спецсимволов, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 9")
//    @Description("Поле Пароль состоит из спецсимволов, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void passwordFieldWithSpecialCharacters() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginField();
//        AuthorizationSteps.clickPasswordFieldWithSpecialCharacters();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 10 - Поле "Пароль" состоит из одного символа, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 10")
//    @Description("Поле Пароль состоит из одного символа, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void passwordFieldOneLetter() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginField();
//        AuthorizationSteps.clickPasswordFieldOneLetter();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//
//    //  TC - 11 - Поле "Пароль" состоит из букв разного регистра, при авторизации, в мобильном приложении "Мобильный хоспис"(Негативный).
//    @Test
//    @Story("TC - 11")
//    @Description("Поле Пароль состоит из букв разного регистра, при авторизации, в мобильном приложении Мобильный хоспис (Негативный)")
//    public void passwordFieldLettersOfDifferentCase() {
//        AuthorizationSteps.textAuthorization();
//        AuthorizationSteps.clickLoginField();
//        AuthorizationSteps.clickPasswordFieldLettersOfDifferentCase();
//        AuthorizationScreen.clickButton(AuthorizationScreen.getAuthorizationElementsButton());
//    }
//}
