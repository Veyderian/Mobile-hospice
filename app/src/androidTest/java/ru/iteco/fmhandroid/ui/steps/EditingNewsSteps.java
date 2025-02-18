package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonEditNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSaveEditingNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSwitcher;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonTitleNews;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitId;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.contrib.RecyclerViewActions;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

//import static isDisplayed;


public class EditingNewsSteps {

    public static void clickButtonTitleNewsControlPanel() {
        Allure.step("Отредактировать название новости");
        waitUntilElement(R.id.news_item_title_text_input_edit_text);
        onView(getNewsControlPanelButtonTitleNews())
                .perform(clearText(), replaceText("Отредактированный текст новости"), closeSoftKeyboard());
    }

    public static void clickButtonSaveEditingNews() {
        Allure.step("Нажать на кнопку Сохранить редактирование");
        waitUntilElement(R.id.save_button);
        onView(getNewsControlPanelButtonSaveEditingNews())
                .perform(click());
    }

    public static void clickButtonSwitcher() {
        Allure.step("Сменить статус");
        waitUntilElement(R.id.switcher);
        onView(getNewsControlPanelButtonSwitcher())
                .perform(click());
    }


    public static void waitUntilRecyclerViewLoaded() {
        onView(isRoot()).perform(waitId(R.id.news_list_recycler_view, 15000)); // Ждем до 15 сек
        onView(withId(R.id.news_list_recycler_view)).check(matches(isDisplayed()));

        // Проверяем, есть ли элементы в списке
        onView(withId(R.id.news_list_recycler_view)).check((view, noViewFoundException) -> {
            if (noViewFoundException != null) {
                throw noViewFoundException;
            }
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.getAdapter() == null || recyclerView.getAdapter().getItemCount() == 0) {
                throw new AssertionError("Список новостей пуст! Тест не может продолжаться.");
            }
        });
    }

    public static void clickClickEditNews() { //2
        Allure.step("Нажать на кнопку Новости");
        waitUntilElement(R.id.news_list_recycler_view); // Ждем загрузки списка новостей

        onView(withId(R.id.news_list_recycler_view))
                .perform(actionOnItemAtPosition(0, click())); // Кликаем по первой новости
    }

    public static void clickButtonEditNews(int index) {
        Allure.step("Нажать на кнопку редактировать новость");
        waitUntilRecyclerViewLoaded(); // Ждем загрузки списка

        //  Выводим количество новостей в логе
        onView(withId(R.id.news_list_recycler_view)).check((view, noViewFoundException) -> {
            RecyclerView recyclerView = (RecyclerView) view;
            Log.d("Espresso", "Всего элементов в списке: " + recyclerView.getAdapter().getItemCount());
        });

        //  Скроллим к нужному элементу перед кликом
        onView(withId(R.id.news_list_recycler_view))
                .perform(RecyclerViewActions.scrollToPosition(index));

        // кликаем по кнопке редактировать
        onView(getNewsControlPanelButtonEditNews(index))
                .perform(click());
    }

}

