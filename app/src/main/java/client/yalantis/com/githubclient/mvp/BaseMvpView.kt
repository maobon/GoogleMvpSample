package client.yalantis.com.githubclient.mvp

import android.content.Context

/**
 * Created by andrewkhristyan on 10/2/16.
 */
interface BaseMvpView {

    fun getContext(): Context

    fun showError(error: String?)

    fun showError(stringResId: Int)

    fun showMessage(srtResId: Int)

    fun showMessage(message: String)

}
