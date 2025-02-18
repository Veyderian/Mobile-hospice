package ru.iteco.fmhandroid.ui.tests;


import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasData;
import static org.hamcrest.Matchers.allOf;

import android.content.Intent;

import androidx.test.espresso.intent.Intents;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;

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
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки About")

public class AboutTest {

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

//    @Rule
//    public IntentsTestRule intentsTestRule =
//            new IntentsTestRule<>(AppActivity.class);
//


    @Before
    public void authorizationCheck() {
        AuthSteps.validAuthorization();
    }

    @AfterClass
    public static void exit() {
        AuthSteps.clickButtonExit(AuthPage.getElementButtonExit());
        //AuthSteps.clickButtonExit();
        AuthSteps.clickButtonLogOut();
    }


    @Test //1
    @Story("TC - 69")
    @Description("Просмотр ссылки Политика конфиденциальности во вкладке About")
    public void transitionPrivacyPolicy() {
        Intents.init();
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonPrivacyPolicy();

        //onView(withId(R.id.about_privacy_policy_value_text_view)).perform(click());
        intended(allOf(hasAction(Intent.ACTION_VIEW), hasData("https://vhospice.org/#/privacy-policy/")));
        Intents.release();
        //Выход
        pressBack();
    }


    @Test //2
    @Story("TC - 70")
    @Description("Просмотр ссылки Пользовательское соглашение во вкладке About")
    public void transitionTermsOfUse() {
        Intents.init();
        MainSteps.clickButtonMainMenu();
        AboutSteps.clickButtonAbout();
        AboutSteps.clickButtonTermsOfUse();

        intended(hasAction(Intent.ACTION_VIEW));
        intended(hasData("https://vhospice.org/#/terms-of-use"));
        Intents.release();
        //Выход
        pressBack();
    }


}

