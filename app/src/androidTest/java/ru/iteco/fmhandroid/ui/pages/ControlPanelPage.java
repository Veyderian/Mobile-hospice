package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import android.accessibilityservice.AccessibilityService;
import android.view.View;
import android.widget.LinearLayout;

import androidx.test.core.app.ActivityScenario;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.ControlPanelStepsNews;

public class ControlPanelPage extends ControlPanelStepsNews {

//ControlPanel
    public static Matcher<View> getNewsButtonControlPanel() {
        return allOf(withId(R.id.edit_news_material_button));
    }

    public static Matcher<View> getNewsControlPanelButtonClickNews() {
        return allOf(withIndex(withId(R.id.news_item_material_card_view), 0));
    }

    public static Matcher<View> getNewsControlPanelButtonDeleteNews() {
        return allOf(withIndex(withId(R.id.delete_news_item_image_view), 0));
    }

//    public static Matcher<View> getNewsControlPanelTitleFilterNews() {
//        return allOf(withId(R.id.filter_news_title_text_view));
//    }

//    public static Matcher<View> getNewsControlPanelButtonSorting() {
//        return allOf(withId(R.id.sort_news_material_button));
//    }

    public static Matcher<View> getNewsControlPanelButtonOkDeleteNews() {
        return allOf(withId(android.R.id.button1));
    }
//Editing news

//    public static Matcher<View> getNewsFilterNewsControlPanel() {
//        return allOf(withId(R.id.filter_news_material_button));
//    }

    public static Matcher<View> getNewsControlPanelRemoveCheckBoxNotActive() {
        return allOf(withId(R.id.filter_news_inactive_material_check_box));
    }

    public static Matcher<View> getNewsButtonFilterNews() {
        return allOf(withId(R.id.filter_button));
    }

    public static Matcher<View> getNewsControlPanelRemoveCheckBoxActive() {
        return allOf(withId(R.id.filter_news_active_material_check_box));
    }

    public static Matcher<View> getNewsControlPanelAddNews() {
        return allOf(withId(R.id.add_news_image_view), withContentDescription("Add news button"));
    }
    public static void getTextCreatingNews() {
        withId(R.id.custom_app_bar_title_text_view);
        withText("Creating");
    }

    public static void getTextEditingNews() {
        withId(R.id.custom_app_bar_title_text_view);
        withText("Editing");
    }


    public static void getTextControlPanel() {
        withText("Control panel");

        //allOf(withText("Control panel"),
//                withParent(withParent(IsInstanceOf.<View>instanceOf(LinearLayout.class))),
//                isDisplayed()));
    }

// Creating news


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
