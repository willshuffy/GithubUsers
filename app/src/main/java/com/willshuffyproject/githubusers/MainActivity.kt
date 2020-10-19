package com.willshuffyproject.githubusers

import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.AdapterView
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.exit_dialog.view.*

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
            intentData.putExtra(DetailActivity.KEY_USER, users[position])
            startActivity(intentData)
        }


        iv_back.setOnClickListener{
            onBackPressed()
        }

        iv_menu.setOnClickListener {
            showPopUp(iv_menu)
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

    private fun showPopUp(view: View){

        val popup = PopupMenu(this, view)
        popup.inflate(R.menu.main_menu)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->

            when (item!!.itemId){

                R.id.action_exit -> {

                    val view = LayoutInflater.from(this).inflate(R.layout.exit_dialog, null)
                    val alert = AlertDialog.Builder(this, R.style.CustomAlertDialog)
                        .setView(view)
                        .setCancelable(false)

                    val mAlertDialog = alert.show()
                    mAlertDialog?.window?.setLayout(700, 500)

                    view.btn_iya.setOnClickListener{
                        finishAffinity()
                    }
                    view.btn_tidak.setOnClickListener {
                        mAlertDialog.dismiss()
                    }
                }
            }
            true
        })
        popup.show()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val view = LayoutInflater.from(this).inflate(R.layout.exit_dialog, null)
        val alert = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .setView(view)
            .setCancelable(false)

        val mAlertDialog = alert.show()
        mAlertDialog?.window?.setLayout(700, 500)

        view.btn_iya.setOnClickListener{
            finishAffinity()
        }
        view.btn_tidak.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }
}
