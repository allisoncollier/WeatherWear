package weatherwear;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * // -------------------------------------------------------------------------
 * Test class for SuggestClothing class. Ensures that SuggestClothing's methods
 * return appropriate clothing for specific weather conditions based on which
 * city and which day in the forecast is chosen.
 *
 * @author Allison Collier, Lynn Wormeli, Laura Sakmyster
 * @version Apr 25, 2014
 */
public class SuggestClothingTest
{
    private SuggestClothing clothingInfo;
    private WeatherProcess  weatherInfo;


    /**
     * Sets up test fixtures by initializing the WeatherProcess object with the
     * cache.
     *
     * @throws Exception
     */
    @Before
    public void setUp()
        throws Exception
    {
        weatherInfo = new WeatherProcess("cache.json");
    }


    /**
     * Tests that suggestCoat() adds a LIGHTCOAT enumerated type to the
     * clothingList when the temperature is cold.
     */
    @Test
    public void testSuggestCoatBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestCoat();
        assertEquals(ClothingEnum.LIGHTCOAT, clothingInfo.getClothingList()
            .get(0));
        assertEquals("http://www.lymefarmersmarket.com/images/cp4/Discount_North_Face_Denali_Kids_White.jpg", clothingInfo.getClothingPictures().get(0));
    }


    /**
     * Tests that suggestColdWeatherAccessories() adds a scarf and hat to the
     * clothingList when the temperature is cold.
     */
    @Test
    public void testSuggestColdWeatherAccessoriesBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestColdWeatherAccessories();
        assertEquals(ClothingEnum.SCARF, clothingInfo.getClothingList().get(0));
        assertEquals("http://qctjpdtgffky5c24.zippykid.netdna-cdn.com/" +
        		"wp-content/uploads/2010/12/how-to-tie-a-scarf-6.jpg",
        		clothingInfo.getClothingPictures().get(0));
        assertEquals(ClothingEnum.HAT, clothingInfo.getClothingList().get(1));
        assertEquals("http://www.redbookmag.com/cm/redbook/images/Kc" +
        		"/rbk-winter-hats-target-crochet-beanie-ball-lgn.jpg",
        		clothingInfo.getClothingPictures().get(clothingInfo.
        		    getClothingPictures().size() - 1));
    }


    /**
     * Tests that warmWeatherAccessories() adds nothing to the clothingList if
     * the temperature is not warm or hot and the cloud cover is not clear or
     * partly cloudy.
     */
    @Test
    public void testWarmWeatherAccessoriesBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestWarmWeatherAccessories();
        assertEquals(0, clothingInfo.getClothingList().size());
        assertEquals(0, clothingInfo.getClothingPictures().size());
    }


    /**
     * Tests that suggestCoat() adds no coat to the clothingList when the
     * temperature is warm.
     */
    @Test
    public void testSuggestCoatSeattle()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "seattle, wa");
        clothingInfo.suggestCoat();
        assertEquals(0, clothingInfo.getClothingList().size());
    }


    /**
     * Tests that suggestColdWeatherAccessories() adds no accessories to the
     * clothingList when the temperature is warm.
     */
    @Test
    public void testSuggestColdWeatherAccessoriesSeattle()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "seattle, wa");
        clothingInfo.suggestColdWeatherAccessories();
        assertEquals(0, clothingInfo.getClothingList().size());
    }


    /**
     * Tests that suggestWarmWeatherAccesories() adds no accessories to the
     * clothingList when the cloud cover is mostly cloudy.
     */
    @Test
    public void testSuggestWarmWeatherAccessoriesSeattle()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "seattle, wa");
        clothingInfo.suggestWarmWeatherAccessories();
        assertEquals(0, clothingInfo.getClothingList().size());
    }


    /**
     * Tests that suggestWarmWeatherAccessories() adds sunglasses and sunscreen
     * to the clothingList when the temperature is warm or hot and the cloud
     * cover is clear or partly cloudy.
     */
    @Test
    public void testSuggestWarmWeatherAccessoriesMiami()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "miami, fl");
        clothingInfo.suggestWarmWeatherAccessories();
        assertEquals(ClothingEnum.SUNGLASSES, clothingInfo.getClothingList()
            .get(0));
        assertEquals(ClothingEnum.SUNSCREEN, clothingInfo.getClothingList()
            .get(1));
    }


    /**
     * Tests that suggestCoat() adds a HEAVYCOAT to the clothingList when the
     * temperature is cold or freezing and the precipitation is snow.
     */
    @Test
    public void testSuggestCoatMinneapolis9()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "minneapolis, mn", 9);
        clothingInfo.suggestCoat();
        assertEquals(ClothingEnum.HEAVYCOAT, clothingInfo.getClothingList()
            .get(0));
    }


    /**
     * Tests that suggestCoat() adds a RAINCOAT to the clothingList when the
     * temperature the precipitation is rain.
     */
    @Test
    public void testSuggestCoatNewark3()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "newark, de", 3);
        clothingInfo.suggestCoat();
        assertEquals(
            ClothingEnum.RAINCOAT,
            clothingInfo.getClothingList().get(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests that suggestShoes() adds NORMALSHOES to the clothingList when there
     * is no precipitation or if the temperature is not freezing.
     */
    @Test
    public void testSuggestShoesBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestShoes();
        assertEquals(ClothingEnum.NORMALSHOES, clothingInfo.getClothingList()
            .get(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests that suggestShoes() adds BOOTS to the clothingList when there is
     * precipitation or if the temperature is freezing.
     */
    @Test
    public void testSuggestShoesMinneapolis()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va", 9);
        clothingInfo.suggestShoes();
        assertEquals(ClothingEnum.BOOTS, clothingInfo.getClothingList().get(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests that suggestShoes() adds SANDALS to the clothingList when there is
     * no precipitation and if the temperature is hot.
     */
    @Test
    public void testSuggestShoesMiami()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "miami, fl", 1);
        clothingInfo.suggestShoes();
        assertEquals(ClothingEnum.SANDALS, clothingInfo.getClothingList()
            .get(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests that suggestShoes() adds PANTS to the clothingList when the
     * temperature is not hot or if it is not snowing.
     */
    @Test
    public void testSuggestBottomsBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestBottoms();
        assertEquals(ClothingEnum.PANTS, clothingInfo.getClothingList().get(0));
    }


    // ----------------------------------------------------------
    /**
     * Tests that suggestShirts() adds LONGSLEEVES to the clothingList when the
     * temperature is cold or freezing.
     */
    @Test
    public void testSuggestShirtsBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va");
        clothingInfo.suggestShirts();
        assertEquals(ClothingEnum.LONGSLEEVES, clothingInfo.getClothingList()
            .get(0));
    }


    /**
     * Tests that suggestBottoms() adds SHORTS to the clothingList when the
     * temperature is hot.
     */
    @Test
    public void testSuggestBottomsMiami()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "miami, fl", 1);
        clothingInfo.suggestBottoms();
        assertEquals(ClothingEnum.SHORTS,
            clothingInfo.getClothingList().get(0));
    }


    /**
     * Tests that suggestBottoms() adds SNOWPANTS to the clothingList when it is
     * snowing.
     */
    @Test
    public void testSuggestBottomsMinneapolis()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "minneapolis, mn", 9);
        clothingInfo.suggestBottoms();
        assertEquals(ClothingEnum.SNOWPANTS, clothingInfo.getClothingList()
            .get(0));
    }


    /**
     * Tests that suggestShirts() adds NOSLEEVES to the clothingList when the
     * temperature is hot.
     */
    @Test
    public void testSuggestShirtsMiami()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "miami, fl", 1);
        clothingInfo.suggestShirts();
        assertEquals(ClothingEnum.NOSLEEVES, clothingInfo.getClothingList()
            .get(0));
    }


    /**
     * Tests that suggestShirts() adds LONGSLEEVES to the clothingList when the
     * temperature is cold or freezing.
     */
    @Test
    public void testSuggestShirtsMinneapolis()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "minneapolis, mn", 2);
        clothingInfo.suggestShirts();
        assertEquals(ClothingEnum.LONGSLEEVES, clothingInfo.getClothingList()
            .get(0));
    }


    /**
     * Tests that, based on hot weather, all of the SuggestClothing methods add
     * appropriate clothes to the clothingList.
     */
    @Test
    public void testSuggestClothesMiami()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "miami, fl", 1);
        clothingInfo.suggestShirts();
        clothingInfo.suggestBottoms();
        clothingInfo.suggestCoat();
        clothingInfo.suggestShoes();
        clothingInfo.suggestWarmWeatherAccessories();
        clothingInfo.suggestColdWeatherAccessories();
        assertEquals(ClothingEnum.NOSLEEVES, clothingInfo.getClothingList()
            .get(0));
        assertEquals(ClothingEnum.SHORTS, clothingInfo.getClothingList()
            .get(1));
        assertEquals(ClothingEnum.SANDALS, clothingInfo.getClothingList()
            .get(2));
        assertEquals(ClothingEnum.SUNGLASSES, clothingInfo.getClothingList()
            .get(3));
        assertEquals(ClothingEnum.SUNSCREEN, clothingInfo.getClothingList()
            .get(4));
    }


    /**
     * Tests that, based on cold weather, all of the SuggestClothing methods
     * add appropriate clothes to the clothingList.
     */
    @Test
    public void testSuggestClothesMinneapolis()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "minneapolis, mn", 9);
        clothingInfo.suggestShirts();
        clothingInfo.suggestBottoms();
        clothingInfo.suggestCoat();
        clothingInfo.suggestShoes();
        clothingInfo.suggestWarmWeatherAccessories();
        clothingInfo.suggestColdWeatherAccessories();
        assertEquals(ClothingEnum.LONGSLEEVES, clothingInfo.getClothingList()
            .get(0));
        assertEquals(ClothingEnum.SNOWPANTS, clothingInfo.getClothingList()
            .get(1));
        assertEquals(ClothingEnum.HEAVYCOAT, clothingInfo.getClothingList()
            .get(2));
        assertEquals(ClothingEnum.BOOTS, clothingInfo.getClothingList().get(3));
        assertEquals(ClothingEnum.SCARF, clothingInfo.getClothingList().get(4));
        assertEquals(ClothingEnum.HAT, clothingInfo.getClothingList().get(5));
    }


    /**
     * Tests that, based on warm weather, all of the SuggestClothing methods add
     * appropriate clothes to the clothingList.
     */
    @Test
    public void testSuggestClothesBlacksburg()
    {
        clothingInfo = new SuggestClothing(weatherInfo, "blacksburg, va", 1);
        clothingInfo.suggestShirts();
        clothingInfo.suggestBottoms();
        clothingInfo.suggestCoat();
        clothingInfo.suggestShoes();
        clothingInfo.suggestWarmWeatherAccessories();
        clothingInfo.suggestColdWeatherAccessories();
        assertEquals(ClothingEnum.SHORTSLEEVES, clothingInfo.getClothingList()
            .get(0));
        assertEquals(ClothingEnum.PANTS, clothingInfo.getClothingList().get(1));
        assertEquals(ClothingEnum.NORMALSHOES, clothingInfo.getClothingList()
            .get(2));
        assertEquals(ClothingEnum.SUNGLASSES, clothingInfo.getClothingList()
            .get(3));
        assertEquals(ClothingEnum.SUNSCREEN, clothingInfo.getClothingList()
            .get(4));
    }
}
