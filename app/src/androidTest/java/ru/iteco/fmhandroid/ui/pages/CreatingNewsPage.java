package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.CreatingNewsSteps;

public class CreatingNewsPage extends CreatingNewsSteps {
    public static Matcher<View> getNewsControlPanelButtonCreatingNews() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public static Matcher<View> getNewsControlPanelButtonTitleCreatingNews() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelButtonDateCreatingNews() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelButtonOkDateCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelButtonTimeCreatingNews() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelDescriptionCreatingNews() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public static Matcher<View> getNewsControlPanelButtonOkTimeCreatingNews() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getNewsControlPanelButtonSaveCreatingNews() {
        return allOf(withId(R.id.save_button));
    }

    // уточнить id
    public static Matcher<View> getButtonCancelCreatingNews() {
        return allOf(withId(R.id.cancel_button), withText("Cancel"), withContentDescription("Cancel"));
    }

    public static Matcher<View> getButtonOkCancelCreatingNews() {
        return allOf(withId(android.R.id.button1), withText("OK"));
    }

    public static Matcher<View> getButtonCancelCancelCreatingNews() {
        return allOf(withId(android.R.id.button2), withText("Cancel"));
    }
}
