package codeone.com.br.mobile_gym_pass.commons.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Northeast(
        @SerializedName("lat")
        var latitude:Double,
        @SerializedName("lng")
        var longitude:Double
) :Parcelable{
}