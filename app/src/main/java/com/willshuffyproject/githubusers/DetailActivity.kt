package com.willshuffyproject.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_USER = "key_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val users = intent.getParcelableExtra(KEY_USER) as User

        tv_name.text = users.name.toString()
        tv_username.text = "@${users.username.toString()}"
        tv_follower.text = users.follower.toString()
        tv_following.text = users.following.toString()
        tv_repository.text = users.repository.toString()
        tv_name_data.text = users.name.toString()
        tv_company.text = users.company.toString()
        tv_location.text = users.location.toString()
        Glide.with(this)
            .load(users.profpict)
            .apply(RequestOptions())
            .into(iv_profpict)
    }
}
