package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static kotlinx.coroutines.flow.FlowKt.withIndex;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;
//import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;

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
          return allOf(withIndex(withId(R.id.view_news_item_image_view), 2));
        //return allOf(withId(R.id.view_news_item_image_view));
    }

    public static Matcher<View> getButtonSorting() {
        return allOf(withId(R.id.sort_news_material_button), withContentDescription("Sort news list button"));
    }

    public static Matcher<View> getButtonFilterNews() {
        return withId(R.id.filter_news_material_button);
    }

    public static Matcher<View> getButtonAllNews() {
        waitUntilElement(R.id.all_news_text_view);
        return allOf(withId(R.id.all_news_text_view), withText("All news"));

    }

//    private static void waitUntilElement(int allNewsTextView) {
//    }

//    public static ViewInteraction getFindTextNews = onView(
//            allOf(withId(R.id.filter_news_title_text_view), withText("Filter news"),
//                    withParent(withParent(withId(R.id.nav_host_fragment))),
//                    isDisplayed()));
        //textView.check(matches(withText("Filter news")));

    public static void getFindText() {
        allOf(withId(R.id.filter_news_title_text_view), withText("Filter news"),
                //withParent(withParent(withId(R.id.nav_host_fragment))),
                isDisplayed());
    }
//    public static Object getFindText;

    public static Matcher<View> getButtonFilter() {
        return allOf(withId(R.id.filter_button));
    }

    public static Matcher<View> getButtonCancel() {
        return allOf(withId(R.id.cancel_button));
    }

    // проверка, что появилась надпись Filter news

    // filter_news_title_text_view "Filter news"
    // строка категория
    // news_item_category_text_input_layout
    // news_item_category_text_auto_complete_text_view

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
