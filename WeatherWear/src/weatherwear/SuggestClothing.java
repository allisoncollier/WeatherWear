package weatherwear;

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
 * The SuggestClothing class decides based on the weather conditions which items
 * of clothing the user should wear for the most comfort during their day.
 *
 * @author Allison Collier, Lynn Wormeli, Laura Sakmyster
 * @version Apr 17, 2014
 */
public class SuggestClothing
{
    private WeatherProcess            weatherInfo;
    private WeatherEnum               temperature;
    private WeatherEnum               precipitation;
    private WeatherEnum               cloudCover;
    private ArrayList<ClothingEnum>   clothList;
    private ArrayList<String>         clothPicList;
    private String                    city;
    private int                       index;


    /**
     * The constructor for SuggestClothing class takes in a WeatherProcess
     * object as well as the city and initializes the fields
     *
     * @param situation
     *            current weather situation in given city.
     * @param cityInfo
     *            current city
     */
    public SuggestClothing(WeatherProcess situation, String cityInfo)
    {
        clothPicList = new ArrayList<String>();
        clothList = new ArrayList<ClothingEnum>();
        weatherInfo = situation;
        city = cityInfo;
        temperature = weatherInfo.processTemp(situation.getWeatherReport(city));
        cloudCover =
            weatherInfo.processClouds(situation.getWeatherReport(city));
        precipitation =
            weatherInfo.processPrecip(situation.getWeatherReport(city));
    }


    /**
     * Constructor for SuggestClothing class that allows specification of which
     * forecast in the lists of forecasts from which to pull information. Mainly
     * used for testing purposes.
     *
     * @param situation
     *            Current weather report in given city.
     * @param cityInfo
     *            City desired for
     * @param listIndex
     *            Index of forecastList desired.
     */
    public SuggestClothing(
        WeatherProcess situation,
        String cityInfo,
        int listIndex)
    {
        clothList = new ArrayList<ClothingEnum>();
        clothPicList = new ArrayList<String>();
        weatherInfo = situation;
        city = cityInfo;
        index = listIndex;
        temperature =
            weatherInfo.processTemp(situation.getWeatherReport(city), index);
        cloudCover =
            weatherInfo.processClouds(situation.getWeatherReport(city), index);
        precipitation =
            weatherInfo.processPrecip(situation.getWeatherReport(city), index);
    }


    // ----------------------------------------------------------
    /**
     * Determines based on the type of precipitation and temperature which type
     * of coat the user should wear if any at all.
     */
    public void suggestCoat()
    {
        if (precipitation == WeatherEnum.PRECIPITATION_SNOW)
        {
            clothList.add(ClothingEnum.HEAVYCOAT);
            clothPicList
                .add("http://puffercoats.org/wp-content/uploads/2013/05/" +
                		"plus-size-winter-coats.jpg");
        }
        else if (temperature == WeatherEnum.TEMP_FREEZING)
        {
            clothList.add(ClothingEnum.HEAVYCOAT);
            clothPicList
                .add("http://puffercoats.org/wp-content/uploads/2013/05/" +
                		"plus-size-winter-coats.jpg");
        }
        else if (precipitation == WeatherEnum.PRECIPITATION_RAIN)
        {
            clothList.add(ClothingEnum.RAINCOAT);
            clothPicList
                .add("http://cloud2.collegefashion.net/wp-content/uploads/" +
                		"2010/01/L.L.-Bean-Rain-Jacket.jpg");
        }
        else if (temperature == WeatherEnum.TEMP_COLD)
        {
            clothList.add(ClothingEnum.LIGHTCOAT);
            clothPicList
                .add("http://www.lymefarmersmarket.com/images/" +
                		"cp4/Discount_North_Face_Denali_Kids_White.jpg");
        }
    }


    /**
     * Determines based on the temperature which cold weather accessories the
     * user should wear if any at all.
     */
    public void suggestColdWeatherAccessories()
    {
        if (temperature == WeatherEnum.TEMP_FREEZING)
        {
            clothList.add(ClothingEnum.GLOVES);
            clothPicList
                .add("http://www.wigglestatic.com/images/sealskinz-winter" +
                		"-gloves-11-zoom.jpg");
            clothList.add(ClothingEnum.SCARF);
            clothPicList
                .add("http://qctjpdtgffky5c24.zippykid.netdna-cdn.com/wp-con" +
                		"tent/uploads/2010/12/how-to-tie-a-scarf-6.jpg");
            clothList.add(ClothingEnum.HAT);
            clothPicList
                .add("http://www.redbookmag.com/cm/redbook/images/Kc/rbk-w" +
                		"inter-hats-target-crochet-beanie-ball-lgn.jpg");

        }
        else if (temperature == WeatherEnum.TEMP_COLD)
        {
            clothList.add(ClothingEnum.SCARF);
            clothPicList
                .add("http://qctjpdtgffky5c24.zippykid.netdna-cdn.com/wp" +
                		"-content/uploads/2010/12/how-to-tie-a-scarf-6.jpg");
            clothList.add(ClothingEnum.HAT);
            clothPicList
                .add("http://www.redbookmag.com/cm/redbook/images/Kc/rb" +
                		"k-winter-hats-target-crochet-beanie-ball-lgn.jpg");
        }
    }


    /**
     * Determines based on the temperature which warm weather accessories the
     * user should wear if any at all.
     */
    public void suggestWarmWeatherAccessories()
    {
        if ((cloudCover == WeatherEnum.CLOUDCOVER_PARTLYCLOUDY ||
            cloudCover == WeatherEnum.CLOUDCOVER_CLEAR)
            && (temperature == WeatherEnum.TEMP_WARM ||
            temperature == WeatherEnum.TEMP_HOT))
        {
            clothList.add(ClothingEnum.SUNGLASSES);
            clothPicList
                .add("http://en.wikipedia.org/wiki/File:RayBanAviator.jpg");
            clothList.add(ClothingEnum.SUNSCREEN);
            clothPicList
                .add("http://www.fitsugar.com/files/ons1/192/1922729/25_" +
                		"2009/29790fd1cb6712d5_sunscreen.jpg");
        }
    }


    /**
     * Determines based on the precipitation and temperature which shoes the
     * user should wear.
     */
    public void suggestShoes()
    {
        if ((precipitation == WeatherEnum.PRECIPITATION_NONE)
            && temperature == WeatherEnum.TEMP_HOT)
        {
            clothList.add(ClothingEnum.SANDALS);
            clothPicList
                .add("http://www.oregonsurfshop.com/images/P/rainbow-s" +
                		"andals-301alts-womens-medium-dark-brown.jpg");
        }
        else if (precipitation == WeatherEnum.PRECIPITATION_RAIN
            || precipitation == WeatherEnum.PRECIPITATION_SNOW
            || temperature == WeatherEnum.TEMP_FREEZING)
        {
            clothList.add(ClothingEnum.BOOTS);
            clothPicList
                .add("http://altitude-blog.com/wp-content/uploads/2010/12" +
                		"/Merrell_Oslo_Noir.jpg");
        }
        else
        {
            clothList.add(ClothingEnum.NORMALSHOES);
            clothPicList
                .add("http://images.nationalgeographic.com/wpf/media-live" +
                		"/photos/000/590/cache/danica-patrick-shoes_59019" +
                		"_600x450.jpg");
        }
    }


    /**
     * Determines based on the temperature and precipitation type which type of
     * bottoms the user should wear.
     */
    public void suggestBottoms()
    {
        if (temperature == WeatherEnum.TEMP_HOT)
        {
            clothList.add(ClothingEnum.SHORTS);
            clothPicList
                .add("http://shopimages-pe.delias.com/155751_mbl_w.jpg");
        }
        else if ((temperature == WeatherEnum.TEMP_FREEZING ||
            temperature == WeatherEnum.TEMP_COLD)
            && precipitation == WeatherEnum.PRECIPITATION_SNOW)
        {
            clothList.add(ClothingEnum.SNOWPANTS);
            clothPicList
                .add("http://s.stpost.com/eccstorefront/product" +
                		"_images/5278p/f_5278p_1.1.jpg");
        }
        else
        {
            clothList.add(ClothingEnum.PANTS);
            clothPicList
                .add("http://usamedia.frenchconnection.com/ms/fcus/54FZ" +
                		"E_model/1537/1024/Track-Denim-Slim-Leg-Jeans.j" +
                		"pg?lc=en-GB&lv=7&404=fcus/54FZE.jpg");
        }
    }


    /**
     * Determines based on the temperature which type of shirt the user should
     * wear.
     */
    public void suggestShirts()
    {
        if (temperature == WeatherEnum.TEMP_HOT)
        {
            clothList.add(ClothingEnum.NOSLEEVES);
            clothPicList
                .add("http://img4-2.realsimple.timeinc.net/images/100" +
                		"6/finds-dimri-tank-top_300.jpg");
        }
        else if (temperature == WeatherEnum.TEMP_WARM)
        {
            clothList.add(ClothingEnum.SHORTSLEEVES);
            clothPicList
                .add("http://www.customdropshipping.com/data/produ" +
                		"ct/img/20110917/women-s-pink-deep-v-neck-" +
                		"shirt-78_t_300_300.jpg");
        }
        else if (temperature == WeatherEnum.TEMP_COLD
            || temperature == WeatherEnum.TEMP_FREEZING)
        {
            clothList.add(ClothingEnum.LONGSLEEVES);
            clothPicList
                .add("http://www.target.com/OpenZoomLayer?template=s" +
                		"cene7-image&image=Target/14612113_is&omniZo" +
                		"omPartNumber=14612113&swCellSpacing=10,10&" +
                		"swHighlightThickness=1&swBorderThickness=0" +
                		"&itemTitle=Mossimo%26amp%3Breg%26%23x3b%3B" +
                		"+Women%26%23x27%3Bs+Long+Sleeve+Lightweigh" +
                		"t+Crew+Tee+-+Assorted+Colors&omniImageCount=3");
        }
        else
        {
            clothList.add(ClothingEnum.SHORTSLEEVES);
            clothPicList
                .add("http://www.customdropshipping.com/data/pro" +
                		"duct/img/20110917/women-s-pink-deep-v-ne" +
                		"ck-shirt-78_t_300_300.jpg");
        }
    }


    /**
     * Returns the list of ClothingEnums added.
     *
     * @return list of clothing items.
     */
    public ArrayList<ClothingEnum> getClothingList()
    {
        return clothList;
    }


    /**
     * Returns the DoublyLinkedDeque object containing all of the picture names
     * of the clothing items being features in the ArrayList from the current
     * weather conditions
     *
     * @return DoublyLinkedDeque containing picture file names
     */
    public ArrayList<String> getClothingPictures()
    {
        return clothPicList;
    }

}
