package br.com.leandro.grupozap

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import br.com.leandro.grupozap.contract.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class GrupoZapTest {

    @Rule
    @JvmField
    val rule = IntentsTestRule(MainActivity::class.java)

    @Test
    fun abrir_tela_zap() {
        onView(withId(R.id.btn_zap)).perform(click())
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.zap.ZapActivity"))
    }

    @Test
    fun abrir_tela_vivaReal() {
        onView(withId(R.id.btn_vivareal)).perform(click())
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.vivaReal.VivaRealActivity"))
    }

    @Test
    fun abrir_tela_imovel() {
        onView(withId(R.id.btn_vivareal)).perform(click())
        Thread.sleep(2000)
        onView(withId(R.id.vivareal_list_imoveeis)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click())
        )
        Thread.sleep(2000)
        intended(hasComponent("com.vicolmoraes.grupozapchallenge.building.BuildingActivity"))
    }

    @Test
    fun verificar_recycler_imoveis() {
        onView(withId(R.id.btn_vivareal)).perform(click())
        Thread.sleep(2000)

        Espresso.onView(ViewMatchers.withId(R.id.vivareal_list_imoveeis))
            .check(ViewAssertions.matches(ViewMatchers.hasChildCount(20)))
    }
}