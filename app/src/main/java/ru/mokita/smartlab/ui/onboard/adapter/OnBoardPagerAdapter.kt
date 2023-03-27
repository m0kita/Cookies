package ru.mokita.smartlab.ui.onboard.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.mokita.smartlab.R
import ru.mokita.smartlab.databinding.ItemOnBoardPagerBinding
import ru.mokita.smartlab.ui.onboard.core.OnBoardStep

class OnBoardPagerAdapter() :
    RecyclerView.Adapter<OnBoardPagerAdapter.PagerViewHolder>() {
    inner class PagerViewHolder(val binding: ItemOnBoardPagerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: OnBoardStep) {
            binding.tvHeader.text = item.header
            binding.tvDescription.text = item.description
            binding.ivLogo.setImageResource(item.resId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagerViewHolder {
        val binding =
            ItemOnBoardPagerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PagerViewHolder(binding)
    }

    override fun getItemCount(): Int = steps.size

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(steps[position])

    }

    companion object {
        private val steps = listOf(
            OnBoardStep("Анализы", "Экспресс сбор и получение проб", R.drawable.analises),
            OnBoardStep("Уведомления", "Вы быстро узнаете о результатах", R.drawable.notification),
            OnBoardStep(
                "Мониторинг",
                "Наши врачи всегда наблюдают за вашими показателями здоровья",
                R.drawable.monitoring
            )
        )
    }
}