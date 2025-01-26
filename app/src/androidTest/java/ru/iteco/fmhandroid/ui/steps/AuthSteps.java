package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.enterButton;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getAuthLoginField;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getAuthPasswordField;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.getElementsButtonLogOut;
import static ru.iteco.fmhandroid.ui.pages.AuthPage.titleTextElement;

import androidx.test.espresso.NoMatchingViewException;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;
//import static ru.iteco.fmhandroid.pages.WaitId.waitFor;


public class AuthSteps {


    // public static void authorization() {
//            try {
//                AuthPage.textAuthorization();
//            } catch (NoMatchingViewException e) {
//                return;
//            }
//            AuthSteps.clickLoginField();
//            AuthSteps.clickPasswordField();
//            AuthPage.clickButton(AuthPage.getAuthElementsButton());
//        }
    public static void validAuthorization() {
        try {
            AuthSteps.textAuthorization();
            AuthSteps.clickLoginField();
            AuthSteps.clickPasswordField();
            AuthSteps.clickButtonSignIn();
        } catch (NoMatchingViewException e) {
            System.out.println("Already auth");
        }
    }

    public static void textAuthorization() {
        Allure.step("Отобразилаcь страница Авторизации");
        //waitUntilElement(R.id.nav_host_fragment);
        titleTextElement.check(matches(isDisplayed()));
    }


//    public static void textAuthorization() {
//        Allure.step("страница авторизации");
//        waitUntilElement(R.id.nav_host_fragment);
////        onView(
////                allOf(withText("Authorization"),
////                        withParent(withParent(withId(R.id.nav_host_fragment))),
////                        isDisplayed())).check(matches(withText("Authorization")));
////        //waitFor(3);
//        onView(getTextAuthorization())
//                .check(matches(isDisplayed()));
//    }
//public static void textAuthorization() {
//    Allure.step("страница авторизации");

    // Ждем окончания работы splashscreen
    // waitUntilElementDisappears(R.id.splash_screen_circular_progress_indicator);

//    waitUntilElement(R.id.nav_host_fragment);
//        onView(allOf(withText("Authorization"),
//            (withId(R.id.nav_host_fragment)))).check(matches(isDisplayed()));

//    onView(getTextAuthorization())
//            .check(matches(isDisplayed()));
//}
//    public static void waitUntilElementDisappears(int resourceId) {
//        onView(withId(resourceId))
//                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
//    }


//    private static void waitUntilElementDisappears(int splashScreenCircularProgressIndicator) {
//    }


    public static void clickLoginField() {
        Allure.step("В поле Логин ввести: login2");
        waitUntilElement(R.id.login_text_input_layout);
        onView(getAuthLoginField())
                .perform(replaceText("login2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));

    }

    public static void clickPasswordField() {
        Allure.step("В поле Пароль ввести: password2");
        waitUntilElement(R.id.password_text_input_layout);
        onView(getAuthPasswordField())
                .perform(replaceText("password2"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
    }

    public static void clickButtonSignIn() {
        Allure.step("Нажать на кнопку Войти");
        waitUntilElement(R.id.enter_button);

        enterButton
                .perform(click());
        // Ожидаем исчезновения индикатора загрузки
        // waitUntilElementDisappears(R.id.splash_screen_circular_progress_indicator);
        //waitUntilElement(R.id.splash_screen_circular_progress_indicator);
//        ViewInteraction textView2 = onView(withText("News"));
//        textView2.check(matches(isDisplayed()));
//
//        textView2.check(matches(withText("News")));
    }


//    public static void waitUntilElementDisappears(int id) {
//        onView(withId(id)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.GONE)));
//    }

//    public static void clickButtonSignIn() {
//        Allure.step("Нажать на кнопку Войти");
//
//        // Ожидание кнопки "Войти"
//        waitUntilElement(R.id.enter_button);
//
//                // Клик по кнопке
//        enterButton.perform(click());
//
//        // Ожидание и проверка текста "News"
//        ViewInteraction textView2 = onView(withText("News"));
//        textView2.check(matches(isDisplayed())); // Проверка, что элемент отображается
//        textView2.check(matches(withText("News"))); // Проверка текста
//    }

    // Реализация метода ожидания элемента
    public static void waitUntilElement(int id) {
        onView(withId(id)).check(matches(isDisplayed()));
    }

    public static void clickButtonLogOut() {
        Allure.step("Нажать на кнопку Выйти");
        waitUntilElement(android.R.id.title);

        onView(getElementsButtonLogOut())
                .perform(click());
    }

    //    public static void clickButtonExit(Integer resourceId) {
//        Allure.step("Нажать на кнопку Выход");
//        onView(withId(R.id.authorization_image_button));
////                .check(matches(isDisplayed()));;;
//        //waitUntilElement(R.id.authorization_image_button);
//        //waitFor(2);
//        onView(withId(resourceId))
//                .perform(click());
//    }
//    public static void clickButtonExit(Matcher<View> elementButtonExit) {
//        Allure.step("Нажать на кнопку Выход");
//        waitUntilElement(R.id.authorization_image_button);
//        onView(withId(R.id.authorization_image_button)).check(matches(isCompletelyDisplayed()));
//
//        onView(getElementButtonExit())
//                .perform(click());
//    }
    public static void clickButtonExit(Integer resourceId) {
        Allure.step("Нажать на кнопку Выход");

        // Убедиться, что элемент виден
        //waitUntilElement(R.id.authorization_image_button);

        // Проверка на видимость элемента
        onView(withId(resourceId))
                .check(matches(isDisplayed()))
                .perform(click());
    }


    public static void textErrorWrong() {

        Allure.step("Отобразилаcь ошибка: Login and password cannot be empty");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }


    public static void textErrorEmpty() {
        Allure.step("Ошибка: Login and password cannot be empty");
        onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    public static void clickLoginEmpty() {
        Allure.step("Поле Логин оставить пустым");
        onView(getAuthLoginField())
                .perform(replaceText(" "), closeSoftKeyboard());
        //onView(allOf(withContentDescription("Login and password cannot be empty"), isDisplayed()));
    }

    //
    public static void clickLoginFieldUnregisteredUser() {
        Allure.step("Ввести в поле Логин данные незарегистрированного пользователя");
        onView(getAuthLoginField())
                .perform(replaceText("login123"), closeSoftKeyboard());
//        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickLoginFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Логин спецсимволы");
        onView(getAuthLoginField())
                .perform(replaceText("@#$^&**"), closeSoftKeyboard());
        //onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickLoginFieldOneSymbol() {
        Allure.step("Ввести в поле Логин один символ");
        onView(getAuthLoginField())
                .perform(replaceText("l"), closeSoftKeyboard());
//        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }


    public static void clickPasswordFieldIsEmpty() {
        Allure.step("Поле Пароль оставить пустым");
        onView(getAuthPasswordField())
                .perform(replaceText(" "), closeSoftKeyboard())
                .check(matches(isDisplayed()));
//        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickPasswordFieldWrongPasword() {
        Allure.step("Ввести в поле Пароль невалидные данные");
        onView(getAuthPasswordField())
                .perform(replaceText("password123"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
//        onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickPasswordFieldWithSpecialCharacters() {
        Allure.step("Ввести в поле Пароль спецсимволы");
        onView(getAuthPasswordField())
                .perform(replaceText("$^&%^&(*^@"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
        //onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }

    public static void clickPasswordFieldOneSymbol() {
        Allure.step("Ввести в поле Пароль один символ");
        onView(getAuthPasswordField())
                .perform(replaceText("p"), closeSoftKeyboard())
                .check(matches(isDisplayed()));
        //    onView(allOf(withContentDescription("Wrong login or password"), isDisplayed()));
    }


//        public static <object> ViewAction waitForWindowFocus() {
//            return new ViewAction() {
//                @Override
//                public Matcher<View> getConstraints() {
//                    return isRoot(); // Действие будет применяться к корневому View
//                }
//
//                @Override
//                public String getDescription() {
//                    return "Ожидание, пока окно получит фокус";
//                }
//
//                @Override
//                public void perform(UiController uiController, View view) {
//                    while (!view.hasWindowFocus()) {
//                        uiController.loopMainThreadForAtLeast(100); // Пауза 100 мс
//                    }
//                }
//            };


}


//  public static void textAuthorization(){
//        Allure.step("страница авторизации");
//        waitUntilElement(R.id.nav_host_fragment);
//        onView(getTextAuthorization())
//               .check(matches(isDisplayed()));
////        onView(isRoot()).perform(waitForWindowFocus());
////        onView(withId(R.id.nav_host_fragment))
////                .check(matches(isDisplayed()));;;
////        //waitFor(3);
////        onView(getAuthElementsTextAuthorization())
////                .check(matches(isDisplayed()));
//    }

//    public static void clickLoginField() {
//        Allure.step("В поле Логин ввести: login2");
//        onView(isRoot()).perform(waitForWindowFocus()); // Ожидание
//        onView(withId(R.id.login_text_input_layout))
//                .check(matches(isDisplayed()));
//        onView(getAuthElementsLoginField())
//                .perform(replaceText("login2"), closeSoftKeyboard())
//                .check(matches(isDisplayed()));

//    public static void clickButton(Integer resourceId){
//        //public static void clickButton(Integer resourceId){
//        Allure.step("Нажать на кнопку Войти");
//        onView(withId(R.id.enter_button))
//                .check(matches(isDisplayed()));;;
//        onView(withId(resourceId))
//                .perform(click());
//    }




