package ru.mokita.smartlab.ui.login.createcard

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.collect
import ru.mokita.smartlab.R
import ru.mokita.smartlab.core.hideKeyboard
import ru.mokita.smartlab.databinding.FragmentCreateCardBinding
import ru.tinkoff.decoro.MaskImpl
import ru.tinkoff.decoro.parser.UnderscoreDigitSlotsParser
import ru.tinkoff.decoro.slots.Slot
import ru.tinkoff.decoro.watchers.MaskFormatWatcher

class CreateCardFragment : Fragment() {
    private val viewModel: CreateCardViewModel by viewModels()
    private var _binding: FragmentCreateCardBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        lifecycleScope.launchWhenStarted {
        }
    }

    private fun setupUI() = with(binding) {
        setupBirthday()
        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_createCardFragment_to_analysesFragment)
        }

        btnCreate.setOnClickListener {
            viewModel.createProfile(
                etName.text.toString(),
                etSecondName.text.toString(),
                etSurname.text.toString(),
                etBirthday.text.toString(),
                spGender.text.toString()
            )
            lifecycleScope.launchWhenStarted {
                viewModel.profile.collect {
                    Log.d("ABOBA", it.toString())
                    findNavController().navigate(R.id.action_createCardFragment_to_analysesFragment)
                }
            }
        }


        setupFields()
    }

    private fun setupFields() = with(binding) {
        etBirthday.addTextChangedListener(setupTextWatcher())
        etName.addTextChangedListener(setupTextWatcher())
        etSurname.addTextChangedListener(setupTextWatcher())
        etSecondName.addTextChangedListener(setupTextWatcher())
        spGender.addTextChangedListener(setupTextWatcher())
    }

    private fun setupTextWatcher() = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            s?.length?.let {
                binding.btnCreate.isEnabled =
                    binding.etName.text.isNotEmpty() && binding.etSecondName.text.isNotEmpty() && binding.etSurname.text.isNotEmpty() && binding.etBirthday.text.isNotEmpty() && binding.spGender.text.isNotEmpty()
            }

        }
    }

    private fun setupBirthday() = with(binding) {
        val slots = UnderscoreDigitSlotsParser().parseSlots("__.__.____")
        val formatWatcher = MaskFormatWatcher(MaskImpl.createTerminated(slots))
        formatWatcher.installOn(etBirthday)
        etBirthday.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) {
                if (s?.length == 10) {
                    binding.btnCreate.isEnabled = true
                    etBirthday.hideKeyboard()
                } else {
                    binding.btnCreate.isEnabled = false
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}