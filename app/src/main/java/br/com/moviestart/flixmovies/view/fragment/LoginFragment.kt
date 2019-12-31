package br.com.moviestart.flixmovies.view.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import br.com.moviestart.flixmovies.R
import br.com.moviestart.flixmovies.databinding.FragmentLoginBinding
import br.com.moviestart.flixmovies.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this@LoginFragment).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container,false)
        binding.fragment = this
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }

    fun forgot() {
        findNavController().navigate(R.id.action_loginFragment_to_redefinirSenhaFragment)
    }

    fun register() {
        findNavController().navigate(R.id.action_loginFragment_to_cadastroFragment)
    }

}
