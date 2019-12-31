package br.com.moviestart.flixmovies.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import br.com.moviestart.flixmovies.AppResult
import br.com.moviestart.flixmovies.R
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

        viewModel.result.observe(this@CadastroFragment) {
            when (it) {
                is AppResult.Success -> {
                    Toast.makeText(this.context, "Cadastro criado com sucesso", Toast.LENGTH_SHORT).show()
//                    findNavController().navigate(R.id.action_loginFragment_to_mainActivity)
//                    activity?.finish()
                }
                is AppResult.Error -> {
                    if (it.error != null) {
                        Toast.makeText(this.context, "Erro ao tentar criar a conta", Toast.LENGTH_SHORT).show()
                    }else {
                        val genericError = this.context?.getString(R.string.generic_error)
                        Toast.makeText(this.context,genericError, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
        return binding.root
    }
}
