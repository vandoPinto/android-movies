package br.com.moviestart.flixmovies.repository

import android.content.Context
import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.repository.dto.network.MovieQueryOrderBy
import br.com.moviestart.flixmovies.repository.dto.network.MovieResultDTO
import br.com.moviestart.flixmovies.repository.mapper.MovieMapper
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import org.mapstruct.factory.Mappers
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("discover/movie")
    fun lastMovies(@Query("sort_by") sortBy: String): Single<MovieResultDTO>

}

class MovieRepository(val context: Context) :
    RetrofitBase(context, "https://api.themoviedb.org/3/")
{
    private val movieService = retrofit.create(MovieService::class.java)

    fun lastMovies(sortBy: MovieQueryOrderBy): Single<Array<Movie>> {
        val domainMapper = Mappers.getMapper(MovieMapper::class.java)

        return movieService.lastMovies(sortBy.value)
            .map { result ->

                val list = mutableListOf<Movie>()
                result.movies.forEach {
                    list.add(domainMapper.toDomain(it))
                }

                list.toTypedArray()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())

    }
}