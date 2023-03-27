package ru.mokita.smartlab.ui.login.entercode

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.NonCancellable.start
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.FragmentEnterCodeBinding
import ru.mokita.smartlab.ui.login.createpassword.CreatePasswordFragmentDirections

class EnterCodeFragment : Fragment() {
    private val navArgs by navArgs<EnterCodeFragmentArgs>()
    private val viewModel: EnterCodeViewModel by viewModels()
    private val countDownTimer = object : CountDownTimer(60000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
            val seconds = (millisUntilFinished / 1000).toInt()
            binding.tvRepeatSendCode.text = getString(R.string.timer, seconds.toString())
        }
        override fun onFinish() {}
    }
    private var _binding: FragmentEnterCodeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        startTimer()
        binding.etCode.setOnCodeChangedListener { (code, completed) ->
            if (completed) {
                viewModel.signIn(navArgs.email, code)
                lifecycleScope.launchWhenStarted {
                    viewModel.isCorrect.collect{
                        if(it) {
                            countDownTimer.cancel()
                            findNavController().navigate(R.id.action_enterCodeFragment_to_createPasswordFragment)
                        }
                    }
                }
            }
        }
        binding.ibtnBack.setOnClickListener {
            findNavController().navigate(R.id.action_enterCodeFragment_to_loginFragment)
        }
    }

    private fun startTimer() {
        countDownTimer.start()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEnterCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        countDownTimer.cancel()
        _binding = null
    }

}