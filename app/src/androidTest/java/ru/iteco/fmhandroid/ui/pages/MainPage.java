package ru.iteco.fmhandroid.ui.pages;

import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

import android.view.View;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class MainPage extends MainSteps {
    public static Matcher<View> getButtonMainMenu() {
        return allOf(withId(R.id.main_menu_image_button), withContentDescription("Main menu"));

    }



}
