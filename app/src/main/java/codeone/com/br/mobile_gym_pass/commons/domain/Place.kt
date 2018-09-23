package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Place(
        @SerializedName("place_id")
        var placeId:String,
        @SerializedName("formatted_address")
        var formattedAddress:String,
        @SerializedName("address_components")
        var addressComponents:MutableList<AddressComponents>,
        @SerializedName("geometry")
        var geometry:Geometry,
        @SerializedName("types")
        var types:MutableList<String>
):Parcelable {
}