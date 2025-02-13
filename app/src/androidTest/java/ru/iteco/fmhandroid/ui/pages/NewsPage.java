package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;

public class NewsPage {


    public static Matcher<View> getButtonNews() {
        return allOf(withId(android.R.id.title), withText("News"));
    }

    public static Matcher<View> getButtonExpandNews() {
        //return allOf(withIndex(withId(R.id.view_news_item_image_view), 2));
        return allOf(withIndex(withId(R.id.news_list_recycler_view), 2));
    }

    public static Matcher<View> getButtonSorting() {
        return allOf(withId(R.id.sort_news_material_button), withContentDescription("Sort news list button"), isDisplayed());
    }

    public static Matcher<View> getButtonFilterNews() {
        return withId(R.id.filter_news_material_button);
    }

    public static Matcher<View> getButtonAllNews() {
        waitUntilElement(R.id.all_news_text_view);
        return allOf(withId(R.id.all_news_text_view), withText("All news"));

    }

    public static void getFindText() {
        allOf(withId(R.id.filter_news_title_text_view), withText("Filter news"),
                //withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed());
    }

    public static void getFindText1() {
        allOf(withId(R.id.empty_news_list_text_view), withText("There is nothing here yet…"),
                isDisplayed());
    }


    public static Matcher<View> getButtonFilter() {
        return allOf(withId(R.id.filter_button));
    }

    public static Matcher<View> getButtonCancel() {
        return allOf(withId(R.id.cancel_button));
    }

    public static ViewInteraction checkableImageButton = onView(
            allOf(withId(R.id.text_input_end_icon), withContentDescription("Show dropdown menu"),
                    childAtPosition(
                            childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")),
                                    1),
                            0),
                    isDisplayed()));
    //checkableImageButton.perform(click());


    public static Matcher<View> getButtonDateStart() {
        return allOf(withId(R.id.news_item_publish_date_start_text_input_edit_text));
    }

    public static Matcher<View> getButtonOkDate() {
        return allOf(withId(android.R.id.button1), withText("OK"));
    }

    public static Matcher<View> getButtonDateEnd() {
        return allOf(withId(R.id.news_item_publish_date_end_text_input_edit_text));
    }

    public static Matcher<View> getButtonOkWrongMessage() {
        return allOf(withId(android.R.id.button1));
    }

    public static Matcher<View> getButtonClickNews() {
        return allOf(withIndex(withId(R.id.news_item_material_card_view), 0));
    }

    public static Matcher<View> getButtonDeleteNews() {
        return allOf(withIndex(withId(R.id.delete_news_item_image_view), 0));
    }

    public static Matcher<View> getTitleFilterNews() {
        return allOf(withId(R.id.filter_news_title_text_view));
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

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };

    }
}
