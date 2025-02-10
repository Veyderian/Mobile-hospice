package ru.iteco.fmhandroid.ui


import androidx.test.espresso.DataInteraction
import androidx.test.espresso.ViewInteraction
import androidx.test.filters.LargeTest
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent

import androidx.test.InstrumentationRegistry.getInstrumentation
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*

import ru.iteco.fmhandroid.R

import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

import org.hamcrest.Matchers.allOf
import org.hamcrest.Matchers.anything
import org.hamcrest.Matchers.`is`

@LargeTest
@RunWith(AndroidJUnit4::class)
class AppActivityTest2 {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun appActivityTest2() {
    val materialTextView = onView(
allOf(withId(R.id.all_news_text_view), withText("All news"),
childAtPosition(
allOf(withId(R.id.container_list_news_include_on_fragment_main),
childAtPosition(
withClassName(`is`("android.widget.LinearLayout")),
0)),
1),
isDisplayed()))
    materialTextView.perform(click())
    
    val materialButton = onView(
allOf(withId(R.id.filter_news_material_button),
childAtPosition(
childAtPosition(
withId(R.id.container_list_news_include),
0),
2),
isDisplayed()))
    materialButton.perform(click())
    
    val materialButton2 = onView(
allOf(withId(R.id.filter_button), withText("Filter"),
childAtPosition(
childAtPosition(
withId(R.id.nav_host_fragment),
0),
6),
isDisplayed()))
    materialButton2.perform(click())
    
    val textView = onView(
allOf(withText("News"),
withParent(withParent(withId(R.id.container_list_news_include))),
isDisplayed()))
    textView.check(matches(withText("News")))
    }

    private fun childAtPosition(
            parentMatcher: Matcher<View>, position: Int): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
