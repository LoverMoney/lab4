package com.example.tusurhelper.ui.Timetable


import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.cardview.widget.CardView
import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.tusurhelper.R
import com.example.tusurhelper.ui.Main.MainFragment
import com.example.tusurhelper.ui.timetable.TimetableFragment
import junit.framework.TestCase.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class TestTimetable{
    private lateinit var scenario: FragmentScenario<TimetableFragment>
    @Before
    fun setup(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_TUSURhelper)
        scenario.moveToState(Lifecycle.State.STARTED)
    }
    @Test
    fun testDaysButtons() {
        val recyclerViewMatcher = withId(R.id.rcView2)
        onView(withId(R.id.cardview1)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview1)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Сидоренко Марина Геннадьевна"))))
        onView(withId(R.id.cardview2)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview2)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Головчук Олеся Олеговна"))))
        onView(withId(R.id.cardview3)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview3)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Лаходынова Надежда Владимировна"))))
        onView(withId(R.id.cardview4)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview4)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Афанасьева Инга Геннадьевна"))))
        onView(withId(R.id.cardview5)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview5)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Головчук Олеся Олеговна"))))
        onView(withId(R.id.cardview6)).check(matches(isDisplayed()));
        onView(withId(R.id.cardview6)).perform(click())
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Костелей Яна Валерьевна"))))
    }
    @Test
    fun testWeeksButtons() {
        Thread.sleep(1000)
        onView(withText("с 15 мая 2023")).check(matches(isDisplayed()));
        onView(withId(R.id.button1)).check(matches(isDisplayed()));
        onView(withId(R.id.button1)).perform(click())
        onView(withId(R.id.rcView2)).check(matches(isDisplayed()));
        onView(withText("с 8 мая 2023")).check(matches(isDisplayed()));
        Thread.sleep(1000)
        onView(withId(R.id.button2)).check(matches(isDisplayed()));
        onView(withId(R.id.button2)).perform(click())
        onView(withId(R.id.rcView2)).check(matches(isDisplayed()));
        onView(withText("с 15 мая 2023")).check(matches(isDisplayed()));
    }
}
class TestNews{
    private lateinit var scenario: FragmentScenario<MainFragment>
    @Before
    fun setup(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_TUSURhelper)
        scenario.moveToState(Lifecycle.State.STARTED)
    }
    @Test
    fun testNewsDisplayed() {
        Thread.sleep(1000)
        val recyclerViewMatcher = withId(R.id.rcView1)
        onView(withId(R.id.rcView1)).check(matches(isDisplayed()));
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("19 мая 2023"))))
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Есть контакт: " +
                "студенты проверят свои навыки на VI Конкурсе радиомонтажников, который пройдет в ТУСУРе"))))
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("18 мая 2023"))))
        onView(recyclerViewMatcher).check(matches(hasDescendant(withText("Деловая игра «Назад в будущее» пройдет в СБИ ТУСУРа"))))
    }
}
