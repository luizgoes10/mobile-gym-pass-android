package codeone.com.br.mobile_gym_pass.features.regions.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Periodo(
        @SerializedName("IdPeriodo")
        var idPeriodo:Int,
        @SerializedName("NmDescricao")
        var nmDescricao:String,
        @SerializedName("IdBox")
        var idBox:Int,
        @SerializedName("VlrPeriodo")
        var vlrPeriodo:Float
): Parcelable {
}