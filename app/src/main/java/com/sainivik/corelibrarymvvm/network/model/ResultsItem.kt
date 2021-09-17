package com.sainivik.corelibrarymvvm.network.model

import android.graphics.Bitmap

class ResultsItem {
    var artworkUrl100: String? = null
    var trackTimeMillis = 0
    var country: String? = null
    var previewUrl: String? = null
    var artistId = 0
    var trackName: String? = null
    var collectionName: String? = null
    var artistViewUrl: String? = null
    var discNumber = 0
    var trackCount = 0
    var artworkUrl30: String? = null
    var bitmap: Bitmap? = null
    fun setStreamable(streamable: Boolean) {
        isIsStreamable = streamable
    }

    var wrapperType: String? = null
    var currency: String? = null
    var collectionId = 0
    var isIsStreamable = false
        private set
    var trackExplicitness: String? = null
    var collectionViewUrl: String? = null
    var trackNumber = 0
    var releaseDate: String? = null
    var kind: String? = null
    var trackId = 0
    var collectionPrice = 0.0
    var discCount = 0
    var primaryGenreName: String? = null
    var trackPrice = 0.0
    var collectionExplicitness: String? = null
    var trackViewUrl: String? = null
    var artworkUrl60: String? = null
    var trackCensoredName: String? = null
    var artistName: String? = null
    var collectionCensoredName: String? = null
    var collectionArtistName: String? = null
    var collectionArtistId = 0
    var collectionArtistViewUrl: String? = null
    var copyright: String? = null
    var description: String? = null
}