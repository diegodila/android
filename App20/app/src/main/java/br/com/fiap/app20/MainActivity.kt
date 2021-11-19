package br.com.fiap.app20

import android.graphics.Bitmap
import android.graphics.Canvas
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : FragmentActivity(), OnMapReadyCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        val saoPaulo = LatLng(-23.550520, -46.633308)
        val paranapiacaba = LatLng(-23.778179, -46.304001)
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(saoPaulo))
        googleMap.setMinZoomPreference(6.0f)
        googleMap.setMaxZoomPreference(18.0f)


        val saoPauloMarker =
            MarkerOptions()
                .position(saoPaulo)
                .alpha(0.7f)
                .title("Aqui é São Paulo")
                .rotation(90f)
                .icon(bitmapDescriptorFromVector(android.R.drawable.star_on))
        googleMap.addMarker(saoPauloMarker)

        val paranapiacbaMarker = MarkerOptions().position(paranapiacaba)
        googleMap.addMarker(paranapiacbaMarker)

        googleMap.setOnMarkerClickListener {  
            marker ->
            if (marker.title == "SP") {
                Toast.makeText(this@MainActivity, "CLicou em Sp", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this@MainActivity, "CLicou em algo que não é SP", Toast.LENGTH_SHORT).show()
            }
            true
        }
        googleMap.uiSettings.isZoomControlsEnabled = true
    }
    private fun bitmapDescriptorFromVector(vectorResId: Int): BitmapDescriptor? {
        return ContextCompat.getDrawable(this, vectorResId)?.run {
            setBounds(0, 0, intrinsicWidth, intrinsicHeight)
            val bitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888)
            draw(Canvas(bitmap))
            BitmapDescriptorFactory.fromBitmap(bitmap)
        }
    }
}