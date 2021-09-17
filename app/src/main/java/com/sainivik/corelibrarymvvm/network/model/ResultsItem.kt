package com.sainivik.corelibrarymvvm.network.model;

import android.graphics.Bitmap;

public class ResultsItem{
	private String artworkUrl100;
	private int trackTimeMillis;
	private String country;
	private String previewUrl;
	private int artistId;
	private String trackName;
	private String collectionName;
	private String artistViewUrl;
	private int discNumber;
	private int trackCount;
	private String artworkUrl30;
	private Bitmap bitmap;

	public Bitmap getBitmap() {
		return bitmap;
	}

	public void setBitmap(Bitmap bitmap) {
		this.bitmap = bitmap;
	}

	public void setArtworkUrl100(String artworkUrl100) {
		this.artworkUrl100 = artworkUrl100;
	}

	public void setTrackTimeMillis(int trackTimeMillis) {
		this.trackTimeMillis = trackTimeMillis;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public void setTrackName(String trackName) {
		this.trackName = trackName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

	public void setArtistViewUrl(String artistViewUrl) {
		this.artistViewUrl = artistViewUrl;
	}

	public void setDiscNumber(int discNumber) {
		this.discNumber = discNumber;
	}

	public void setTrackCount(int trackCount) {
		this.trackCount = trackCount;
	}

	public void setArtworkUrl30(String artworkUrl30) {
		this.artworkUrl30 = artworkUrl30;
	}

	public void setWrapperType(String wrapperType) {
		this.wrapperType = wrapperType;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setCollectionId(int collectionId) {
		this.collectionId = collectionId;
	}

	public void setStreamable(boolean streamable) {
		isStreamable = streamable;
	}

	public void setTrackExplicitness(String trackExplicitness) {
		this.trackExplicitness = trackExplicitness;
	}

	public void setCollectionViewUrl(String collectionViewUrl) {
		this.collectionViewUrl = collectionViewUrl;
	}

	public void setTrackNumber(int trackNumber) {
		this.trackNumber = trackNumber;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public void setTrackId(int trackId) {
		this.trackId = trackId;
	}

	public void setCollectionPrice(double collectionPrice) {
		this.collectionPrice = collectionPrice;
	}

	public void setDiscCount(int discCount) {
		this.discCount = discCount;
	}

	public void setPrimaryGenreName(String primaryGenreName) {
		this.primaryGenreName = primaryGenreName;
	}

	public void setTrackPrice(double trackPrice) {
		this.trackPrice = trackPrice;
	}

	public void setCollectionExplicitness(String collectionExplicitness) {
		this.collectionExplicitness = collectionExplicitness;
	}

	public void setTrackViewUrl(String trackViewUrl) {
		this.trackViewUrl = trackViewUrl;
	}

	public void setArtworkUrl60(String artworkUrl60) {
		this.artworkUrl60 = artworkUrl60;
	}

	public void setTrackCensoredName(String trackCensoredName) {
		this.trackCensoredName = trackCensoredName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public void setCollectionCensoredName(String collectionCensoredName) {
		this.collectionCensoredName = collectionCensoredName;
	}

	public void setCollectionArtistName(String collectionArtistName) {
		this.collectionArtistName = collectionArtistName;
	}

	public void setCollectionArtistId(int collectionArtistId) {
		this.collectionArtistId = collectionArtistId;
	}

	public void setCollectionArtistViewUrl(String collectionArtistViewUrl) {
		this.collectionArtistViewUrl = collectionArtistViewUrl;
	}

	public void setCopyright(String copyright) {
		this.copyright = copyright;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String wrapperType;
	private String currency;
	private int collectionId;
	private boolean isStreamable;
	private String trackExplicitness;
	private String collectionViewUrl;
	private int trackNumber;
	private String releaseDate;
	private String kind;
	private int trackId;
	private double collectionPrice;
	private int discCount;
	private String primaryGenreName;
	private double trackPrice;
	private String collectionExplicitness;
	private String trackViewUrl;
	private String artworkUrl60;
	private String trackCensoredName;
	private String artistName;
	private String collectionCensoredName;
	private String collectionArtistName;
	private int collectionArtistId;
	private String collectionArtistViewUrl;
	private String copyright;
	private String description;

	public String getArtworkUrl100(){
		return artworkUrl100;
	}

	public int getTrackTimeMillis(){
		return trackTimeMillis;
	}

	public String getCountry(){
		return country;
	}

	public String getPreviewUrl(){
		return previewUrl;
	}

	public int getArtistId(){
		return artistId;
	}

	public String getTrackName(){
		return trackName;
	}

	public String getCollectionName(){
		return collectionName;
	}

	public String getArtistViewUrl(){
		return artistViewUrl;
	}

	public int getDiscNumber(){
		return discNumber;
	}

	public int getTrackCount(){
		return trackCount;
	}

	public String getArtworkUrl30(){
		return artworkUrl30;
	}

	public String getWrapperType(){
		return wrapperType;
	}

	public String getCurrency(){
		return currency;
	}

	public int getCollectionId(){
		return collectionId;
	}

	public boolean isIsStreamable(){
		return isStreamable;
	}

	public String getTrackExplicitness(){
		return trackExplicitness;
	}

	public String getCollectionViewUrl(){
		return collectionViewUrl;
	}

	public int getTrackNumber(){
		return trackNumber;
	}

	public String getReleaseDate(){
		return releaseDate;
	}

	public String getKind(){
		return kind;
	}

	public int getTrackId(){
		return trackId;
	}

	public double getCollectionPrice(){
		return collectionPrice;
	}

	public int getDiscCount(){
		return discCount;
	}

	public String getPrimaryGenreName(){
		return primaryGenreName;
	}

	public double getTrackPrice(){
		return trackPrice;
	}

	public String getCollectionExplicitness(){
		return collectionExplicitness;
	}

	public String getTrackViewUrl(){
		return trackViewUrl;
	}

	public String getArtworkUrl60(){
		return artworkUrl60;
	}

	public String getTrackCensoredName(){
		return trackCensoredName;
	}

	public String getArtistName(){
		return artistName;
	}

	public String getCollectionCensoredName(){
		return collectionCensoredName;
	}

	public String getCollectionArtistName(){
		return collectionArtistName;
	}

	public int getCollectionArtistId(){
		return collectionArtistId;
	}

	public String getCollectionArtistViewUrl(){
		return collectionArtistViewUrl;
	}

	public String getCopyright(){
		return copyright;
	}

	public String getDescription(){
		return description;
	}
}
