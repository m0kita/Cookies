package ru.mokita.smartlab.ui.login.createpassword

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.navigation.fragment.findNavController
import com.davidmiguel.numberkeyboard.NumberKeyboardListener
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.FragmentCreatePasswordBinding
import ru.mokita.smartlab.databinding.FragmentEnterCodeBinding

class CreatePasswordFragment : Fragment() {
    private var _binding: FragmentCreatePasswordBinding? = null
    private val binding get() = _binding!!
    private var pinCode: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupUI() {
        setupKeyboard()
        binding.tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_createPasswordFragment_to_analysesFragment)
        }
    }

    private fun setupKeyboard() = with(binding) {
        pinPassword.setOnPinChangeListener(
            onPinChange = { pin ->

            },
            onPinComplete = {
                pinCode = it
                findNavController().navigate(R.id.action_createPasswordFragment_to_createCardFragment)
            }
        )
        keyboard.setListener(object : NumberKeyboardListener {
            override fun onLeftAuxButtonClicked() {}
            override fun onNumberClicked(number: Int) {
                pinPassword.addPinCode(number.toString())
            }

            override fun onRightAuxButtonClicked() {
                pinPassword.removePinCode()
            }

        })
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}