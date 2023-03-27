package ru.mokita.smartlab.ui.home.analyses

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.mokita.smartlab.BuildConfig
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.FragmentAnalysesBinding
import ru.mokita.smartlab.databinding.FragmentLoginBinding

class AnalysesFragment : Fragment() {
    private var _binding: FragmentAnalysesBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAnalysesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}