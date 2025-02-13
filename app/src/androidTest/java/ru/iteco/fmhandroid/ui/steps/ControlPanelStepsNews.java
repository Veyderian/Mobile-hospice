package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getButtonCancelCancelCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getButtonCancelCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getButtonOkCancelCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsButtonControlPanel;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsButtonFilterNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonClickNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonDateCreatingNews;
//import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonDeleteNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonDeleteNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonEditNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsButtonFilterNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonOkDateCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonOkDeleteNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonOkTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonSaveCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSaveEditingNews;
//import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonSorting;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSwitcher;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonTitleCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonTitleNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonTitleNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelDescriptionCreatingNews;
//import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsFilterNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelRemoveCheckBoxActive;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelRemoveCheckBoxNotActive;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;
//import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ControlPanelStepsNews {

    public static void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        waitUntilElement(R.id.edit_news_material_button);
        onView(getNewsButtonControlPanel())
                .perform(click());
    }

    public static void clickButtonDeleteNews(){
        Allure.step("Нажать на кнопку Удалить новость");
        waitUntilElement(R.id.delete_news_item_image_view);
        onView(getNewsControlPanelButtonDeleteNews())
                .perform(click());
    }

    public static void clickClickNews(){
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        waitUntilElement(R.id.news_item_material_card_view);
        onView(getNewsControlPanelButtonClickNews())
                .perform(click());
    }
    public static void clickExtendNews(){
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        waitUntilElement(R.id.news_item_material_card_view);
        onView(getNewsControlPanelButtonClickNews())
                .perform(click());
    }

    public static void clickOkDeleteNews() {
        Allure.step("Нажать на кнопку OK Удалить новость");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelButtonOkDeleteNews())
                .perform(click());
    }

    public static void clickRemoveCheckBoxNotActive() {
        Allure.step("Снять флажок с чекбокса Не активная");
        waitUntilElement(R.id.filter_news_inactive_material_check_box);
        onView(getNewsControlPanelRemoveCheckBoxNotActive())
                .perform(click());
    }


//    public static void clickFilterNewsControlPanel() {
//        Allure.step("Нажать на кнопку Фильтровать Новости");
//        waitUntilElement(R.id.filter_news_material_button);
//        onView(getNewsButttonFilterNews())
//                .perform(click());
//    }

    public static void clickButtonFilterNewsControlPanel() {
        Allure.step("Нажать на кнопку Фильтровать");
        waitUntilElement(R.id.filter_button);
        onView(getNewsButtonFilterNews())
                .perform(click());
    }


    public static void clickRemoveCheckBoxActive() {
        Allure.step("Снять флажок с чекбокса Активная");
        waitUntilElement(R.id.filter_news_active_material_check_box);
        onView(getNewsControlPanelRemoveCheckBoxActive())
                .perform(click());
    }

    public static void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        waitUntilElement(R.id.add_news_image_view);
        onView(getNewsControlPanelAddNews())
                .perform(click());
    }

}
