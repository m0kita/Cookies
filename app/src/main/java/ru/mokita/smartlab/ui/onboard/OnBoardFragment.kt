package ru.mokita.smartlab.ui.onboard

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.coroutines.launch
import ru.mokita.data.network.SmartLabClient
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.FragmentOnBoardBinding
import ru.mokita.smartlab.ui.onboard.adapter.OnBoardPagerAdapter

class OnBoardFragment : Fragment() {

    private var _binding: FragmentOnBoardBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
    }

    private fun setupPager() {
        val adapter = OnBoardPagerAdapter()
        binding.vpOnBoard.adapter = adapter

        TabLayoutMediator(binding.tlPager, binding.vpOnBoard) { tab, position ->
        }.attach()

        binding.tlPager.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab?.position == 2) {
                    binding.tvSkip.text = "Завершить"
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                if (tab?.position == 2) {
                    binding.tvSkip.text = "Пропустить"
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }

    private fun setupUI() {
        setupPager()
        binding.tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_onBoardFragment_to_loginFragment)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}