package com.iortynskyi.hmsd.core.rocket.launch

import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.iortynskyi.hmsd.R
import com.iortynskyi.hmsd.base.BaseActivity
import com.iortynskyi.hmsd.core.rocket.launch.domain.data.Launch
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchPresenter
import com.iortynskyi.hmsd.core.rocket.launch.presentation.RocketLaunchView
import com.iortynskyi.hmsd.utils.PrefsManager
import kotlinx.android.synthetic.main.activity_launch.*
import javax.inject.Inject

class RocketLaunchActivity : BaseActivity(), RocketLaunchView, LaunchCallbacks {

    @Inject lateinit var presenter: RocketLaunchPresenter
    @Inject lateinit var prefsManager: PrefsManager

    private lateinit var adapter: LaunchAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)
        initAdapter()
        presenter.attachView(this)
        presenter.fetchLaunches()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
        app.components.releaseLaunchComponent()
    }

    override fun setupComponent() {
        app.components.launchComponent().inject(this)
    }

    override fun loadLaunches(launches: List<Launch>) {
        adapter.addItems(processFavorite(launches))
    }

    override fun showProgress(visible: Boolean) {
        progressBar.visibility = if (visible) View.VISIBLE else View.GONE
    }

    override fun onItemClick(position: Int) {
        val launch = adapter.getItem(position)
        open(RocketLaunchDetailActivity::class.java, RocketLaunchDetailActivity.createBundle(launch.id))
    }

    override fun onFavoriteClick(position: Int) {
        val favoriteIds = prefsManager.fetchFavoriteLaunches()
        val launch = adapter.getItem(position)
        if (launch.favorite) favoriteIds.remove(launch.id) else favoriteIds.add(launch.id)
        launch.favorite = !launch.favorite
        prefsManager.persistFavoriteLaunches(favoriteIds)
        adapter.notifyItemChanged(position)
    }

    private fun initAdapter() {
        adapter = LaunchAdapter(mutableListOf(), this)
        launchesRecycler.layoutManager = LinearLayoutManager(this)
        launchesRecycler.itemAnimator = DefaultItemAnimator()
        launchesRecycler.adapter = adapter
    }

    private fun processFavorite(launches: List<Launch>): List<Launch> {
        val favoriteIds = prefsManager.fetchFavoriteLaunches()
        for (id in favoriteIds) {
            for (launch in launches) {
                if (id == launch.id) {
                    launch.favorite = true
                    break
                }
            }
        }
        return launches
    }
}
