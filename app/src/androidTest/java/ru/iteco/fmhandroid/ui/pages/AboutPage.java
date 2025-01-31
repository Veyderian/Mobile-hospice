package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AboutSteps;

public class AboutPage extends AboutSteps {

    public static Matcher<View> getAboutElementsButtonMainMenu() {
        return  allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"));

    }
    public static  Matcher<View> getAboutElementsButtonAbout() {
        return allOf(withId(android.R.id.title), withText("About"));
    }

    public static Matcher<View> getAboutElementsButtonPrivacyPolicy() {
        return allOf(withId(R.id.about_privacy_policy_value_text_view));
    }

    public static Matcher<View> getAboutElementsButtonTermsOfUse() {
        return withId(R.id.about_terms_of_use_value_text_view);
    }
//    private static Matcher<View> childAtPosition(
//            final Matcher<View> parentMatcher, final int position) {
//
//        return new TypeSafeMatcher<View>() {
//            @Override
//            public void describeTo(Description description) {
//                description.appendText("Child at position " + position + " in parent ");
//                parentMatcher.describeTo(description);
//            }
//
//            @Override
//            public boolean matchesSafely(View view) {
//                ViewParent parent = view.getParent();
//                return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                        && view.equals(((ViewGroup) parent).getChildAt(position));
//            }
//        };

//}
}
