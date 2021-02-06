package benji.chiwaya.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie{
    
    String title;
    String overView;
    String posterPath;
    String backdropPath;
    
    public Movie(JSONObject jsonObject) throws JSONException {
        title= jsonObject.getString("title");
        overView = jsonObject.getString("overview");
        posterPath = jsonObject.getString("poster_path");
        backdropPath = jsonObject.getString("backdrop_path");
        
    }
    
    public static List<Movie> fromJsonArray(JSONArray jsonArray)
    {
        List<Movie>movies = new ArrayList<>();
        for(int i = 0; i <jsonArray.length(); i++) {
            try {
                movies.add(new Movie(jsonArray.getJSONObject(i)));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return movies;
    }
    
    public String getBackdropPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
    
    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }
    
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getOverView() {
        return overView;
    }
    
    public void setOverView(String overView) {
        this.overView = overView;
    }
}
