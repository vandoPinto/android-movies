package br.com.moviestart.flixmovies.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.databinding.ItemListMovieBinding
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.viewmodel.MainViewModel
import com.squareup.picasso.Picasso

class MovieAdapter(
    private val movies: Array<Movie>,
    private val viewModel: MainViewModel
) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        val binding = holder.binding

        binding.movie = movie
        binding.viewmodel = viewModel

        binding.executePendingBindings()
    }

    override fun getItemCount(): Int = movies.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding: ItemListMovieBinding = ItemListMovieBinding.bind(view)
    }

    companion object {

        @JvmStatic
        @BindingAdapter("bind:imageUrl")
        fun setImageUrl(
            view: AppCompatImageView,
            url: String
        ) {
            Picasso.get().load(url).into(view)
        }
    }
}