package weatherwear;

import java.util.List;
import realtimeweb.weatherservice.domain.Forecast;
import realtimeweb.weatherservice.domain.Weather;
import realtimeweb.weatherservice.domain.Report;
import realtimeweb.weatherservice.WeatherService;

// -------------------------------------------------------------------------
/**
 * The WeatherProcess class utilizes the Weather API to obtain Forecasts and
 * current weather events, and then determines ranges that the weather
 * properties fall into. It helps process weather data using Weather, Forecast,
 * Report, and WeatherService objects to obtain all the information from the
 * web.
 *
 * @author Laura Sakmyster
 * @author Lynn Wormeli
 * @author Allison Collier
 * @version Apr 10, 2014
 */

public class WeatherProcess
{
    // Declares a WeatherService object
    private WeatherService weatherServ;
    private List<Forecast> forecastList;


    // ----------------------------------------------------------
    /**
     * The WeatherProcess constructor takes in no parameters and initializes the
     * WeatherService object declared as a field.
     */
    public WeatherProcess()
    {
        weatherServ = new WeatherService();
    }


    /**
     * The WeatherProcess constructor takes in a cache and initializes the
     * WeatherService object declared as a field. Used for testing.
     *
     * @param cache
     *            name of file that the cache of data is stored under.
     */
    public WeatherProcess(String cache)
    {
        weatherServ = new WeatherService(cache);
    }


    // ----------------------------------------------------------
    /**
     * The getWeatherReport method takes in a String representation of a city
     * name, and will obtain the Report and Weather objects associated with that
     * city. Finally, it returns the Weather object, which can be used to get
     * current weather conditions
     *
     * @param city
     *            representing the city that weather conditions are being drawn
     *            from
     * @return Weather object associated with the city input as a parameter
     */
    public Weather getWeatherReport(String city)
    {
        Report report = weatherServ.getReport(city);
        Weather weatherRep = report.getWeather();
        forecastList = report.getForecasts();
        return weatherRep;
    }


    // ----------------------------------------------------------
    /**
     * The processTemp method takes in a Weather object, and gets the current
     * temperature for the city associated with the Weather object. It then
     * categorizes the temperature according to specific ranges, and determines
     * the temperature quality.
     *
     * @param weatherReport
     *            representing the Weather object the temperature is found from
     * @return WeatherEnum representing the temperature quality for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processTemp(Weather weatherReport)
    {
        int temperature = weatherReport.getTemp();
        if (temperature < 32)
        {
            return WeatherEnum.TEMP_FREEZING;
        }

        else if (temperature >= 32 && temperature < 50)
        {
            return WeatherEnum.TEMP_COLD;
        }

        else if (temperature >= 50 && temperature < 75)
        {
            return WeatherEnum.TEMP_WARM;
        }

        else
        {
            return WeatherEnum.TEMP_HOT;
        }
    }


    // ----------------------------------------------------------
    /**
     * The processTemp method takes in a Weather object, and gets the current
     * temperature for the city associated with the Weather object. It then
     * categorizes the temperature according to specific ranges, and determines
     * the temperature quality.
     *
     * @param weatherReport
     *            representing the Weather object the temperature is found from
     * @param index
     *            integer index of forecastList desired from which to get
     *            desired information.
     * @return WeatherEnum representing the temperature quality for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processTemp(Weather weatherReport, int index)
    {
        int temperature = forecastList.get(index).getTemperature();
        if (temperature < 32)
        {
            return WeatherEnum.TEMP_FREEZING;
        }

        else if (temperature >= 32 && temperature < 50)
        {
            return WeatherEnum.TEMP_COLD;
        }

        else if (temperature >= 50 && temperature < 75)
        {
            return WeatherEnum.TEMP_WARM;
        }

        else
        {
            return WeatherEnum.TEMP_HOT;
        }
    }


    // ----------------------------------------------------------
    /**
     * The processClouds method takes in a Weather object, and gets the current
     * cloud coverage for the city associated with the Weather object. It then
     * categorizes the cloud coverage according to the type, and assigns each
     * type of cloud coverage an integer value.
     *
     * @param weatherReport
     *            representing the Weather object the cloud coverage is found
     *            from.
     * @return WeatherEnum representing the type of cloud coverage for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processClouds(Weather weatherReport)
    {
        /*
         * Create a forecast object for the town, and get the cloud coverage
         * information. Then process that value through if-statements, and
         * determine quality of data value to return.
         */

        Forecast currentWeather = forecastList.get(0);
        String description = currentWeather.getLongDescription();
        if (description.contains("cloud") && description.contains("part"))
        {
            return WeatherEnum.CLOUDCOVER_PARTLYCLOUDY;
        }
        else if (description.contains("cloud") && description.contains("most"))
        {
            return WeatherEnum.CLOUDCOVER_MOSTLYCLOUDY;
        }
        else if (description.contains("cloud") || description.contains("Rain")
            || description.contains("Showers") || description.contains("Snow"))
        {
            return WeatherEnum.CLOUDCOVER_CLOUDY;
        }
        else
        {
            return WeatherEnum.CLOUDCOVER_CLEAR;
        }
    }


    // ----------------------------------------------------------
    /**
     * The processClouds method takes in a Weather object, and gets the current
     * cloud coverage for the city associated with the Weather object. It then
     * categorizes the cloud coverage according to the type, and assigns each
     * type of cloud coverage an integer value.
     *
     * @param weatherReport
     *            representing the Weather object the cloud coverage is found
     *            from.
     * @param index
     *            integer index of forecastList desired from which to get
     *            desired information.
     * @return WeatherEnum representing the type of cloud coverage for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processClouds(Weather weatherReport, int index)
    {
        /*
         * Create a forecast object for the town, and get the cloud coverage
         * information. Then process that value through if-statements, and
         * determine quality of data value to return.
         */

        Forecast currentWeather = forecastList.get(index);
        String description = currentWeather.getLongDescription();
        if (description.toLowerCase().contains("cloud")
            && description.toLowerCase().contains("partly"))
        {
            return WeatherEnum.CLOUDCOVER_PARTLYCLOUDY;
        }
        else if (description.toLowerCase().contains("cloud")
            && description.toLowerCase().contains("most"))
        {
            return WeatherEnum.CLOUDCOVER_MOSTLYCLOUDY;
        }
        else if (description.toLowerCase().contains("cloud")
            || description.toLowerCase().contains("Rain")
            || description.toLowerCase().contains("Showers")
            || description.toLowerCase().contains("Snow"))
        {
            return WeatherEnum.CLOUDCOVER_CLOUDY;
        }
        else
        {
            return WeatherEnum.CLOUDCOVER_CLEAR;
        }
    }


    /**
     * The processPrecip method takes in a Weather object, and gets the current
     * precipitation for the city associated with the Weather object. It then
     * categorizes the precipitation according to the type, and assigns each
     * type of precipitation an integer value.
     *
     * @param weatherReport
     *            representing the Weather object the precipitation is found
     *            from
     * @return WeatherEnum representing the type of precipitation for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processPrecip(Weather weatherReport)
    {
        /*
         * Create a forecast object for the town, and get the cloud coverage
         * information. Then process that value through if-statements, and
         * determine quality of data value to return.
         */

        Forecast currentWeather = forecastList.get(0);
        String description = currentWeather.getLongDescription();
        if (description.toLowerCase().contains("snow")
            && currentWeather.getProbabilityOfPrecipitation() >= 30)
        {
            return WeatherEnum.PRECIPITATION_SNOW;
        }
        else if ((description.toLowerCase().contains("rain")
            || description.toLowerCase().contains("showers") || description
            .toLowerCase().contains("thunderstorms"))
            && currentWeather.getProbabilityOfPrecipitation() >= 30)
        {
            return WeatherEnum.PRECIPITATION_RAIN;
        }
        else
        {
            return WeatherEnum.PRECIPITATION_NONE;
        }
    }


    /**
     * The processPrecip method takes in a Weather object, and gets the current
     * precipitation for the city associated with the Weather object. It then
     * categorizes the precipitation according to the type, and assigns each
     * type of precipitation an integer value.
     *
     * @param weatherReport
     *            representing the Weather object the precipitation is found
     *            from
     * @param index
     *            integer index of forecastList desired from which to get
     *            desired information.
     * @return WeatherEnum representing the type of precipitation for the city
     *         associated with the Weather object.
     */
    public WeatherEnum processPrecip(Weather weatherReport, int index)
    {
        /*
         * Create a forecast object for the town, and get the cloud coverage
         * information. Then process that value through if-statements, and
         * determine quality of data value to return.
         */

        Forecast currentWeather = forecastList.get(index);
        String description = currentWeather.getLongDescription();
        if (description.toLowerCase().contains("snow")
            && currentWeather.getProbabilityOfPrecipitation() >= 30)
        {
            return WeatherEnum.PRECIPITATION_SNOW;
        }
        else if ((description.toLowerCase().contains("rain")
            || description.toLowerCase().contains("showers") || description
            .toLowerCase().contains("thunderstorms"))
            && currentWeather.getProbabilityOfPrecipitation() >= 30)
        {
            return WeatherEnum.PRECIPITATION_RAIN;
        }
        else
        {
            return WeatherEnum.PRECIPITATION_NONE;
        }
    }

}
