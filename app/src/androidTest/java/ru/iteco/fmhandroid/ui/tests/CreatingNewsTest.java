package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.pressBack;

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
import ru.iteco.fmhandroid.ui.pages.MainPage;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStepsNews;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;
import ru.iteco.fmhandroid.ui.steps.CreatingNewsSteps;

@LargeTest

@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Creating News")

public class CreatingNewsTest {
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
    @Story("TC - 48")
    @Description("Открытие вкладки Creating News на Control panel (Позитивный)")
    public void openCreatingNewsInControlPanel() {
    AuthSteps.validAuthorization();
    MainSteps.clickButtonMainMenu();
    NewsSteps.clickButtonNews();
    ControlPanelStepsNews.clickButtonControlPanel();
    ControlPanelStepsNews.clickAddNews();
    ControlPanelPage.getTextCreatingNews();
    pressBack();
    }

    @Test //2
    @Story("TC - 49")
    @Description("Создание новости на вкладке Control panel (Позитивный)")
    public void creatingNewsInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCreatingNew();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();

       pressBack();
    }
    @Test //3
    @Story("TC - 50")
    @Description("Создание новости c произвольным названием категории Control panel (Позитивный)")
    public void creatingNewsCategortyArbitraryNameInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCategoryCreatingNews();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();

        pressBack();
    }

    @Test //4
    @Story("TC - 51")
    @Description("Создание новости c отменой Control panel (Позитивный)")
    public void creatingNewsCategoryWithCancelInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCreatingNew();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonCancelCreatingNews();
        ControlPanelPage.getTextCreatingNews();
        pressBack();
    }


    @Test //5
    @Story("TC - 52")
    @Description("Создание новости c отменой отмены создания  (Позитивный)")
    public void creatingNewsCategoryWithCancelCancelInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCreatingNew();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonCancelCreatingNews();
        CreatingNewsSteps.clickButtonCancelCancelCreatingNews();
        ControlPanelPage.getTextCreatingNews();

        pressBack();

    }

    @Test//6
    @Story("TC - 53")
    @Description("Поле Категория пустое, при создании новости,  (Негативный)")
    public void fieldCategoryEmptyCreationNewsInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();
        CreatingNewsSteps.textError();

        pressBack();

    }


    @Test //7
    @Story("TC - 63")
    @Description("Поле Заголовок пустое, при создании новости, во вкладке Control panel(Негативный)")
    public void fieldTitleEmptyCreationNewsInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCreatingNew();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();
        CreatingNewsSteps.textError();
        pressBack();
    }


    @Test //8
    @Story("TC - 64")
    @Description("Поле Дата публикации пустое, при создании новости, во вкладке Control panel (Негативный)")
    public void fieldDateEmptyCreationNewsInControlPanel() {
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCategoryCreatingNews();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonTimeCreatingNews();
        CreatingNewsSteps.clickButtonOkTimeCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();
        CreatingNewsSteps.textError();
        pressBack();
    }


    @Test //9
    @Story("TC - 65")
    @Description("Поле Время пустое, при создании новости, во вкладке Control panel (Негативный)")

    public void fieldTimeEmptyCreationNewsInControlPanel() {
        AuthSteps.validAuthorization();
        MainSteps.clickButtonMainMenu();
        NewsSteps.clickButtonNews();
        ControlPanelStepsNews.clickButtonControlPanel();
        ControlPanelStepsNews.clickAddNews();
        CreatingNewsSteps.clickButtonCreatingNew();
        CreatingNewsSteps.clickButtonTitleCreatingNews();
        CreatingNewsSteps.clickButtonPublicationDateCreatingNews();
        CreatingNewsSteps.clickButtonOkDateCreatingNews();
        CreatingNewsSteps.clickDescriptionCreatingNews();
        CreatingNewsSteps.clickButtonSaveCreatingNews();
        CreatingNewsSteps.textError();
        pressBack();
    }

}



