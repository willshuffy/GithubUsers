package com.willshuffyproject.githubusers

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.appcompat.app.AlertDialog
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.exit_dialog.view.*

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

        iv_back.setOnClickListener{
            finish()
        }

        iv_menu.setOnClickListener {
            showPopUp(iv_menu)
        }

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
}
