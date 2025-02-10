package ru.iteco.fmhandroid.ui.tests;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.AfterClass;
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
import ru.iteco.fmhandroid.ui.pages.EspressoIdlingResource;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;


@LargeTest

@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки News и AllNews")
public class MainTest {

    @Rule
    public ActivityTestRule<AppActivity> activityTestRule =
            new ActivityTestRule<>(AppActivity.class);

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
        //AuthSteps.clickButtonExit(AuthPage.getElementButtonExit());
        AuthSteps.clickButtonExit();
        AuthSteps.clickButtonLogOut();
    }

    @Test //1
    @Story("TC - 38")
    @Description("Открытие вкладки Main из гамбургер меню(Позитивный)")
    public void openMainMenu() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        AuthPage.getFindText();

    }

}

