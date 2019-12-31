package br.com.moviestart.flixmovies.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.interactor.MovieInteractor
import br.com.moviestart.flixmovies.repository.dto.network.MovieQueryOrderBy
import io.reactivex.disposables.Disposable

class MainViewModel(val app: Application) : AndroidViewModel(app) {
    private val interactor = MovieInteractor(app.applicationContext)

    private var disposable: Disposable? = null

    val lastMovies = MutableLiveData<AppResult<Array<Movie>>>()

    fun getLastMovies() {
        disposable =
            interactor.lastMovies(MovieQueryOrderBy.PopularityAsc())
                .subscribe { res, error ->
                    if (error != null) {
                        lastMovies.value = AppResult.Error(error)
                        return@subscribe
                    }

                    lastMovies.value = AppResult.Success(res)
                }
    }

    fun getTopRated() {
        disposable =
            interactor.topRated(MovieQueryOrderBy.PopularityAsc())
                .subscribe { res, error ->
                    if (error != null) {
                        lastMovies.value = AppResult.Error(error)
                        return@subscribe
                    }

                    lastMovies.value = AppResult.Success(res)
                }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }
}