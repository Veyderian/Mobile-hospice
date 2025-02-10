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
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonDateCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonOkDateCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonOkTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonSaveCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonTimeCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelButtonTitleCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getNewsControlPanelDescriptionCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class CreatingNewsSteps {
    public static void clickButtonCategoryCreatingNews() {
        Allure.step("Выбрать категорию для создания новости");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelButtonCreatingNews())
                .perform(click());
    }


    public static void clickButtonCreatingNew() {
        Allure.step("Выбрать категорию для создания новости");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelButtonCreatingNews())
                .perform(click(), replaceText("День рождения"), closeSoftKeyboard());
    }

    public static void textError() {

        Allure.step("Отобразилаcь ошибка: Fill empty fields");
        onView(allOf(withContentDescription("Fill empty fields"), isDisplayed()));
    }

    public static void clickButtonCreatingNewsEmpty() {
        Allure.step("Ввести в поле Категория собственное название категории");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelButtonCreatingNews())
                .perform(click(), replaceText("Собственное название категории"), closeSoftKeyboard());
    }

    public static void clickButtonCreatingNewsNumbers() {
        Allure.step("Ввести в поле Категория цифры");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelButtonCreatingNews())
                .perform(click(), replaceText("123456"), closeSoftKeyboard());
    }

    public static void clickButtonCreatingCharacters() {
        Allure.step("Ввести в поле Категория спецсимволы");
        waitUntilElement(R.id.news_item_category_text_auto_complete_text_view);
        onView(getNewsControlPanelButtonCreatingNews())
                .perform(click(), replaceText("@#$%^&**"), closeSoftKeyboard());
    }

    public static void clickButtonTitleCreatingNews() {
        Allure.step("Ввести в поле Заголовок заголовок новости");
        waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(getNewsControlPanelButtonTitleCreatingNews())
                .perform(click(), clearText(), replaceText("Главные новости сегодня"), closeSoftKeyboard());
    }

    public static void clickButtonPublicationDateCreatingNews() {
        Allure.step("В поле Дата публикации выбрать дату по календарю");
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(getNewsControlPanelButtonDateCreatingNews())
                .perform(click());
    }

    static String nextYear = "28.06.2026";

    public static void clickButtonPublicationDateCreatingNextDate() {
        Allure.step("В поле Дата публикации выбрать дату будущего года");
        waitUntilElement(R.id.news_item_publish_date_text_input_edit_text);
        onView(getNewsControlPanelButtonDateCreatingNews())
                .perform(replaceText(nextYear));
    }

    public static void clickButtonOkDateCreatingNews() {
        Allure.step("Нажать кнопку ОК Дата");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelButtonOkDateCreatingNews())
                .perform(click());
    }

    public static void clickButtonTimeCreatingNews() {
        Allure.step("В поле Время выбрать время");
        waitUntilElement(R.id.news_item_publish_time_text_input_edit_text);
        onView(getNewsControlPanelButtonTimeCreatingNews())
                .perform(click());
    }

    public static void clickDescriptionCreatingNews() {
        Allure.step("Ввести в поле Описание описание новости");
        waitUntilElement(R.id.news_item_description_text_input_edit_text);
        onView(getNewsControlPanelDescriptionCreatingNews())
                .perform(replaceText("Новое объявление"), closeSoftKeyboard());
    }

    public static void clickButtonOkTimeCreatingNews() {
        Allure.step("Нажать кнопку ОК Время");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelButtonOkTimeCreatingNews())
                .perform(click());
    }

    public static void clickButtonSaveCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        waitUntilElement(R.id.save_button);
        onView(getNewsControlPanelButtonSaveCreatingNews())
                .perform(scrollTo(), click());
    }

    public static void clickButtonCancelCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        waitUntilElement(R.id.cancel_button);
        onView(getButtonCancelCreatingNews())
                .perform(scrollTo(), click());
    }

    public static void clickButtonOkCancelCreatingNews() {
        Allure.step("Нажать на кнопку Ок для отмены создания новости (Позитивный)");
        waitUntilElement(android.R.id.button1);
        onView(getButtonOkCancelCreatingNews())
                .perform(scrollTo(), click());
    }

    public static void clickButtonCancelCancelCreatingNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        waitUntilElement(android.R.id.button2);
        onView(getButtonCancelCancelCreatingNews())
                .perform(scrollTo(), click());
    }
}
