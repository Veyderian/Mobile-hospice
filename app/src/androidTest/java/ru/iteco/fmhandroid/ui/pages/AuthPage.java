package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;


    public class AuthPage<withText> extends AuthSteps {

        public static Matcher<View> getTextAuthorization() {
            return allOf(withText("Authorization"), withParent(withParent(withId(R.id.nav_host_fragment))));

        }

        public static Matcher<View> getAuthLoginField() {
            return allOf(withHint("Login"),
                    withParent(withParent(withId(R.id.login_text_input_layout))));
        }

        public static Matcher<View> getAuthPasswordField() {
            return allOf(withHint("Password"),
                    withParent(withParent(withId(R.id.password_text_input_layout))));
        }

        public static ViewInteraction enterButton = // Инициализация кнопки "Войти"
                onView(withId(R.id.enter_button));


        public static int getElementButtonExit() {
            return R.id.authorization_image_button;
        }


        public static ViewInteraction exitButton =
            onView(allOf(
                    withId(R.id.authorization_image_button), withContentDescription("Authorization")));


        public static Matcher<View> getElementsButtonLogOut() {
            return allOf(withId(android.R.id.title), withText("Log out"));
        }

        public static void getFindText() {
            withText("News");
            withParent(withParent(withId(R.id.container_list_news_include_on_fragment_main)));
            isDisplayed();
        }
//        public static ViewInteraction titleTextElement =
//                onView(withText("Authorization"));
        //        public static void titleTextElement() {
//            withText("Authorization");
//        }


//        private static Matcher<View> childAtPosition(
//                final Matcher<View> parentMatcher, final int position) {
//
//            return new TypeSafeMatcher<View>() {
//                @Override
//                public void describeTo(Description description) {
//                    description.appendText("Child at position " + position + " in parent ");
//                    parentMatcher.describeTo(description);
//                }
//
//                @Override
//                public boolean matchesSafely(View view) {
//                    ViewParent parent = view.getParent();
//                    return parent instanceof ViewGroup && parentMatcher.matches(parent)
//                            && view.equals(((ViewGroup) parent).getChildAt(position));
//                }
//            };

//        }
    }

