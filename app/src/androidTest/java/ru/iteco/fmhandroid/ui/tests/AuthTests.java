package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.enterText;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getElementButtonExit;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.EspressoIdlingResource;
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

        @Before
        public void setUp() {
            IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource);
        }

        @After
        public void tearDown() {
            IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource);
        }


        @Before
        public void authorizationVerification() {

            try {
                AuthPage.textAuthorization();
            } catch (androidx.test.espresso.NoMatchingViewException e) {
                AuthPage.clickButtonExit(AuthPage.getElementButtonExit());
                AuthSteps.clickButtonLogOut();
            }

        }


        // Тест-кейсы для проведения функционального тестирования вкладки "Authorization" мобильного приложения "Мобильный хоспис".


        @Test //1
        @Story("TC - 1")
        @Description("Авторизация в мобильном приложении Мобильный хоспис (Позитивный)")
        public void successfulAuthorization() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginField();
            AuthSteps.clickPasswordField();
            AuthPage.clickButtonSignIn();
            AuthPage.getFindText();

//            AuthPage.clickButtonExit(getElementButtonExit());
//            AuthSteps.clickButtonLogOut();
        }


        @Test //2
        @Story("TC - 2")
        @Description("Поле Логин пустое при авторизации")
        public void loginFieldIsEmpty() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginEmpty();
            AuthSteps.clickPasswordField();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorEmpty();
        }


        @Test //3
        @Story("TC - 3")
        @Description("Поле Логин заполнено данными незарегистрированного пользователя при авторизации")
        public void loginFieldUnregisteredUser() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginFieldUnregisteredUser();
            AuthSteps.clickPasswordField();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }


        @Test //4
        @Story("TC - 4")
        @Description("Поле Логин состоит из спецсимволов при авторизации")
        public void loginFieldWithSpecialCharacters() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginFieldWithSpecialCharacters();
            AuthSteps.clickPasswordField();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }


        @Test //5
        @Story("TC - 5")
        @Description("Поле Логин состоит из одного символа при авторизации")
        public void loginFieldOneSymbol() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginFieldOneSymbol();
            AuthSteps.clickPasswordField();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }


        @Test //6
        @Story("TC - 6")
        @Description("Поле Пароль пустое при авторизации")
        public void passwordFieldIsEmpty() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginField();
            AuthSteps.clickPasswordFieldIsEmpty();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }


        @Test //7
        @Story("TC - 3")
        @Description("Поле Пароль заполнено невалидными данными при авторизации")
        public void passwordFieldWrongPassword() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginField();
            AuthSteps.clickPasswordFieldWrongPasword();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }


        @Test //7
        @Story("TC - 7")
        @Description("Поле Пароль состоит из одного символа при авторизации")
        public void passwordFieldOneSymbol() {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginField();
            AuthSteps.clickPasswordFieldOneSymbol();
            AuthPage.clickButtonSignIn();
            AuthSteps.textErrorWrong();
        }
    }


