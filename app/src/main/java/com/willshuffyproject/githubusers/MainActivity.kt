package com.willshuffyproject.githubusers

import android.content.Intent
import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: UserAdapter

    private lateinit var dataName: Array<String>
    private lateinit var dataUsername: Array<String>
    private lateinit var dataCompany: Array<String>
    private lateinit var dataLocation: Array<String>
    private lateinit var dataRepository: Array<String>
    private lateinit var dataFollower: Array<String>
    private lateinit var dataFollowing: Array<String>
    private lateinit var dataProfpict: TypedArray

    private var users = arrayListOf<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //load animation

        val apps_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)
        val text_logo = AnimationUtils.loadAnimation(this, R.anim.alpha_with_scale)


        //run animation

        iv_logo.startAnimation(apps_logo)
        tv_logo.startAnimation(text_logo)


        adapter = UserAdapter(this)
        lv_user.divider = null
        lv_user.adapter = adapter

        prepare()
        addItem()

        lv_user.onItemClickListener = AdapterView.OnItemClickListener{_, _, position, _ ->
            //Toast.makeText(this@MainActivity, users[position].name, Toast.LENGTH_SHORT).show()
            val intentDataUser = User(
                users[position].username,
                users[position].name,
                users[position].profpict,
                users[position].company,
                users[position].location,
                users[position].repository,
                users[position].follower,
                users[position].following
            )

            val intentData = Intent(this@MainActivity, DetailActivity::class.java)
            intentData.putExtra(DetailActivity.KEY_USER, intentDataUser)
            startActivity(intentData)
        }
    }

    private fun addItem(){
        for (position in dataName.indices){

            val user = User(
                dataUsername[position],
                dataName[position],
                dataProfpict.getResourceId(position, -1),
                dataCompany[position],
                dataLocation[position],
                dataRepository[position],
                dataFollower[position],
                dataFollowing[position]

            )
            users.add(user)
        }
        adapter.users = users
    }
    private fun prepare(){

        dataUsername = resources.getStringArray(R.array.data_username)
        dataName = resources.getStringArray(R.array.data_name)
        dataProfpict = resources.obtainTypedArray(R.array.data_profpict)
        dataCompany = resources.getStringArray(R.array.data_company)
        dataLocation = resources.getStringArray(R.array.data_location)
        dataRepository = resources.getStringArray(R.array.data_repository)
        dataFollower = resources.getStringArray(R.array.data_follower)
        dataFollowing = resources.getStringArray(R.array.data_following)

    }
}
