package com.sainivik.corelibrarymvvm.network.model;

import java.util.ArrayList;
import java.util.List;

public class SongsResponse{
	private int resultCount;
	private ArrayList<ResultsItem> results;

	public void setResultCount(int resultCount) {
		this.resultCount = resultCount;
	}

	public void setResults(ArrayList<ResultsItem> results) {
		this.results = results;
	}

	public int getResultCount(){
		return resultCount;
	}

	public ArrayList<ResultsItem> getResults(){
		return results;
	}
}