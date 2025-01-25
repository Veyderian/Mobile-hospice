package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.getAboutElementsButtonAbout;
import static ru.iteco.fmhandroid.ui.pages.AboutPage.getAboutElementsButtonMainMenu;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class AboutSteps {

    public static void clickButtonMainMenu() {
        Allure.step("Нажать на кнопку Главное меню");
        waitUntilElement(R.id.main_menu_image_button);
        //waitFor(2);
        onView(getAboutElementsButtonMainMenu())
                .perform(click());
    }

        public static void clickButtonAbout() {
            Allure.step("Нажать на кнопку О приложении");
            waitUntilElement(android.R.id.title);
            onView(getAboutElementsButtonAbout())
                    .perform(click());
        }

//        public static void clickButtonPrivacyPolicy () {
//            Allure.step("Нажать на ссылку Политика конфиденциальности");
//            waitUntilElement(R.id.about_privacy_policy_value_text_view);
//            onView(getAboutElementsButtonPrivacyPolicy())
//                    .check(matches(allOf(withText())));
//        }

//        public static void clickButtonTermsOfUse () {
//            Allure.step("Нажать на ссылку Пользовательское соглашение");
//            waitUntilElement(R.id.about_terms_of_use_value_text_view);
//            onView(getAboutElementsButtonTermsOfUse())
//                    .check(matches((Matcher<View>) allOf(withText("https://vhospice.org/#/terms-of-use"), isDisplayed(), isClickable())));
//        }

        static void waitUntilElement(int id){
        }
    }


