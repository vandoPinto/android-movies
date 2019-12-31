package br.com.moviestart.flixmovies.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.databinding.FragmentMainBinding
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.view.adapter.MovieAdapter
import br.com.moviestart.flixmovies.viewmodel.MainViewModel

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProviders.of(this@MainFragment).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        viewModel.lastMovies.observe(this) {
            updateLastMovies(it)
        }

        viewModel.getLastMovies()

        return binding.root
    }

    private fun updateLastMovies(result: AppResult<Array<Movie>>) {
        val recycleListView = binding.rvMovies

        recycleListView.layoutManager = LinearLayoutManager(context)

        when (result) {
            is AppResult.Success -> {
                recycleListView.adapter = MovieAdapter(result.data, viewModel)
            }
            is AppResult.Error -> {
                if (result.error != null) {
                    Toast.makeText(
                        this.context,
                        result.error.localizedMessage,
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val genericError = this.context?.getString(R.string.generic_error)

                    Toast.makeText(
                        this.context,
                        genericError,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }
}
