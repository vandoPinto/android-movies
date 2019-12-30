package br.com.moviestart.flixmovies.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.moviestart.flixmovies.databinding.FragmentCadastroBinding
import br.com.moviestart.flixmovies.viewmodel.CadastroViewModel

class CadastroFragment : Fragment() {

    private lateinit var binding: FragmentCadastroBinding

    private val viewModel: CadastroViewModel by lazy {
        ViewModelProviders.of(this@CadastroFragment).get(CadastroViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCadastroBinding.inflate(inflater, container, false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
