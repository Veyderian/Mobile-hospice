package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class EditingNewsPage {
    public static Matcher<View> getNewsControlPanelButtonEditNews() {
        return allOf(withIndex(withId(R.id.edit_news_item_image_view), 0), isDisplayed());
        //return  allOf(withId(R.id.edit_news_item_image_view));
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

}
