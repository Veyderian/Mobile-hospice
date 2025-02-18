package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.pages.MainPage.getButtonMainMenu;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitFor;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainSteps {
    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
       // waitUntilElementIsVisible(R.id.main_menu_image_button, 10000);
        waitUntilElement(R.id.main_menu_image_button);
        waitFor(2);
        onView(getButtonMainMenu())
                .check(matches(isDisplayed()))
                .perform(click());
    }
    public static void waitUntilElementIsVisible(int viewId, int timeout) {
        onView(withId(viewId))
                .perform(waitFor(timeout))
                .check(matches(isDisplayed())); // Проверяем, что элемент реально отображается
    }
}
