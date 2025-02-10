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
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@LargeTest

@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки News и AllNews")
public class NewsTest {

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
    @Story("TC - 27")
    @Description("открытие страницы News через гамбургер меню (Позитивный)")
    public void openNewsPage() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        //проверка
        AuthPage.getFindText();

    }

    @Test //2
    @Story("TC - 26")
    @Description("открытие страницы News через AllNews (Позитивный)")
    public void openNewsPageThroughAllNews() {
        AuthSteps.validAuthorization();
        NewsSteps.clickButtonAllNews();
        //проверка
        AuthPage.getFindText();

    }

    @Test //3
    @Story("TC - 28")
    @Description("Просмотр новостей во вкладке Новости (Позитивный)")
    public void viewingNews() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickExpandNews();
    }


    @Test //4
    @Story("TC - 30")
    @Description("Открытие окна Filter news (Позитивный)")
    public void openFilterNews() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsPage.getFindText();
    }


    @Test //5
    @Story("TC - 31")
    @Description("Фильтрация новостей по категории (Позитивный)")
    public void filterNewsCategory() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonFilter();
    }


    @Test //6
    @Story("TC - 32")
    @Description("Фильтрация новостей по датам  (Позитивный)")
    public void filterNewsCertainPeriodTime() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        // NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonFilter();
    }

    @Test //7
    @Story("TC - 33")
    @Description("Фильтрация новостей по категории и датам в определенный период времени (Позитивный)")
    public void filterNewsCategoryAndTime() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();

        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
    }

    @Test //8
    @Story("TC - 34")
    @Description("Фильтрация новостей  по начальной дате (негативный)")
    public void filterNewsStartDate() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();

        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        //NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
        NewsSteps.clickButtonOkWrongMessage();
    }

    @Test //9
    @Story("TC - 35")
    @Description("Фильтрация новостей  по конечной дате (негативный)")
    public void filterNewsEndDate() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
        NewsSteps.clickButtonOkWrongMessage();
    }

    @Test //10
    @Story("TC - 36")
    @Description("Фильтрация новостей по категории и датам с отменой фильтрации (Позитивный)")
    public void filterNewsCategoryDateWithCancel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        //NewsPage.checkTextView();
        NewsSteps.clickButtonTitleFilterNews();

        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCancel();
    }

    @Test //11
    @Story("TC - 31")
    @Description("Фильтрация новостей по категории (Позитивный)")
    public void filterNewsEmpty() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonFilter();
    }

}
