package Final;

import P10.JSONArray;
import P10.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherAPI {

    public String weather() throws IOException {
        BufferedReader br = null;
        String weatherString;
        try {
            String apikey = "c1ba221295a6e24405c1b3c778db79a9";
            String londonweatherquery = "http://api.openweathermap.org/data/2.5/weather?q=Vancouver,ca&APPID=";
            String theURL=londonweatherquery+apikey;

            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));


            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());

            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray weather = jsonObject.getJSONArray("weather");
            String[] split = weather.toString().split(",",4);

            String[] split1 = split[1].split("\"", 5);
            weatherString = "The weather now is: "+ split1[3];

        } finally {

            if (br != null) {
                br.close();
            }
        }
        return weatherString;
    }
}
