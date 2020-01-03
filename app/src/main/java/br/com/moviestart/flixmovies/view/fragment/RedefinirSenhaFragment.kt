package br.com.moviestart.flixmovies.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import br.com.moviestart.flixmovies.AppResult

import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.databinding.FragmentRedefinirSenhaBinding
import br.com.moviestart.flixmovies.viewmodel.RedefinirSenhaViewModel

class RedefinirSenhaFragment : Fragment() {

    private lateinit var binding: FragmentRedefinirSenhaBinding

    private val viewModel: RedefinirSenhaViewModel by lazy {
        ViewModelProviders.of(this@RedefinirSenhaFragment).get(RedefinirSenhaViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRedefinirSenhaBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val emailSucess = this.context?.getString(R.string.email_sucess)
        val emailError = this.context?.getString(R.string.email_error)
        val genericError = this.context?.getString(R.string.generic_error)


        viewModel.result.observe(this@RedefinirSenhaFragment) {
            when (it) {
                is AppResult.Success -> {
                    Toast.makeText(this.context, emailSucess, Toast.LENGTH_SHORT).show()
                }
                is AppResult.Error -> {
                    if (it.error != null) {
                        Toast.makeText(this.context, emailError, Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(this.context,genericError, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        return binding.root
    }

}
