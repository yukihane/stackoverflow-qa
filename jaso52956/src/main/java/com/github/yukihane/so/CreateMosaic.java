package com.github.yukihane.so;

import android.util.Log;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.util.Arrays;

public class CreateMosaic {
    public void CreateMosaicArt(String pMosaic){
        int size=0;
        int w=0;
        int h=0;
        Log.d("json",pMosaic);

        JsonObject jsonObject=(JsonObject) new Gson().fromJson(pMosaic,JsonObject.class);

        size=jsonObject.getAsJsonObject().get("block_size").getAsInt();
        w=jsonObject.getAsJsonObject().get("mosaic_size_w").getAsInt();
        h=jsonObject.getAsJsonObject().get("mosaic_size_h").getAsInt();
        int imgNum[]=new int[w*h];
        for (int i = 0; i < jsonObject.size() - 3; i++) {
            imgNum[i]=jsonObject.getAsJsonObject().get(String.valueOf(i)).getAsInt();
        }
        Log.d("size",String.valueOf(size));
        Log.d("w",String.valueOf(w));
        Log.d("h",String.valueOf(h));
        Log.d("imgs", Arrays.toString(imgNum));

    }

}
