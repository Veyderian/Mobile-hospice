package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.pressBack;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.EspressoIdlingResource;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки О приложении")
public class AboutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.countingIdlingResource);
    }

    @After
    public void tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.countingIdlingResource);
    }

    @Before
    public void authorizationCheck() {
        AuthSteps.validAuthorization();
    }

    @AfterClass
    public static void exit() {
        AuthSteps.clickButtonExit(AuthPage.getElementButtonExit());
        AuthSteps.clickButtonLogOut();
    }

    //  Тест-кейсы для проведения функционального тестирования вкладки "About" мобильного приложения "Мобильный хоспис".


    @Test //1
    @Story("TC - 74")
    // @Description("Просмотр ссылки Политика конфиденциальности во вкладке About")
    public void transitionPrivacyPolicy() {
        AboutSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonPrivacyPolicy();
        //Выход
        pressBack();
    }


    @Test //2
    @Story("TC - 75")
    // @Description("Просмотр ссылки Пользовательское соглашение во вкладке About")
    public void transitionTermsOfUse() {
        AuthSteps.validAuthorization();
        AboutSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonTermsOfUse();
        //Выход
        pressBack();
    }


}

