package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.scrollTo;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsButtonControlPanel;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsButtonFilterNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelAddNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonDeleteNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelButtonOkDeleteNews;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelRemoveCheckBoxActive;
import static ru.iteco.fmhandroid.ui.pages.ControlPanelPage.getNewsControlPanelRemoveCheckBoxNotActive;
import static ru.iteco.fmhandroid.ui.pages.CreatingNewsPage.getButtonCancelCancelCreatingNews;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitId;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import android.util.Log;
import android.view.View;

import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;

import org.hamcrest.Matcher;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class ControlPanelStepsNews {

    public static void clickButtonControlPanel() {
        Allure.step("Нажать на кнопку Панель управления");
        waitUntilElement(R.id.edit_news_material_button);
        onView(getNewsButtonControlPanel())
                .perform(click());
    }

    public static void waitUntilRecyclerViewLoaded() {
        onView(isRoot()).perform(waitId(R.id.news_list_recycler_view, 15000)); // Ждем до 15 сек
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));
    }


    public static void clickButtonDeleteNews(int index) {
        Allure.step("Нажать на кнопку Удалить новость");
        waitUntilRecyclerViewLoaded(); //  Ждем загрузки списка

        // 🔍 Выводим текущее состояние View Hierarchy перед кликом
        onView(isRoot()).perform(new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "Печать View Hierarchy";
            }

            @Override
            public void perform(UiController uiController, View view) {
                Log.d("Espresso", "View Hierarchy: " + view.toString());
            }
        });

        onView(getNewsControlPanelButtonDeleteNews(index))
                .perform(scrollTo(), click());
    }

    public static void clickClickNews() {
        Allure.step("Нажать на кнопку Новости на главной странице мобильного приложения");
        waitUntilElement(R.id.news_list_recycler_view); // ✅ Ждем загрузки списка новостей

        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(0, click())); // ✅ Кликаем по первой новости
    }

    public static void clickOkDeleteNews() {
        Allure.step("Нажать на кнопку OK Удалить новость");
        waitUntilElement(android.R.id.button1);
        onView(getNewsControlPanelButtonOkDeleteNews())
                .perform(scrollTo(), click());
    }

    public static void clickButtonCanselDeleteNews() {
        Allure.step("Нажать на кнопку Сохранить новость");
        waitUntilElement(android.R.id.button2);
        onView(getButtonCancelCancelCreatingNews())
                .perform(scrollTo(), click());
    }

    public static void clickRemoveCheckBoxNotActive() {
        Allure.step("Снять флажок с чекбокса Не активная");
        waitUntilElement(R.id.filter_news_inactive_material_check_box);
        onView(getNewsControlPanelRemoveCheckBoxNotActive())
                .perform(click());
    }

    public static void clickButtonFilterNewsControlPanel() {
        Allure.step("Нажать на кнопку Фильтровать");
        waitUntilElement(R.id.filter_button);
        onView(getNewsButtonFilterNews())
                .perform(click());
    }


    public static void clickRemoveCheckBoxActive() {
        Allure.step("Снять флажок с чекбокса Активная");
        waitUntilElement(R.id.filter_news_active_material_check_box);
        onView(getNewsControlPanelRemoveCheckBoxActive())
                .perform(click());
    }

    public static void clickAddNews() {
        Allure.step("Нажать на кнопку Добавить новость");
        waitUntilElement(R.id.add_news_image_view);
        onView(getNewsControlPanelAddNews())
                .perform(click());
    }

}
