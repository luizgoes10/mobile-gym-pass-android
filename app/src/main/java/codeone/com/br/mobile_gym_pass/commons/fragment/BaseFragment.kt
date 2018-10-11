package codeone.com.br.mobile_gym_pass.commons.fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View


open class BaseFragment: androidx.fragment.app.Fragment(), LifecycleOwner {

    private lateinit var mLifecycleRegistry: LifecycleRegistry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mLifecycleRegistry = LifecycleRegistry(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mLifecycleRegistry.markState(Lifecycle.State.CREATED)
    }

    override fun onPause() {
        super.onPause()
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun onStop() {
        super.onStop()
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun onDestroy() {
        super.onDestroy()
        mLifecycleRegistry.markState(Lifecycle.State.DESTROYED)
    }

    override fun onResume() {
        super.onResume()
        mLifecycleRegistry.markState(Lifecycle.State.RESUMED)
    }

    override fun getLifecycle(): Lifecycle {
        return mLifecycleRegistry
    }

}