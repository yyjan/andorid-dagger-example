package com.example.yun.dagger.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yun.dagger.GlideApp
import com.example.yun.dagger.R
import com.example.yun.dagger.data.DataRepository
import com.example.yun.dagger.data.model.Response
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

// DaggerFragment 상속받아 Component 연결
class ProfileFragment : DaggerFragment() {

    // DataRepository 타입 의존성 주입 요청
    @Inject
    lateinit var repository: DataRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)

        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        repository.loadUser("yyjan")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                showProgress()
            }
            .doOnTerminate {
                hideProgress()
            }
            .subscribe({
                initView(it)
            }) {
                it.printStackTrace()
            }
    }

    private fun initView(response: Response) {
        response.apply {

            // set title
            activity!!.title = String.format(getString(R.string.title_profile_load), login)

            // set layout visibility
            layout_profile.visibility = View.VISIBLE

            // set profile
            tv_name.text = name
            tv_bio.text = bio
            tv_location.text = location
            tv_followers.text = followers.toString()
            tv_following.text = following.toString()
            tv_repositories.text = public_repos.toString()
            tv_blog.text = blog

            // set image
            activity?.let {
                GlideApp.with(it)
                    .load(avatar_url)
                    .into(iv_avatar)
            }

            // set onClick listener
            iv_avatar.setOnClickListener {
                val url = html_url
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(intent)
            }
        }
    }

    private fun showProgress() {
        progress.visibility = View.VISIBLE
    }

    private fun hideProgress() {
        progress.visibility = View.GONE
    }
}
