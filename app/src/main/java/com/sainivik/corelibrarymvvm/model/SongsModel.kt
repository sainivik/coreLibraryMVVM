package com.sainivik.corelibrarymvvm.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.whide.partner.data.repository.models.base.BaseDaoModel


@Entity(tableName = "songTable")
data class SongsModel(
	@PrimaryKey(autoGenerate = true)
	@NonNull
	@ColumnInfo(name = "primaryKey")
	var primaryKey: Int,

	@ColumnInfo(name = "artworkUrl100")
	@field:SerializedName("artworkUrl100")
	val artworkUrl100: String? = null,

	@ColumnInfo(name = "trackTimeMillis")
	@field:SerializedName("trackTimeMillis")
	val trackTimeMillis: Int? = null,

	@ColumnInfo(name = "country")
	@field:SerializedName("country")
	val country: String? = null,

	@ColumnInfo(name = "previewUrl")
	@field:SerializedName("previewUrl")
	val previewUrl: String? = null,

	@ColumnInfo(name = "artistId")
	@field:SerializedName("artistId")
	val artistId: Int? = null,

	@ColumnInfo(name = "trackName")
	@field:SerializedName("trackName")
	val trackName: String? = null,

	@ColumnInfo(name = "collectionName")
	@field:SerializedName("collectionName")
	val collectionName: String? = null,

	@ColumnInfo(name = "artistViewUrl")
	@field:SerializedName("artistViewUrl")
	val artistViewUrl: String? = null,

	@ColumnInfo(name = "discNumber")
	@field:SerializedName("discNumber")
	val discNumber: Int? = null,

	@ColumnInfo(name = "trackCount")
	@field:SerializedName("trackCount")
	val trackCount: Int? = null,

	@ColumnInfo(name = "artworkUrl30")
	@field:SerializedName("artworkUrl30")
	val artworkUrl30: String? = null,

	@ColumnInfo(name = "wrapperType")
	@field:SerializedName("wrapperType")
	val wrapperType: String? = null,

	@ColumnInfo(name = "currency")
	@field:SerializedName("currency")
	val currency: String? = null,

	@ColumnInfo(name = "collectionId")
	@field:SerializedName("collectionId")
	val collectionId: Int? = null,

	@ColumnInfo(name = "trackExplicitness")
	@field:SerializedName("trackExplicitness")
	val trackExplicitness: String? = null,

	@ColumnInfo(name = "collectionViewUrl")
	@field:SerializedName("collectionViewUrl")
	val collectionViewUrl: String? = null,

	@ColumnInfo(name = "trackNumber")
	@field:SerializedName("trackNumber")
	val trackNumber: Int? = null,

	@ColumnInfo(name = "releaseDate")
	@field:SerializedName("releaseDate")
	val releaseDate: String? = null,

	@ColumnInfo(name = "kind")
	@field:SerializedName("kind")
	val kind: String? = null,

	@ColumnInfo(name = "trackId")
	@field:SerializedName("trackId")
	val trackId: Int? = null,

	@ColumnInfo(name = "collectionPrice")
	@field:SerializedName("collectionPrice")
	val collectionPrice: Double? = null,

	@ColumnInfo(name = "discCount")
	@field:SerializedName("discCount")
	val discCount: Int? = null,

	@ColumnInfo(name = "primaryGenreName")
	@field:SerializedName("primaryGenreName")
	val primaryGenreName: String? = null,

	@ColumnInfo(name = "trackPrice")
	@field:SerializedName("trackPrice")
	val trackPrice: Double? = null,

	@ColumnInfo(name = "collectionExplicitness")
	@field:SerializedName("collectionExplicitness")
	val collectionExplicitness: String? = null,

	@ColumnInfo(name = "trackViewUrl")
	@field:SerializedName("trackViewUrl")
	val trackViewUrl: String? = null,

	@ColumnInfo(name = "artworkUrl60")
	@field:SerializedName("artworkUrl60")
	val artworkUrl60: String? = null,

	@ColumnInfo(name = "trackCensoredName")
	@field:SerializedName("trackCensoredName")
	val trackCensoredName: String? = null,

	@ColumnInfo(name = "artistName")
	@field:SerializedName("artistName")
	val artistName: String? = null,

	@ColumnInfo(name = "collectionCensoredName")
	@field:SerializedName("collectionCensoredName")
	val collectionCensoredName: String? = null
) : BaseDaoModel()
