package com.example.itsadmin.triviaadv;



        import android.content.Context;
        import android.graphics.Bitmap;
        import android.graphics.BitmapFactory;
        import android.os.AsyncTask;
        import android.widget.ImageView;

        import java.io.IOException;
        import java.net.HttpURLConnection;
        import java.net.MalformedURLException;
        import java.net.ProtocolException;
        import java.net.URL;
        import java.util.ArrayList;


public class DownloadImageAsyncTaskThread extends AsyncTask<String, Void, Bitmap> {
    private String url;
    private Bitmap bitmap;
    private Context activity;
    private ICommuncateWithImage context;
    private String boop;

    private int questionID = 0;

    DownloadImageAsyncTaskThread(ICommuncateWithImage context){
        this.context = context;
    }



    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        context.sendImage(bitmap);
        //activity.setImage(bitmap,questionID);

    }

    @Override
    protected Bitmap doInBackground(String... params) {
        URL url = null;
        try {
            url = new URL(params[0]);
            //questionID = Integer.parseInt(params[1]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            bitmap = BitmapFactory.decodeStream(httpURLConnection.getInputStream());
            return bitmap;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    static public interface ICommuncateWithImage{
        public Context getContext();
        public void sendImage(Bitmap result);
    }
}