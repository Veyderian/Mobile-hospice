package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.getAboutElementsButtonAbout;
import static ru.iteco.fmhandroid.ui.pages.MainPage.getButtonMainMenu;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.getAboutElementsButtonPrivacyPolicy;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.getAboutElementsButtonTermsOfUse;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitFor;
import static ru.iteco.fmhandroid.ui.pages.WaitId.waitUntilElement;
import ru.iteco.fmhandroid.ui.pages.AboutPage;

import android.view.View;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutSteps {






    public static void clickButtonAbout() {
        Allure.step("Нажать на кнопку О приложении");
        waitUntilElement(android.R.id.title);
        onView(getAboutElementsButtonAbout())
                .perform(click());
    }

    public static void clickButtonPrivacyPolicy() {
        Allure.step("Нажать на ссылку Политика конфиденциальности");
        waitUntilElement(R.id.about_privacy_policy_value_text_view);
        onView(getAboutElementsButtonPrivacyPolicy())
                .check(matches(allOf(withText("https://vhospice.org/#/privacy-policy/"), isDisplayed(), isClickable())))
                .perform(click());

    }

    public static void clickButtonTermsOfUse() {
        Allure.step("Нажать на ссылку Пользовательское соглашение");
        waitUntilElement(R.id.about_terms_of_use_value_text_view);
        onView(getAboutElementsButtonTermsOfUse())
                .check(matches((Matcher<View>) allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())))
                .perform(click());
    }

//    static void waitUntilElement(int id) {
//    }
}


