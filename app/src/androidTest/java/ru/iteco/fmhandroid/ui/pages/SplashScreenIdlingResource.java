package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;

import android.view.View;

import androidx.test.espresso.IdlingResource;
import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.test.espresso.matcher.ViewMatchers;

import org.hamcrest.Matcher;

//public class SplashScreenIdlingResource implements IdlingResource {
//    private final Matcher<View> viewMatcher;
//    private ResourceCallback resourceCallback;
//
//    public SplashScreenIdlingResource(Matcher<View> viewMatcher) {
//        this.viewMatcher = viewMatcher;
//    }
//
//    @Override
//    public String getName() {
//        return SplashScreenIdlingResource.class.getName();
//    }
//
//    @Override
//    public boolean isIdleNow() {
//        try {
//            onView(viewMatcher).check(matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
//            if (resourceCallback != null) {
//                resourceCallback.onTransitionToIdle();
//            }
//            return true;
//        } catch (NoMatchingViewException | AssertionError e) {
//            return false;
//        }
//    }
//
//
//    @Override
//    public void registerIdleTransitionCallback(ResourceCallback callback) {
//        this.resourceCallback = callback;
//   }
//}
