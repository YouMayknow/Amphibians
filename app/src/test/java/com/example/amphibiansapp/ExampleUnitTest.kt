package com.example.amphibiansapp

import com.example.amphibiansapp.data.NetworkCardRepository
import com.example.amphibiansapp.fake.Fake
import com.example.amphibiansapp.fake.fakeApi
import com.example.amphibiansapp.ui.screen.AppUiState
import com.example.amphibiansapp.ui.screen.AppViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun testingForRepository () = runTest {
        assertEquals(NetworkCardRepository(marsApiService = fakeApi()).getCardDetails() , Fake.fakeDatasource)
    }

    @get:Rule
    val testDispatcher = Rule()


    @Test
    fun viewmdodelTest () = runTest {
       val viewmodel = AppViewModel(
           cardRepository = fakeApi()
       )
        assertEquals(
            AppUiState.Success(Fake.fakeDatasource) ,
            viewmodel.appUiState
        )

    }

}