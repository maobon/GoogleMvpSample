package client.yalantis.com.githubclient.mvp

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * Created by andrewkhristyan on 10/2/16.
 */
abstract class BaseMvpActivity<in V : BaseMvpView, T : BaseMvpPresenter<V>>
    : AppCompatActivity(), BaseMvpView {

    protected abstract var mPresenter: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mPresenter.attachView(this as V)
    }

    override fun getContext(): Context = this

    override fun showError(error: String?) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show()
    }

    override fun showError(stringResId: Int) {
        Toast.makeText(this, stringResId, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(srtResId: Int) {
        Toast.makeText(this, srtResId, Toast.LENGTH_LONG).show()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}