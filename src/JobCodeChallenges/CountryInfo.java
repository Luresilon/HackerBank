//package JobCodeChallenges;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//public class CountryInfo {
//    public static List<String> findCountries(String keyword, String region) {
//        List<String> result = new ArrayList<>();
//
//        try {
//            String apiUrl = "https://jsonmock.hackerrank.com/api/countries/search?region=" + region + "&name=" + keyword;
//            URL url = new URL(apiUrl);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod("GET");
//
//            int responseCode = connection.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) {
//                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//                StringBuilder response = new StringBuilder();
//                String line;
//                while ((line = reader.readLine()) != null) {
//                    response.append(line);
//                }
//                reader.close();
//
//                JSONObject json = new JSONObject(response.toString());
//                JSONArray data = json.getJSONArray("data");
//
//                List<CountryInfo> countries = new ArrayList<>();
//                for (int i = 0; i < data.length(); i++) {
//                    JSONObject countryData = data.getJSONObject(i);
//                    String name = countryData.getString("name");
//                    int population = countryData.getInt("population");
//                    countries.add(new CountryInfo(name, population));
//                }
//
//                Collections.sort(countries);
//
//                for (CountryInfo country : countries) {
//                    result.add(country.getName() + ", " + country.getPopulation());
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return result;
//    }
//
//    public static void main(String[] args) {
//        String keyword = "your_keyword";
//        String region = "your_region";
//        List<String> countries = findCountries(keyword, region);
//
//        for (String country : countries) {
//            System.out.println(country);
//        }
//    }
//}
//
//class CountryInfo implements Comparable<CountryInfo> {
//    private String name;
//    private int population;
//
//    public CountryInfo(String name, int population) {
//        this.name = name;
//        this.population = population;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public int getPopulation() {
//        return population;
//    }
//
//    @Override
//    public int compareTo(CountryInfo other) {
//        if (this.population != other.population) {
//            return this.population - other.population;
//        } else {
//            return this.name.compareTo(other.name);
//        }
//    }
//}
//
