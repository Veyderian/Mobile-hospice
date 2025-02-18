package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.childAtPosition;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class EditingNewsPage {

    public static Matcher<View> getNewsControlPanelButtonEditNews() {
        return allOf(
                withIndex(withId(R.id.edit_news_item_image_view), 0),
                isDescendantOfA(withId(R.id.container_list_news_include)), // Уточняем родительский элемент
                isDisplayed()
        );
    }


    public static Matcher<View> getNewsControlPanelButtonTitleNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelButtonSaveEditingNews() {
        return allOf(withId(R.id.save_button), withText("Save"));
    }

    public static Matcher<View> getNewsControlPanelButtonSwitcher() {
        return withId(R.id.switcher);
    }

    public static Matcher<View> getNewsControlPanelButtonEditNews(int index) {
        return allOf(
                withId(R.id.edit_news_item_image_view),
                withContentDescription("News editing button"),
                isDescendantOfA(childAtPosition(
                        withId(R.id.news_list_recycler_view), index)), // Ищем внутри index-й новости
                isDisplayed()
        );
    }


}
