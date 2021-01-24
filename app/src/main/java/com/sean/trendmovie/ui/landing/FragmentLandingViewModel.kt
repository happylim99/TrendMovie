package com.sean.trendmovie.ui.landing

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sean.trendmovie.model.Movie
import com.sean.trendmovie.repository.MovieRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import timber.log.Timber

class FragmentLandingViewModel @ViewModelInject constructor(
    movieRepository: MovieRepository
) : ViewModel() {
    private val _trendingMovies = MutableLiveData<List<Movie>>()
    val trendingMovies: LiveData<List<Movie>>
    get() = _trendingMovies

    init {
        movieRepository.getTrendingMovie()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({movieResponse -> _trendingMovies.value = movieResponse.results},
                { error -> Timber.e(error)})
    }
}
