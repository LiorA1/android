package com.example.downloadingwebcontent;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity
{

    // AsyncTask is good for UI back Thread.
    // Look for further information about AsyncTask VS Handler VS Thread in :
    // https://stackoverflow.com/questions/6964011/handler-vs-asynctask-vs-thread
    public class DownloadTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... strings)
        {
            StringBuilder result = new StringBuilder();
            URL url;
            HttpURLConnection urlConnection = null;

            try
            {
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inStream = urlConnection.getInputStream();
                InputStreamReader reader = new InputStreamReader(inStream);
                int data = reader.read();

                // Read char after char.
                while( data != -1)
                {
                    char current = (char) data;

                    result.append(current);

                    data = reader.read();
                }

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();

                return e.getMessage();
            }
            catch (Exception e)
            {
                e.printStackTrace();

                return e.getMessage();
            }


            return result.toString();
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DownloadTask task = new DownloadTask();

        String result = null;
        try
        {
            result = task.execute("http://www.google.com").get();

            Log.v("LogV: ", result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
