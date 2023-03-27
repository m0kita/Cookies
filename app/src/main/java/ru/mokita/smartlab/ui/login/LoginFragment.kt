package ru.mokita.smartlab.ui.login

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.FragmentLoginBinding
import ru.mokita.smartlab.databinding.FragmentOnBoardBinding
import ru.mokita.smartlab.ui.login.entercode.EnterCodeFragmentDirections

class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupEditText()
        binding.btnContinue.setOnClickListener {
            viewModel.sendCode(binding.etEmail.text.toString())
        }
        lifecycleScope.launchWhenStarted {
            viewModel.success.collect {
                if (it) {
                    findNavController().navigate(
                        LoginFragmentDirections.actionLoginFragmentToEnterCodeFragment(
                            binding.etEmail.text.toString()
                        )
                    )
                }
            }
        }

    }

    fun setupEditText() {
        binding.etEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (s != null) {
                    val regex = """(.+)@(.+)\.(.+)""".toRegex()
                    val email = regex.matchEntire(s)
                    if (email != null) {
                        val (name, mail, domain) = email.destructured
                        binding.btnContinue.isEnabled = domain.length > 1
                    }
                }
            }

        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}