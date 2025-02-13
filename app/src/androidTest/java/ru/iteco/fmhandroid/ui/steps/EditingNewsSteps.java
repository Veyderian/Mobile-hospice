package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonEditNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSaveEditingNews;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonSwitcher;
import static ru.iteco.fmhandroid.ui.pages.EditingNewsPage.getNewsControlPanelButtonTitleNews;
import static ru.iteco.fmhandroid.ui.pages.Wait.waitUntilElement;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class EditingNewsSteps {

    public static void clickButtonEditNews() {
        Allure.step("Нажать на кнопку Редактировать новость");
        waitUntilElement(R.id.edit_news_item_image_view);
        onView(getNewsControlPanelButtonEditNews())
                .perform(click());
    }

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
}
