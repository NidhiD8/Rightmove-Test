package com.example.rightmovetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.rightmovetest.RetrofitImpl.RetrofitRepository
import com.example.rightmovetest.RetrofitImpl.RetrofitService
import com.google.gson.Gson
import com.google.gson.JsonParser
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import retrofit2.Retrofit
import kotlin.collections.ArrayList

@RunWith(MockitoJUnitRunner::class)
@ExperimentalCoroutinesApi
class ViewModelTest {
    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    lateinit var retrofit: Retrofit

    @Mock
    private lateinit var apiHelper: RetrofitService

    @Mock
    private lateinit var retrofitRepository: RetrofitRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)

    }

    private val testDispatcher = TestCoroutineDispatcher()
    @Test
    fun test_fetchPropertyList() = testDispatcher.runBlockingTest {

        val propertyViewModel = PropertyViewModel(testDispatcher,retrofitRepository)
        val channel = Channel<Response<Property>>()
        val flow = channel.consumeAsFlow()
        Mockito.`when`(retrofitRepository.fetchPropertyDetails()).thenReturn(flow )
        var res = "{\n" +
                "  \"properties\" : [\n" +
                "    { \n" +
                "      \"id\": 1,\n" +
                "      \"price\": 1000000,\n" +
                "      \"bedrooms\": 7,\n" +
                "      \"bathrooms\":2,\n" +
                "      \"number\": \"12\",\n" +
                "      \"address\": \"Richard Lane\",\n" +
                "      \"region\": \"London\",\n" +
                "      \"postcode\": \"W1F 3FT\",\n" +
                "      \"propertyType\": \"DETACHED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 2,\n" +
                "      \"price\": 100000,\n" +
                "      \"bedrooms\": 2,\n" +
                "      \"bathrooms\":1,\n" +
                "      \"number\": \"22\",\n" +
                "      \"address\": \"Brick Road\",\n" +
                "      \"region\": \"Sheffield\",\n" +
                "      \"postcode\": \"SH1 1AW\",\n" +
                "      \"propertyType\": \"TERRACED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 3,\n" +
                "      \"price\": 225000,\n" +
                "      \"bedrooms\": 5,\n" +
                "      \"bathrooms\":0,\n" +
                "      \"number\": \"40\",\n" +
                "      \"address\": \"Yellow Lane\",\n" +
                "      \"region\": \"Manchester\",\n" +
                "      \"postcode\": \"MA12 3ZY\",\n" +
                "      \"propertyType\": \"DETACHED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 4,\n" +
                "      \"price\": 150000,\n" +
                "      \"bedrooms\": 1,\n" +
                "      \"bathrooms\":1,\n" +
                "      \"number\": \"3B\",\n" +
                "      \"address\": \"Red Admiral Court\",\n" +
                "      \"region\": \"Essex\",\n" +
                "      \"postcode\": \"RM2 6ET\",\n" +
                "      \"propertyType\": \"FLAT\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 5,\n" +
                "      \"price\": 222250,\n" +
                "      \"bedrooms\": 3,\n" +
                "      \"bathrooms\":1,\n" +
                "      \"number\": \"36\",\n" +
                "      \"address\": \"Country House\",\n" +
                "      \"region\": \"Winchester\",\n" +
                "      \"postcode\": \"WI3 9TT\",\n" +
                "      \"propertyType\": \"DETACHED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 6,\n" +
                "      \"price\": 750000,\n" +
                "      \"bedrooms\": 10,\n" +
                "      \"bathrooms\":4,\n" +
                "      \"number\": \"\",\n" +
                "      \"address\": \"Country House\",\n" +
                "      \"region\": \"Surrey\",\n" +
                "      \"postcode\": \"GU13 9DD\",\n" +
                "      \"propertyType\": \"SEMI_DETACHED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 7,\n" +
                "      \"price\": 125000,\n" +
                "      \"bedrooms\": 2,\n" +
                "      \"bathrooms\":2,\n" +
                "      \"number\": \"44\",\n" +
                "      \"address\": \"New Road\",\n" +
                "      \"region\": \"London\",\n" +
                "      \"postcode\": \"W1F 4DQ\",\n" +
                "      \"propertyType\": \"SEMI_DETACHED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 8,\n" +
                "      \"price\": 545444,\n" +
                "      \"bedrooms\": 4,\n" +
                "      \"bathrooms\":1,\n" +
                "      \"number\": \"55\",\n" +
                "      \"address\": \"Straight Road\",\n" +
                "      \"region\": \"Sheffield\",\n" +
                "      \"postcode\": \"SH1 8FG\",\n" +
                "      \"propertyType\": \"TERRACED\"\n" +
                "    },\n" +
                "    { \n" +
                "      \"id\": 9,\n" +
                "      \"price\": 574833,\n" +
                "      \"bedrooms\": 4,\n" +
                "      \"bathrooms\":3,\n" +
                "      \"number\": \"23\",\n" +
                "      \"address\": \"Curved Lane\",\n" +
                "      \"region\": \"Manchester\",\n" +
                "      \"postcode\": \"MA12 3AS\",\n" +
                "      \"propertyType\": \"DETACHED\"\n" +
                "    }\n" +
                "  ]\n" +
                "}"
        var gson = Gson()
        var jsonres = gson?.fromJson(res, Property::class.java)
        val response = Response.success(jsonres)
        launch {
            channel.send(response)
        }
        propertyViewModel.getPropertyList()

        var totalPrice: Double = 0.00
        for (i in propertyViewModel.propertyList.value!!.properties){
            totalPrice += i.price
        }
        Assert.assertEquals(3692527.0,totalPrice,0.0)

    }
}