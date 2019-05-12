package com.example.downloadimage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity
{
    ImageView imageViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewMain = findViewById(R.id.imageView3);

    }

    public void OnClick_Download(View view)
    {
        ImageDownloadTask task = new ImageDownloadTask();
        Bitmap resImage;

        try
        {
            resImage = task.execute("https://cdn.vox-cdn.com/thumbor/Qn3Yq9nyRhccHgwc2wPQmW5P15k=/0x0:1200x798/1400x1400/filters:focal(504x303:696x495):format(png)/cdn.vox-cdn.com/uploads/chorus_image/image/50682439/homer-cover.0.png").get();
            imageViewMain.setImageBitmap(resImage);
        }
        catch (ExecutionException e)
        {
            e.printStackTrace();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }



    }

    public class ImageDownloadTask extends AsyncTask<String, Void, Bitmap>
    {


        @Override
        protected Bitmap doInBackground(String... strings)
        {
            Bitmap myBitmap = null;
            try
            {
                URL url = new URL(strings[0]);
                HttpURLConnection imageConnection = (HttpURLConnection) url.openConnection();

                imageConnection.connect();

                InputStream inStream = imageConnection.getInputStream();

                myBitmap = BitmapFactory.decodeStream(inStream);


            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
            finally
            {
                return myBitmap;
            }


        }
    }
}
