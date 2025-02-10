package ru.iteco.fmhandroid.ui.steps;

import static androidx.core.content.MimeTypeFilter.matches;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.doubleClick;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import static ru.iteco.fmhandroid.ui.pages.NewsPage.checkableImageButton;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonAllNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonCancel;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonFilter;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonDateEnd;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonDateStart;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonExpandNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonFilterNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonNews;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonOkDate;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonOkWrongMessage;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.getButtonSorting;

import static ru.iteco.fmhandroid.ui.pages.NewsPage.getTitleFilterNews;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitFor;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;
//import static ru.iteco.fmhandroid.ui.steps.waitUntilElement;
//import static ru.iteco.fmhandroid.ui.steps.WaitId.waitUntilElement;

import androidx.test.espresso.assertion.ViewAssertions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;


public class NewsSteps {
    public static void clickButtonNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
//
        waitUntilElement(R.id.main_menu_image_button);
//        onView(getButtonNews())
//                .perform(click());
        waitFor(1);
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
        onView(getButtonExpandNews())
                .perform(doubleClick());
    }

    public static void clickButtonSorting() {
        Allure.step("Нажать на кнопку сортировки новостей");
        waitUntilElement(R.id.sort_news_material_button);
        onView(getButtonSorting())
                .perform(click());
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

    public static void clickСheckableImageButton() {
        Allure.step("нажать на стелочку выбора категории");
        waitUntilElement(R.id.text_input_end_icon);
        checkableImageButton
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
//    public static void waitUntilElement(int id) {
//        onView(withId(id)).check(ViewAssertions.matches(isDisplayed()));
//    }

    public static void clickButtonTitleFilterNews() {
        Allure.step("Нажать на кнопку категория  Фильтровать Новости");
        waitUntilElement(R.id.filter_news_title_text_view);
        onView(getTitleFilterNews())
                .check(ViewAssertions.matches(isDisplayed())) //(allOf(withText("Filter news"),
                .perform(click());
    }

    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {

            }

            @Override
            protected boolean matchesSafely(View item) {
                return false;
            }

            final int currentIndex = 0;
        };
    }
}
