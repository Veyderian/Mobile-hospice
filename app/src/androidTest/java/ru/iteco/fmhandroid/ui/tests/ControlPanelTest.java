package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.action.ViewActions.pressBack;

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
import ru.iteco.fmhandroid.ui.pages.NewsPage;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStepsNews;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;


@LargeTest
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Control panel")

public class ControlPanelTest {
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
    @Story("TC - 38")
    @Description("Открытие вкладки Control Panel (Позитивный)")
    public void openNewsControlPanel() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelPage.getTextControlPanel();
    }

    @Test //2
    @Story("TC - 40")
    @Description("Открытие вкладки Filter News на Control Panel (Позитивный)")
    public void openFilterNewsOnControlPanel() {
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
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonTitleFilterNews();
        NewsSteps.clickButtonFilter();
    }


    @Test //4
    @Story("TC - 42")
    @Description("Фильтрация новостей по датам  (Позитивный)")
    public void filterNewsCertainPeriodTime() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        NewsSteps.clickButtonDateStart();
        NewsSteps.clickButtonOkDate();
        NewsSteps.clickButtonDateEnd();
        NewsSteps.clickButtonFilter();
        pressBack();
    }

    @Test //5
    @Story("TC - 46")
    @Description("Фильтрация новостей по категории и датам в определенный период времени (Позитивный)")
    public void filterNewsCategoryAndTime() {
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
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        ControlPanelStepsNews.clickRemoveCheckBoxNotActive();
        NewsSteps.clickButtonFilter();
    }

    @Test //11
    @Story("TC - 65")
    @Description("Удаление активной новости во вкладке Control panel (Позитивный)")
    public void deletingActiveNews() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        //ControlPanelStepsNews.clickClickNews();
        ControlPanelStepsNews.clickButtonDeleteNews(2);
        ControlPanelStepsNews.clickOkDeleteNews();
    }

    @Test //12
    @Story("TC - 66")
    @Description("отмена удаления  новости во вкладке Панель управления мобильного приложения Мобильный хоспис (Позитивный)")
    public void cancelDeletingNews() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickButtonDeleteNews(1);
        ControlPanelStepsNews.clickButtonCanselDeleteNews();

    }


    @Test //13
    @Story("TC - 59")
    @Description("Фильтрация новостей по критерию Активна, во вкладке Панель управления новостей мобильного приложения Мобильный хоспис (Позитивный)")
    public void filterNewsByCriterionActive() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        NewsSteps.clickButtonFilterNews();
        ControlPanelStepsNews.clickRemoveCheckBoxActive();
        ControlPanelStepsNews.clickRemoveCheckBoxNotActive();
        ControlPanelStepsNews.clickButtonFilterNewsControlPanel();
    }

    @Test //1
    @Story("TC - 68")
    @Description("Открытие/закрытие описания новости на  вкладке Control Panel (Позитивный)")
    public void openNewsDescriptionControlPanel() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelPage.getTextControlPanel();
        ControlPanelStepsNews.clickClickNews();
        ControlPanelStepsNews.clickClickNews();
    }


}
