package ru.iteco.fmhandroid.ui.tests;

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
import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Epic;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pages.AuthPage;
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.EspressoIdlingResource;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStepsNews;
import ru.iteco.fmhandroid.ui.steps.EditingNewsSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Editing News")


public class EditingNewsTest {
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


    @Test //1
    @Story("TC - 57")
    @Description("открытие вкладки Editing news")
    public void editNewsControlPanel() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        EditingNewsSteps.clickButtonEditNews();
        ControlPanelPage.getTextEditingNews();

    }

    @Test //1
    @Story("TC - 57")
    @Description("редактирование строки TitleEditing news")
    public void editNewsTitleControlPanel() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        EditingNewsSteps.clickButtonEditNews();
        EditingNewsSteps.clickButtonTitleNewsControlPanel();
        ControlPanelPage.getTextEditingNews();

    }

    @Test //2
    @Story("TC - 63")
    @Description("Смена статуса новости, находящейся в статусе АКТИВНА на статус НЕ АКТИВНА(Позитивный)")
    public void statusChangeNews() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        EditingNewsSteps.clickButtonEditNews();
        EditingNewsSteps.clickButtonSwitcher();
        EditingNewsSteps.clickButtonSaveEditingNews();
    }
}
