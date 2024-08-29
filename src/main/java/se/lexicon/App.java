package se.lexicon;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CityDao cityDao = new CityDaoJDBC();

        // Test findById
        City city = cityDao.findById(1);
        System.out.println(city);

        // Test findByCode
        List<City> cities = cityDao.findByCode("USA");
        cities.forEach(System.out::println);

        // Test add
        City newCity = new City();
        newCity.setName("Test City");
        newCity.setCountryCode("USA");
        newCity.setDistrict("Test District");
        newCity.setPopulation(100000);
        cityDao.add(newCity);
        System.out.println("Added city: " + newCity);

        // Test update
        newCity.setPopulation(200000);
        cityDao.update(newCity);
        System.out.println("Updated city: " + newCity);

        // Test delete
        cityDao.delete(newCity);
        System.out.println("Deleted city with ID: " + newCity.getId());
    }

}
