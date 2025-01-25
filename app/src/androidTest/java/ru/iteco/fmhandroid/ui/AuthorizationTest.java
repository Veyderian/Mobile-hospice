package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class AuthorizationTest {

    @Rule
    public ActivityTestRule<AppActivity> mActivityTestRule =
            new ActivityTestRule<>(AppActivity.class);
//@Before
//    public static Matcher<View> getAuthorizationElementsTextAuthorization() {
//        return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));
//    }


    @Test
    public void authorizationTest() {
        onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()));
        onView(withId(R.id.nav_host_fragment)).check(matches(isDisplayed()));



                                                        // Добавляем ожидание завершения SplashScreen
         ViewInteraction viewSplashScreen = onView(withId(R.id.nav_host_fragment));// Замените на ID корневого элемента SplashScreen
         viewSplashScreen.check(matches(isDisplayed())); // Убедитесь, что SplashScreen отображается
        // Ждем, пока SplashScreen исчезнет
        try {
            Thread.sleep(3000); // Временная задержка (нежелательно использовать в реальных тестах)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());

        ViewInteraction textInputEditText2 = onView(withId(R.id.password_text_input_layout));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());

        ViewInteraction materialButton = onView(
                allOf(withId(R.id.enter_button), withText("Sign in")));
         materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());

        ViewInteraction imageButton = onView(
                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        imageButton.check(matches(isDisplayed()));
    }
}




//    public void authorizationTest() {
//        ViewInteraction appCompatImageButton = onView(
//                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
//                        childAtPosition(
//                                allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                        childAtPosition(
//                                                withClassName(is("android.widget.LinearLayout")),
//                                                0)),
//                                5),
//                        isDisplayed()));
//        appCompatImageButton.perform(click());
//
//        ViewInteraction materialTextView = onView(
//                allOf(withId(android.R.id.title), withText("Log out"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withId(android.R.id.content),
//                                        0),
//                                0),
//                        isDisplayed()));
//        materialTextView.perform(click());
//
//        ViewInteraction textInputEditText = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.login_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());
//
//        ViewInteraction textInputEditText2 = onView(
//                allOf(childAtPosition(
//                                childAtPosition(
//                                        withId(R.id.password_text_input_layout),
//                                        0),
//                                0),
//                        isDisplayed()));
//        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());
//
//        ViewInteraction materialButton = onView(
//                allOf(withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
//                        childAtPosition(
//                                childAtPosition(
//                                        withClassName(is("android.widget.RelativeLayout")),
//                                        1),
//                                2),
//                        isDisplayed()));
//        materialButton.perform(click());
//
//        ViewInteraction imageButton = onView(
//                allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
//                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
//                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
//                        isDisplayed()));
//        imageButton.check(matches(isDisplayed()));
//    }
//
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



