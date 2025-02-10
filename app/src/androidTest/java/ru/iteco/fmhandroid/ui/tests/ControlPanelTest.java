package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.pressBack;

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
import ru.iteco.fmhandroid.ui.pages.ControlPanelPage;
import ru.iteco.fmhandroid.ui.pages.EspressoIdlingResource;
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStepsNews;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
//import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.WaitId.waitUntilElement;


@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Authorization")

public class ControlPanelTest {
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
    @Description("Открытие вкладки Control Panel (Позитивный)")
    public void openNewsControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();

        ControlPanelPage.getTextControlPanel();
    }

    @Test //2
    @Story("TC - 40")
    @Description("Открытие вкладки Filter News на Control Panel (Позитивный)")
    public void openFilterNewsOnControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        ControlPanelPage.getTextControlPanel();

    }

    @Test //3
    @Story("TC - 41")
    @Description("Фильтрация новостей по категории (Позитивный)")
    public void filterNewsCategory() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
//        NewsSteps.clickButtonDateStart();
//        NewsSteps.clickButtonOkDateStart();
//        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
    }


    @Test //4
    @Story("TC - 42")
    @Description("Фильтрация новостей по датам  (Позитивный)")
    public void filterNewsCertainPeriodTime() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        // NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonFilter();
        pressBack();
    }

    @Test //5
    @Story("TC - 46")
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

    @Test //6
    @Story("TC - 44")
    @Description("Фильтрация новостей  по начальной дате (негативный)")
    public void filterNewsStartDate() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonFilter();
        NewsSteps.clickButtonOkWrongMessage();
    }

    @Test //7
    @Story("TC - 45")
    @Description("Фильтрация новостей  по конечной дате (негативный)")
    public void filterNewsEndDate() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
        NewsSteps.clickButtonOkWrongMessage();
    }

    @Test //8
    @Story("TC - 46")
    @Description("Фильтрация новостей по категории и датам с отменой фильтрации (Позитивный)")
    public void filterNewsCategoryDateWithCancel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        //NewsPage.checkTextView();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonCancel();
    }

    @Test //9
    @Story("TC - 47")
    @Description("Фильтрация новостей с пустыми полями (Позитивный)")
    public void filterNewsEmpty() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonFilter();
        NewsPage.getFindText();
    }


    @Test //10
    @Story("TC - 43")
    @Description("Фильтрация новостей по критерию Не активна (Позитивный)")
    public void filterNewsByCriterionNotActive() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        ControlPanelStepsNews.clickRemoveCheckBoxNotActive();
        NewsSteps.clickButtonFilter();
    }

    @Test //11
    @Story("TC - 65")
    @Description("Удаление активной новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void deletingActiveNews() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickClickNews();
        ControlPanelStepsNews.clickButtonDeleteNews();
        ControlPanelStepsNews.clickOkDeleteNews();
    }

    @Test //12
    @Story("TC - 66")
    @Description("Удаление  новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void cancelDeletingNews() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickClickNews();
        ControlPanelStepsNews.clickButtonDeleteNews();

    }


    @Test
    @Story("TC - 59")
    @Description("Фильтрация новостей по критерию Активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionActive() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        //NewsSteps.clickFilterNews();
        ControlPanelStepsNews.clickRemoveCheckBoxActive();
        ControlPanelStepsNews.clickButtonFilterNewsControlPanel();
    }


}
