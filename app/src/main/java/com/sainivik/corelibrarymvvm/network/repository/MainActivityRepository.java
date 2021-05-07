package com.sainivik.corelibrarymvvm.network.repository;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.sainivik.corelibrarymvvm.network.api.ApiCall;
import com.sainivik.corelibrarymvvm.network.model.ResultsItem;
import com.sainivik.corelibrarymvvm.network.model.SongsResponse;
import com.sainivik.corelibrarymvvm.network.tool.JSONParser;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivityRepository {


    public static SongsResponse processImageListRequest() {
        SongsResponse data = new SongsResponse();
        ResultsItem itemModel;
        ArrayList<ResultsItem> itemList = new ArrayList<>();
        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = jsonParser.getJSONFromUrl(ApiCall.BASEURL + ApiCall.SONGSLIST);
        try {
            Log.d("response", jsonObject.toString());
            JSONArray jsonSongs = jsonObject.getJSONArray("results");
            for (int i = 0; i < jsonSongs.length() - 1; i++) {
                JSONObject JsonObj = jsonSongs.getJSONObject(i);

                itemModel = new ResultsItem();

                if (JsonObj.has("description")) {
                    itemModel.setDescription(JsonObj.getString("description"));
                }
                if (JsonObj.has("trackName")) {
                    itemModel.setTrackName(JsonObj.getString("trackName"));
                }

                if (JsonObj.has("wrapperType")) {
                    itemModel.setWrapperType(JsonObj.getString("wrapperType"));
                }
                if (JsonObj.has("collectionArtistName")) {
                    itemModel.setCollectionArtistName(JsonObj.getString("collectionArtistName"));
                }
                if (JsonObj.has("collectionName")) {
                    itemModel.setCollectionName(JsonObj.getString("collectionName"));
                }
                if (JsonObj.has("copyright")) {
                    itemModel.setCopyright(JsonObj.getString("copyright"));
                }
                if (JsonObj.has("country")) {
                    itemModel.setCountry(JsonObj.getString("country"));
                }
                if (JsonObj.has("collectionCensoredName")) {
                    itemModel.setCollectionCensoredName(JsonObj.getString("collectionCensoredName"));
                }
                if (JsonObj.has("artistName")) {
                    itemModel.setArtistName(JsonObj.getString("artistName"));
                }

                if (JsonObj.has("currency")) {
                    itemModel.setCurrency(JsonObj.getString("currency"));
                }
                if (JsonObj.has("releaseDate")) {
                    itemModel.setReleaseDate(JsonObj.getString("releaseDate"));
                }
                if (JsonObj.has("collectionPrice")) {
                    itemModel.setCollectionPrice(JsonObj.getDouble("collectionPrice"));
                }
                if (JsonObj.has("primaryGenreName")) {
                    itemModel.setPrimaryGenreName(JsonObj.getString("primaryGenreName"));
                }
                if (JsonObj.has("trackCensoredName")) {
                    itemModel.setTrackCensoredName(JsonObj.getString("trackCensoredName"));
                }
                if (JsonObj.has("artworkUrl100")) {
                    itemModel.setArtworkUrl100(JsonObj.getString("artworkUrl100"));
                }


                // itemModel.setTrackTimeMillis(JsonObj.getInt("trackTimeMillis"));
                //itemModel.setArtistId(JsonObj.getInt("artistId"));
                //
                // itemModel.setDiscNumber(JsonObj.getInt("discNumber"));
                // itemModel.setArtworkUrl30(JsonObj.getString("artworkUrl30"));
                //
                //itemModel.setCollectionId(JsonObj.getInt("collectionId"));
                // itemModel.isIsStreamable(JsonObj.getBoolean("isStreamable"));
                //  itemModel.setTrackExplicitness(JsonObj.getString("trackExplicitness"));
                //itemModel.setTrackNumber(JsonObj.getInt("trackNumber"));
                //itemModel.setKind(JsonObj.getString("kind"));
                //  itemModel.setTrackId(JsonObj.getInt("trackId"));
                //  itemModel.setCollectionExplicitness(JsonObj.getString("collectionExplicitness"));
                //
                //  itemModel.setCollectionArtistId(JsonObj.getInt("collectionArtistId"));
                //
                // itemModel.setCollectionArtistViewUrl(JsonObj.getString("collectionArtistViewUrl"));
                // itemModel.setDiscCount(JsonObj.getInt("discCount"));
                //
                // itemModel.setTrackPrice(JsonObj.getDouble("trackPrice"));
                // itemModel.setTrackViewUrl(JsonObj.getString("trackViewUrl"));
                //
                //itemModel.setArtistViewUrl(JsonObj.getString("artistViewUrl"));


                //
                //
//                itemModel.setPreviewUrl(JsonObj.getString("previewUrl"));
//                itemModel.setTrackCount(JsonObj.getInt("trackCount"));
//
//                itemModel.setCollectionViewUrl(JsonObj.getString("collectionViewUrl"));
//
//
//
//                itemModel.setArtworkUrl60(JsonObj.getString("artworkUrl60"));
//
//


                itemList.add(itemModel);
            }
            data.setResults(itemList);

            return data;
        } catch (Exception e) {
            return null;
        }

    }

    public static Bitmap downloadThisImage(String photo) throws MalformedURLException {

        final URL url = new URL(photo);
        Log.d("URL", url.toString());
        Bitmap image = null;
        try {
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


}
