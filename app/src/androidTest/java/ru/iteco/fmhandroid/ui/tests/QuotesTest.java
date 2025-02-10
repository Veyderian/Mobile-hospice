package ru.iteco.fmhandroid.ui.tests;

import org.junit.Test;

import io.qameta.allure.kotlin.Description;
import io.qameta.allure.kotlin.Story;

public class QuatesTest {
    @Test
    @Story("TC - 73")
    @Description("Развернуть/свернуть тематическую цитату (Позитивный)")
    public void expandThematicQuote() {
        QuotesSteps.clickButtonThematicQuote();
        QuotesSteps.clickTitleThematicQuote();
        QuotesSteps.clickButtonExpandThematicQuote();
        QuotesSteps.clickDescriptionThematicQuote();
    }
}
