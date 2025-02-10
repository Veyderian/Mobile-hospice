package ru.iteco.fmhandroid.ui.tests;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.app.Activity;
import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Epic;
import ru.iteco.fmhandroid.ui.AppActivity;

@LargeTest
//@RunWith(AndroidJUnit4.class)
@RunWith(AllureAndroidJUnit4.class)

@Epic("Тест-кейсы для проведения функционального тестирования вкладки Authorization")


public class ToastTest {

//    private View decorView;
//    @Rule
//    public ActivityTestRule<AppActivity> activityTestRule =
//            new ActivityTestRule<>(AppActivity.class);
//
////    @Before
////    public void setUp() {
////        activityRule.getScenario.getScenario().onActivity(new ActivityScenario.ActivityAction < Activity >() {
////            @Override
////            public void perform (Activity activity ) {
////                decorView = activity.getWindow().getDecorView();
////            }
////        });
////    }
//    @Test
//    public void testToastError() {
//
////        onView (withText ("R.id.ToastText"))
//        onView (withText ("Fill empty fields"))
//                . inRoot(withDecorView(Matchers.not(decorView)))// Здесь вы используете decorView.check ( matchs ( isDisplayed ( ))) ;
//                .check (matches(isDisplayed())) ;
////        onView(withText("Fill empty fields"))
////                    //.inRoot(withDecorView(not(is(activity.getWindows()
////                    .inRoot(withDecorView(Matcher.not(decorView)))
////
////                    .check(matches(isDisplayed()));
////        }
//
//

        // Учитывая, что в сад пользователя не добавлено ни одного растения
        // При нажатии кнопки "Добавить растение" (желтая кнопка)
        // onView ( withId ( R . id . add_plant )). perform ( click ());
        // Проверяем, отображается ли тост после нажатия на фрагмент списка растений
        // onView ( withText ( "Welcome For The Visit" ))
        // . inRoot ( withDecorView ( Matchers . not ( decorView )))
        // Здесь мы используем decorView
        // . check ( matches ( isDisplayed ())); }
        // Проверяем, отображается ли тост-сообщение
        // @Test public void testToastNotDisplayed () {
        // Учитывая, что в сад пользователя не добавлено ни одного растения
        // При нажатии кнопки "Добавить растение" (желтая кнопка)
        // onView ( withId ( R . id . add_plant )). perform ( click ());
        // Проверка отображения тоста после щелчка по фрагменту списка растений
        // onView ( withText ( "Ваш тост" ) ) . inRoot ( withDecorView ( Matchers.not ( decorView )))
        // Здесь мы используем decorView.check ( matches ( not ( isDisplayed ( ) )); }

//    }

}
