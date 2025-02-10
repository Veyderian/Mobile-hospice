package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.NewsPage.withIndex;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class QuotesPage {
    public static Matcher<View> getQuotesButtonThematicQuote() {
        return allOf(withId(R.id.our_mission_image_button), withContentDescription("Our Mission"));
    }

    public static void getTextQuoters() {
        withId(R.id.our_mission_title_text_view);
        withText("Love is all");
    }

    public static Matcher<View> getQuotesButtonExpandThematicQuote() {
//        return allOf(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
        return allOf(withIndex(withId(R.id.our_mission_item_list_recycler_view), 1));
    }

    public static Matcher<View> getQuotesTitleThematicQuote() {
        return allOf(withId(R.id.our_mission_title_text_view));
    }

    public static Matcher<View> getQuotesDescriptionThematicQuote() {
        return allOf(withIndex(withId(R.id.our_mission_item_description_text_view), 0));
    }
}
