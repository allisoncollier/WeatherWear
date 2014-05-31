package weatherwear;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * // -------------------------------------------------------------------------
 * Test class for WeatherProcess class.
 *
 * @author Allison Collier
 * @version Apr 27, 2014
 */
public class WeatherProcessTest
{
    private WeatherProcess situation;


    /**
     * Sets up the testing class.
     *
     * @throws Exception
     */
    @Before
    public void setUp()
        throws Exception
    {
        situation = new WeatherProcess("cache.json");

    }


    /**
     * tests the processTempCold method
     */
    @Test
    public void testProcessTempCold()
    {
        assertEquals(
            WeatherEnum.TEMP_COLD,
            situation.processTemp(situation.getWeatherReport("blacksburg,va")));
    }


    /**
     * tests the processTempWarm method
     */
    @Test
    public void testProcessTempWarm()
    {
        assertEquals(
            WeatherEnum.TEMP_WARM,
            situation.processTemp(situation.getWeatherReport("seattle, wa")));
    }


    /**
     * tests the processTempHot method
     */
    @Test
    public void testProcessTempHot()
    {
        assertEquals(
            WeatherEnum.TEMP_HOT,
            situation.processTemp(situation.getWeatherReport("miami, fl"), 1));
    }


    /**
     * tests the processTempFreezing method
     */
    @Test
    public void testProcessTempFreezing()
    {
        assertEquals(WeatherEnum.TEMP_FREEZING, situation.processTemp(
            situation.getWeatherReport("minneapolis, mn"),
            12));
    }


    /**
     * tests the processPrecipRain method for Seattle
     */
    @Test
    public void testProcessPrecipRainSeattle()
    {
        assertEquals(WeatherEnum.PRECIPITATION_NONE, situation.processPrecip(
            situation.getWeatherReport("seattle, wa"),
            13));
    }


    /**
     * tests the processPrecipRain method for Minneapolis
     */
    @Test
    public void testProcessPrecipRainMinneapolis()
    {
        assertEquals(
            WeatherEnum.PRECIPITATION_RAIN,
            situation.processPrecip(situation
                .getWeatherReport("minneapolis, mn")));
    }


    /**
     * tests the processPrecipSnow method of Minneapolis
     */
    @Test
    public void testProcessPrecipSnowMinneapolis()
    {
        assertEquals(
            WeatherEnum.PRECIPITATION_SNOW,
            situation.processPrecip(
                situation.getWeatherReport("minneapolis, mn"),
                9));
    }


    /**
     * tests the processPrecipRain method of Newark
     */
    @Test
    public void testProcessPrecipRainNewark3()
    {
        assertEquals(WeatherEnum.PRECIPITATION_RAIN, situation.processPrecip(
            situation.getWeatherReport("newark, de"),
            3));
    }


    /**
     * tests the processCloudsClear method
     */
    @Test
    public void testProcessCloudsClear()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_CLEAR,
            situation.processClouds(situation.getWeatherReport("miami,fl"), 3));
    }


    /**
     * tests the processCloudPartlyCloudy method
     */
    @Test
    public void testProcessCloudsPartlyCloudy()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_PARTLYCLOUDY,
            situation.processClouds(situation.getWeatherReport("miami,fl"), 2));
    }


    /**
     * tests the processCloudsMostlyCloudy method
     */
    @Test
    public void testProcessCloudsMostlyCloudy()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_MOSTLYCLOUDY,
            situation.processClouds(situation
                .getWeatherReport("newark,de"), 3));
    }


    /**
     * tests the processCloudsCloudy method
     */
    @Test
    public void testProcessCloudsCloudy()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_CLOUDY,
            situation.processClouds(situation
                .getWeatherReport("minneapolis, mn")));
    }


    /**
     * tests the process methods for the weather in Miami
     */
    @Test
    public void testProcessWeatherMiami()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_CLEAR,
            situation.processClouds(situation.getWeatherReport("miami, fl")));
        assertEquals(
            WeatherEnum.PRECIPITATION_NONE,
            situation.processPrecip(situation.getWeatherReport("miami, fl")));
        assertEquals(
            WeatherEnum.TEMP_WARM,
            situation.processTemp(situation.getWeatherReport("miami, fl")));
    }


    /**
     * tests the process methods for the weather in Minneapolis
     */
    @Test
    public void testProcessWeatherMinneapolis()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_CLOUDY,
            situation.processClouds(situation
                .getWeatherReport("minneapolis, mn")));
        assertEquals(
            WeatherEnum.PRECIPITATION_RAIN,
            situation.processPrecip(situation
                .getWeatherReport("minneapolis, mn")));
        assertEquals(WeatherEnum.TEMP_WARM, situation.processTemp(situation
            .getWeatherReport("minneapolis, mn")));
    }


    /**
     * tests the process methods for the weather in Blacksburg
     */
    @Test
    public void testProcessWeatherBlacksburg()
    {
        assertEquals(
            WeatherEnum.CLOUDCOVER_CLEAR,
            situation.processClouds(situation
                .getWeatherReport("blacksburg, va")));
        assertEquals(
            WeatherEnum.PRECIPITATION_NONE,
            situation.processPrecip(situation
                .getWeatherReport("blacksburg, va")));
        assertEquals(
            WeatherEnum.TEMP_COLD,
            situation.processTemp(situation
                .getWeatherReport("blacksburg, va")));
    }
}
