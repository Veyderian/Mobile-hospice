package ru.iteco.fmhandroid.ui.pages;

import androidx.test.espresso.idling.CountingIdlingResource;

public class EspressoIdlingResource {



        private static final String CLASS_NAME = "EspressoIdlingResource";
        private static final String RESOURCE = "GLOBAL";

        public static final CountingIdlingResource countingIdlingResource = new CountingIdlingResource(RESOURCE);

        private static void increment() {
            countingIdlingResource.increment();
        }

        public static void decrement() {
            if (!countingIdlingResource.isIdleNow()) {
                countingIdlingResource.decrement();
            }
        }
    }


