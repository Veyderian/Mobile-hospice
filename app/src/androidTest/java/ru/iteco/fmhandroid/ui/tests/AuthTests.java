package ru.iteco.fmhandroid.ui.tests;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;


@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Authorization")

public class AuthTests {


    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);
//        @Rule
//        public ActivityTestRule<SplashActivity> activityTestRule = new ActivityTestRule<>(SplashActivity.class);

    //    @Before
//    public void setUp() {
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource);
//    }
//
//    @After
//    public void tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource);
//    }
    @Before
    public void authVerification() {

        try {

            AuthSteps.textAuthorization();
            //AuthPage.titleTextElement();
        } catch (androidx.test.espresso.NoMatchingViewException e) {
            AuthPage.clickButtonExit(AuthPage.getElementButtonExit());
            AuthSteps.clickButtonLogOut();
        }

    }

    @Test //1
    @Story("TC - 2")
    @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
    public void successfulAuthorization() {
        //AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickValidPasswordField();
        AuthSteps.clickButtonSignIn();
        AuthPage.getFindText();

//            AuthPage.clickButtonExit(getElementButtonExit());
//            AuthSteps.clickButtonLogOut();
    }

    // логин
    @Test //2
    @Story("TC - 4")
    @Description("Поле Логин пустое при авторизации")
    public void loginFieldIsEmpty() {
        //AuthSteps.textAuthorization();
        AuthSteps.clickLoginEmpty();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorEmpty();
    }

    @Test //3
    @Story("TC - 6")
    @Description("Поле Логин заполнено пробелами при авторизации")
    public void loginFieldIsSpace() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginSpace();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorEmpty();
    }


    @Test //4
    @Story("TC - 3")
    @Description("Поле Логин заполнено данными незарегистрированного пользователя при авторизации")
    public void loginFieldUnregisteredUser() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginFieldUnregisteredUser();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


    @Test //5
    @Story("TC - 10")
    @Description("Поле Логин состоит из спецсимволов при авторизации")
    public void loginFieldWithSpecialCharacters() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginFieldWithSpecialCharacters();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


    @Test //6
    @Story("TC - 7")
    @Description("Поле Логин состоит из одного символа при авторизации")
    public void loginFieldOneSymbol() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginFieldOneSymbol();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    @Test //7
    @Story("TC - 8")
    @Description("Поле Логин состоит из 2-х символов при авторизации")
    public void loginFieldTwoSymbols() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginFieldTwoSymbols();
        AuthSteps.clickValidPasswordField();
        AuthSteps.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    // пароль
    @Test //8
    @Story("TC - 9")
    @Description("Поле Логин состоит из цифр при авторизации")
    public void loginFieldOfNumbers() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginFieldOfNumbers();
        AuthSteps.clickValidPasswordField();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


    @Test //9
    @Story("TC - 14")
    @Description("Поле Пароль пустое при авторизации")
    public void passwordFieldIsEmpty() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldIsEmpty();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


    @Test //10
    @Story("TC -13")
    @Description("Поле Пароль заполнено невалидными данными при авторизации")
    public void passwordFieldWrongPassword() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldWrongPassword();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


    @Test //11
    @Story("TC - 16")
    @Description("Поле Пароль состоит из одного символа при авторизации")
    public void passwordFieldOneSymbol() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldOneSymbol();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    @Test //12
    @Story("TC - 17")
    @Description("Поле Пароль состоит из 2 символов при авторизации")
    public void passwordFieldTwoSymbols() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldTwoSymbols();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    @Test //13
    @Story("TC - 18")
    @Description("Поле Пароль состоит из цифр при авторизации")
    public void passwordFieldOfNumbers() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldOfNumbers();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    @Test //14
    @Story("TC - 19")
    @Description("Поле Пароль состоит из спецсимволов при авторизации")
    public void passwordFieldWithSpecialCharacters() {
        AuthSteps.textAuthorization();
        AuthSteps.clickValidLoginField();
        AuthSteps.clickPasswordFieldWithSpecialCharacters();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }

    @Test //15
    @Story("TC - 5")
    @Description("Поле Логин и Пароль пустое при авторизации")
    public void loginAndPasswordFieldIsEmpty() {
        AuthSteps.textAuthorization();
        AuthSteps.clickLoginEmpty();
        AuthSteps.clickPasswordFieldIsEmpty();
        AuthPage.clickButtonSignIn();
        AuthSteps.textErrorWrong();
    }


}



