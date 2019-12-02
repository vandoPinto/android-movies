package br.com.moviestart.flixmovies.repository.dto.network

import com.google.gson.annotations.SerializedName

data class MovieResultDTO(
    var page: Int,

    @SerializedName("total_results")
    var movieCount: Int,

    @SerializedName("total_pages")
    var pages: Int,

    @SerializedName("results")
    var movies: Array<MovieDTO>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MovieResultDTO

        if (page != other.page) return false
        if (movieCount != other.movieCount) return false
        if (pages != other.pages) return false
        if (!movies.contentEquals(other.movies)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = page
        result = 31 * result + movieCount
        result = 31 * result + pages
        result = 31 * result + movies.contentHashCode()
        return result
    }
}