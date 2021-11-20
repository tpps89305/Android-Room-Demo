package com.dispy.roomdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dispy.roomdemo.databinding.RecyclerviewItemBinding

/**
 * Created by tpps8 on 2021/11/20
 *
 */
class UserListAdapter : ListAdapter<User, UserListAdapter.UserViewHolder>(UserComparator()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class UserViewHolder(private val binding: RecyclerviewItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.textName.text = user.name
            binding.textAge.text = user.age.toString()
            binding.textAddress.text = user.address
        }

        companion object {
            fun create(parent: ViewGroup): UserViewHolder {
                return UserViewHolder(
                    RecyclerviewItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    class UserComparator : DiffUtil.ItemCallback<User>() {

        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem.name == newItem.name
                    && oldItem.age == newItem.age
                    && oldItem.address == newItem.address
        }

    }

}