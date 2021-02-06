package benji.chiwaya.flixster.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import benji.chiwaya.flixster.R;
import benji.chiwaya.flixster.models.Movie;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    Context context;
    List<Movie> movies;
    
    public MovieAdapter(Context context, List<Movie> moives)
    {
        this.context = context;
        this.movies =moives;
    }
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie,parent, false);
        
        return new ViewHolder(movieView);
    }
    
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        
        Movie movie = movies.get(position);
        holder.bind(movie);
    
    }
    
    @Override
    public int getItemCount() {
        return movies.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvTitle;
        TextView tvOverview;
        ImageView tvPoster;
    
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvOverview  = itemView.findViewById(R.id.tvOverview);
            tvPoster = itemView.findViewById(R.id.tvPoster);
        }
    
        public void bind(Movie movie) {
            
            tvTitle.setText(movie.getTitle());
            tvOverview.setText(movie.getOverView());
            String url= "";
            switch(context.getResources().getConfiguration().orientation)
            {
                case Configuration.ORIENTATION_LANDSCAPE: url = movie.getPosterPath();
                break;
                case Configuration.ORIENTATION_PORTRAIT:  url = movie.getBackdropPath();
                break;
                
                default: url = movie.getBackdropPath();
                
            }
            
            Glide.with(context).load(url).into(tvPoster);
            
        }
    }
}
