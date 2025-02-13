package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.getQuotesButtonExpandThematicQuote;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.getQuotesButtonThematicQuote;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.getQuotesDescriptionThematicQuote;
import static ru.iteco.fmhandroid.ui.pages.QuotesPage.getQuotesTitleThematicQuote;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class QuotesSteps {
    public static void clickButtonThematicQuote() {
        Allure.step("Нажать на кнопку Тематические цитаты");
        waitUntilElement(R.id.our_mission_image_button);
        onView(getQuotesButtonThematicQuote())
                .perform(click());
    }

    public static void clickButtonExpandThematicQuote() {
        Allure.step("Развернуть тематическую цитату");
        //waitUntilElement(R.id.our_mission_item_open_card_image_button);
        waitUntilElement(R.id.our_mission_item_list_recycler_view);
        onView(getQuotesButtonExpandThematicQuote())
                .perform(actionOnItemAtPosition(0, click()));
    }

    public static void clickTitleThematicQuote() {
        Allure.step("Кликнуть на название тематической цитаты");
        waitUntilElement(R.id.our_mission_title_text_view);
        onView(getQuotesTitleThematicQuote())
                .check(matches(allOf(withText("Love is all"), isDisplayed())));
    }

    public static void clickDescriptionThematicQuote() {
        Allure.step("Нажать на содержимое тематической цитаты");
        waitUntilElement(R.id.our_mission_item_description_text_view);
        onView(getQuotesDescriptionThematicQuote())
                .check(matches(isDisplayed()));
    }
}
