package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Geometry(
        @SerializedName("location_type")
        var locationType:String,
        @SerializedName("location")
        var location:Location,
        @SerializedName("viewport")
        var viewPort: ViewPort
):Parcelable {
}