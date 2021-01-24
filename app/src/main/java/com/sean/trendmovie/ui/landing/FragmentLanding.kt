package com.sean.trendmovie.ui.landing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.sean.trendmovie.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_landing.*
import timber.log.Timber

@AndroidEntryPoint
class FragmentLanding : Fragment(R.layout.fragment_landing) {

    private lateinit var movieAdapter: MovieAdapter

    private val fragmentLandingViewModel by viewModels<FragmentLandingViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter()

        tvMovie.layoutManager = LinearLayoutManager(requireContext())
        tvMovie.adapter = movieAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        fragmentLandingViewModel.trendingMovies.observe(viewLifecycleOwner, Observer {
//            Timber.i("success")
            movieAdapter.setMovies(it)
        })
    }

}
