package com.willshuffyproject.githubusers

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.row_item_users.view.*

class UserAdapter constructor(private val context: Context): BaseAdapter() {

    var users = arrayListOf<User>()

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {
        var itemView = view
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.row_item_users, viewGroup, false)
        }

        val viewHolder = ViewHolder(itemView as View)

        val user = getItem(position) as User
        viewHolder.bind(user)
        return itemView
    }

    private inner class ViewHolder internal constructor(private val view: View) {
       internal fun bind(user: User){
            with(view){
                tv_name.text = user.name
                tv_username.text = StringBuilder("@" + user.username)
                Glide.with(view.context)
                    .load(user.profpict)
                    .apply(RequestOptions().override(50, 50))
                    .into(iv_profpict)
            }
        }

    }

    override fun getItem(i: Int): Any {
        return users[i]
    }

    override fun getItemId(i: Int): Long {
        return i.toLong()
    }

    override fun getCount(): Int {
        return users.size
    }
}