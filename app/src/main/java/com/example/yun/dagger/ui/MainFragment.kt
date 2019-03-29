package com.example.yun.dagger.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.yun.dagger.R
import com.example.yun.dagger.data.DataRepository
import dagger.android.support.DaggerFragment
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_main.*
import javax.inject.Inject

// DaggerFragment 상속받아 Component 연결
class MainFragment : DaggerFragment() {

    // DataRepository 타입 의존성 주입 요청
    @Inject
    lateinit var repository: DataRepository

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        loadData()
    }

    @SuppressLint("CheckResult")
    fun loadData(){
        repository.loadUser("yyjan")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                it.apply {
                    text_view.text = name
                }
            }) {

            }
    }
}
