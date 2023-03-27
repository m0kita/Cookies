package ru.mokita.smartlab.ui.home.analyses.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.mokita.domain.model.News
import ru.mokita.smartlab.databinding.ItemAnalyseBinding
import javax.sql.DataSource

class AnalysesNewsAdapter(
    private val news: List<News>,
    private val context: Context,
) : RecyclerView.Adapter<AnalysesNewsAdapter.AnalyseViewHolder>() {

    inner class AnalyseViewHolder(private val binding: ItemAnalyseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(news: News) {
            Glide.with(context).load().into()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnalyseViewHolder {
        val binding = ItemAnalyseBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AnalyseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnalyseViewHolder, position: Int) {
        holder.onBind(news[position])
    }

    override fun getItemCount(): Int = news.size
}