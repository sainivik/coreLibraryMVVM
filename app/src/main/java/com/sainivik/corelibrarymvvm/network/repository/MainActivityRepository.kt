package com.sainivik.corelibrarymvvm.network.repository

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Log
import com.sainivik.corelibrarymvvm.network.api.ApiCall
import com.sainivik.corelibrarymvvm.network.model.ResultsItem
import com.sainivik.corelibrarymvvm.network.model.SongsResponse
import com.sainivik.corelibrarymvvm.network.tool.JSONParser
import java.io.IOException
import java.net.MalformedURLException
import java.net.URL
import java.util.*

object MainActivityRepository {
    @JvmStatic
    fun processImageListRequest(): SongsResponse? {
        val data = SongsResponse()
        var itemModel: ResultsItem
        val itemList = ArrayList<ResultsItem>()
        val jsonParser = JSONParser()
        val jsonObject = jsonParser.getJSONFromUrl(ApiCall.BASEURL + ApiCall.SONGSLIST)
        return try {
            Log.d("response", jsonObject.toString())
            val jsonSongs = jsonObject.getJSONArray("results")
            for (i in 0 until jsonSongs.length() - 1) {
                val JsonObj = jsonSongs.getJSONObject(i)
                itemModel = ResultsItem()
                if (JsonObj.has("description")) {
                    itemModel.description = JsonObj.getString("description")
                }
                if (JsonObj.has("trackName")) {
                    itemModel.trackName = JsonObj.getString("trackName")
                }
                if (JsonObj.has("wrapperType")) {
                    itemModel.wrapperType = JsonObj.getString("wrapperType")
                }
                if (JsonObj.has("collectionArtistName")) {
                    itemModel.collectionArtistName = JsonObj.getString("collectionArtistName")
                }
                if (JsonObj.has("collectionName")) {
                    itemModel.collectionName = JsonObj.getString("collectionName")
                }
                if (JsonObj.has("copyright")) {
                    itemModel.copyright = JsonObj.getString("copyright")
                }
                if (JsonObj.has("country")) {
                    itemModel.country = JsonObj.getString("country")
                }
                if (JsonObj.has("collectionCensoredName")) {
                    itemModel.collectionCensoredName = JsonObj.getString("collectionCensoredName")
                }
                if (JsonObj.has("artistName")) {
                    itemModel.artistName = JsonObj.getString("artistName")
                }
                if (JsonObj.has("currency")) {
                    itemModel.currency = JsonObj.getString("currency")
                }
                if (JsonObj.has("releaseDate")) {
                    itemModel.releaseDate = JsonObj.getString("releaseDate")
                }
                if (JsonObj.has("collectionPrice")) {
                    itemModel.collectionPrice = JsonObj.getDouble("collectionPrice")
                }
                if (JsonObj.has("primaryGenreName")) {
                    itemModel.primaryGenreName = JsonObj.getString("primaryGenreName")
                }
                if (JsonObj.has("trackCensoredName")) {
                    itemModel.trackCensoredName = JsonObj.getString("trackCensoredName")
                }
                if (JsonObj.has("artworkUrl100")) {
                    itemModel.artworkUrl100 = JsonObj.getString("artworkUrl100")
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
                itemList.add(itemModel)
            }
            data.results = itemList
            data
        } catch (e: Exception) {
            null
        }
    }

    @JvmStatic
    @Throws(MalformedURLException::class)
    fun downloadThisImage(photo: String?): Bitmap? {
        val url = URL(photo)
        Log.d("URL", url.toString())
        var image: Bitmap? = null
        return try {
            image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            image
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }
}