package br.com.moviestart.flixmovies.repository.mapper

import br.com.moviestart.flixmovies.domain.Movie
import br.com.moviestart.flixmovies.repository.dto.network.MovieDTO
import org.mapstruct.Mapper

@Mapper
interface MovieMapper {

    fun toDTO(domain: Movie): MovieDTO

    fun toDomain(dto: MovieDTO): Movie
}