package com.example.jasonjinsooyoo.freefindr.Tasks;

import com.example.jasonjinsooyoo.freefindr.MapsActivity;
import com.example.jasonjinsooyoo.freefindr.Utilities.JSONParser;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Alec on 2017-03-18.
 */

public class RetrieveHttpDataTask extends android.os.AsyncTask<String, Void, String> {

    private Exception exception;
    @Override
    protected String doInBackground(String... urls) {
        try {
            URL url = new URL(urls[0]);
            String result = getResponseFromHttpUrl(url);


            System.out.println(result);
            return result;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    @Override
    protected void onPostExecute(String result)  {
        try {
            JSONParser jsone = new JSONParser(new MapsActivity());
            jsone.parseJSONEventData(result);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    private String getResponseFromHttpUrl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }

        } finally {
            urlConnection.disconnect();
        }
    }
}
