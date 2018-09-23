package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Geocode(
        @SerializedName("status")
        var status:String,
        @SerializedName("results")
        var results:MutableList<Place>
) :Parcelable{
}