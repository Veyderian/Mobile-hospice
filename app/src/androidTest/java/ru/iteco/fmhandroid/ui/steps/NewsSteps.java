package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonAllNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonCancel;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonDateEnd;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonDateStart;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonFilter;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonFilterNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonOkDate;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonOkWrongMessage;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getTitleFilterNews;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import androidx.test.espresso.assertion.ViewAssertions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;


public class NewsSteps {
    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        onView(getButtonNews())
                .check(ViewAssertions.matches(isDisplayed()))
                .perform(click());
    }


    public static void clickButtonAllNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        //waitUntilElement(android.R.id.all_news_text_view);
        waitUntilElement(R.id.all_news_text_view);
        onView(getButtonAllNews())
                .perform(click());
    }

    public static void clickExpandNews() {
        Allure.step("Нажать на кнопку развернуть новость");
        waitUntilElement(R.id.view_news_item_image_view);
        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(0, click())); // ✅ Кликаем по первой новости

    }

    public static void clickButtonFilterNews() {
        Allure.step("Нажать на кнопку Фильтровать Новости");
        waitUntilElement(R.id.filter_news_material_button);
        onView(getButtonFilterNews())
                .perform(click());
    }

    public static void clickButtonFilter() {
        Allure.step("нажать на кнопку filter");
        waitUntilElement(R.id.filter_button);
        onView(getButtonFilter())
                .perform(click());
    }


    public static void clickButtonCancel() {
        Allure.step("нажать на кнопку cansel");
        waitUntilElement(R.id.cancel_button);
        onView(getButtonCancel())
                .perform(click());
    }

    public static void clickButtonDateStart() {
        Allure.step("Указать диапазон дат - начальная дата");
        waitUntilElement(R.id.news_item_publish_date_start_text_input_edit_text);
        onView(getButtonDateStart())
                .perform(click());
    }

    public static void clickButtonOkDate() {
        Allure.step("Нажать на кнопку ОК");
        waitUntilElement(android.R.id.button1);
        onView(getButtonOkDate())
                .perform(click());
    }

    static String date = "20.12.2024";

    public static void clickButtonDateEnd() {
        Allure.step("Указать диапазон дат - конечная дата");
        waitUntilElement(R.id.news_item_publish_date_end_text_input_edit_text);
        onView(getButtonDateEnd())
                .perform(replaceText(date));
    }

    public static void clickButtonOkWrongMessage() {
        Allure.step("Нажать на кнопку ОК в Уведомлении");
        waitUntilElement(android.R.id.button1);
        onView(getButtonOkWrongMessage())
                .perform(click());
    }

    public static void clickButtonTitleFilterNews() {
        Allure.step("Нажать на кнопку категория  Фильтровать Новости");
        waitUntilElement(R.id.filter_news_title_text_view);
        onView(getTitleFilterNews())
                .check(ViewAssertions.matches(isDisplayed()))
                .perform(click());
    }
}
