package com.example.heatcam;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestFileReader {
    private Context context;
    private LeptonCamera camera;
    public TestFileReader(Context context, LeptonCamera camera){
        this.context = context;
        this.camera = camera;
    }

    protected void readTestFile(String filu) {//4
        new Thread(() -> {
            try {
                InputStream is = context.getApplicationContext().getAssets().open(filu);
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line;

                while ((line = reader.readLine()) != null){
                    //jokainen line on yksi frame;
                    String[] palat = line.split(" ");// splits a string into a list[i].
                    byte[] tavut = new byte[palat.length];
                    for(int i = 0; i < palat.length; i++){
                        try {
                            tavut[i] = Byte.parseByte(palat[i]); // muutetaan string[i] -> numeroihin
                        } catch (NumberFormatException e) {
                            continue;
                        }
                    }
                    camera.onNewData(tavut);//5 // lähetään numeroisen taulukon
                    Thread.sleep(2);
                }
            } catch (IOException | InterruptedException e ) {
                e.printStackTrace();
            }
        }).start();
    }
}
