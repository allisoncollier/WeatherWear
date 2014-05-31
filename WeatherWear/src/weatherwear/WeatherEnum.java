package weatherwear;

/**
 * // -------------------------------------------------------------------------
 * This class establishes the enumerated types used to determine the current
 *  weather conditions.
 *
 * @author Allison Collier
 * @author Laura Sakmyster
 * @author Lynn Wormeli
 * @version Apr 17, 2014
 */
public enum WeatherEnum
{
    /**
     * For temperatures coming in at lower than 32 degrees Farenheight
     */
    TEMP_FREEZING,
    /**
     * For temperatures greater than 32 and less than 50
     */
    TEMP_COLD,
    /**
     * For temperatures greater than 50 and less than 75
     */
    TEMP_WARM,
    /**
     * For temperatures greater than 75
     */
    TEMP_HOT,
    /**
     * For no clouds forecasted
     */
    CLOUDCOVER_CLEAR,
    /**
     * For partly cloudy clouds forecasted
     */
    CLOUDCOVER_PARTLYCLOUDY,
    /**
     * For mostly cloudy clouds forecasted
     */
    CLOUDCOVER_MOSTLYCLOUDY,
    /**
     * For clouds with precipitation forecasted
     */
    CLOUDCOVER_CLOUDY,
    /**
     * For rain forecasted
     */
    PRECIPITATION_RAIN,
    /**
     * For snow forecasted
     */
    PRECIPITATION_SNOW,
    /**
     * For no forecasted precipitation
     */
    PRECIPITATION_NONE,
}
