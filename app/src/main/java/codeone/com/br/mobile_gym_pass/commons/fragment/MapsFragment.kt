package codeone.com.br.mobile_gym_pass.commons.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.commons.domain.Geocode
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


/**
 * A simple [Fragment] subclass.
 *
 */
class MapsFragment : androidx.fragment.app.Fragment(), OnMapReadyCallback {

    private var map:GoogleMap? = null
    private var geocode:Geocode? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_maps, container, false)

        var mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_maps) as SupportMapFragment

        mapFragment.getMapAsync(this)

        geocode = arguments?.getParcelable<Geocode>("geocode")

        return  view
    }

    override fun onMapReady(p0: GoogleMap?) {

        map = p0

        val location = LatLng(geocode!!.results[0].geometry.location.latitude, geocode!!.results[0].geometry.location.longitude)

        val update = CameraUpdateFactory.newLatLngZoom(location, 13f)

        map?.moveCamera(update)

        map?.addMarker(MarkerOptions()
                .title("mapa")
                .snippet(geocode!!.results[0].formattedAddress)
                .position(location))
        map?.mapType = GoogleMap.MAP_TYPE_NORMAL
    }

}
