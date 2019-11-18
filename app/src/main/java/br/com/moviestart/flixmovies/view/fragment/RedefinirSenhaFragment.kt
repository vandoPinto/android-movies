package br.com.moviestart.flixmovies.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.viewmodel.RedefinirSenhaViewModel

class RedefinirSenhaFragment : Fragment() {

    companion object {
        fun newInstance() = RedefinirSenhaFragment()
    }

    private lateinit var viewModel: RedefinirSenhaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_redefinir_senha, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RedefinirSenhaViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
