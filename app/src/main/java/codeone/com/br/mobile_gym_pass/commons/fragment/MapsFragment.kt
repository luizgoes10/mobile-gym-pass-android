package codeone.com.br.mobile_gym_pass.commons.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment


/**
 * A simple [Fragment] subclass.
 *
 */
class MapsFragment : BaseFragment(), OnMapReadyCallback {

    private var map:GoogleMap? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_maps, container, false)

        var mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragments_maps) as SupportMapFragment

        mapFragment.getMapAsync(this)

        return  view
    }

    override fun onMapReady(p0: GoogleMap?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
