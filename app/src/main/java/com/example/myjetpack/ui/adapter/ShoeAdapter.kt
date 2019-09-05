package com.example.myjetpack.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myjetpack.databinding.ItemShoeLayoutBinding
import com.example.myjetpack.db.data.Shoe
import com.example.myjetpack.utils.ToastUtils

/**
 * 鞋子的适配器 配合Data Binding使用
 */
class ShoeAdapter constructor(val context: Context) :
    PagedListAdapter<Shoe, ShoeAdapter.ViewHolder>(ShoeDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemShoeLayoutBinding.inflate(
                LayoutInflater.from(parent.context)
                , parent
                , false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoe = getItem(position)
        holder.apply {
            bind(onCreateListener(shoe!!.id), shoe)
            itemView.tag = shoe
        }
    }

    /**
     * Holder的点击事件
     */
    private fun onCreateListener(id: Long): View.OnClickListener {
        return View.OnClickListener {
            //            val intent = Intent(context, DetailActivity::class.java)
//            intent.putExtra(Constant.DETAIL_SHOE_ID, id)
//            context.startActivity(intent)
            ToastUtils.showShort(context, "dianjile")
        }
    }


    class ViewHolder(private val binding: ItemShoeLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Shoe) {
            binding.apply {
                this.listener = listener
                this.shoe = item
                executePendingBindings()
            }
        }
    }
}