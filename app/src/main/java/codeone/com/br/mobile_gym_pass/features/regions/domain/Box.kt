package codeone.com.br.mobile_gym_pass.features.regions.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Box(
        @SerializedName("IdBox")
        var idBox:Int,
        @SerializedName("imgFoto")
        var imgFoto:String,
        @SerializedName("NmBox")
        var nmBox:String,
        @SerializedName("TxtAmbiente")
        var txtAmbiente:String,
        @SerializedName("TxtInfo")
        var txtInfo:String,
        @SerializedName("TxtDescParceiro1Oferta")
        var txtDescParceiro1Oferta:String,
        @SerializedName("TxtDescParceiro2Oferta")
        var txtDescParceiro2Oferta:String,
        @SerializedName("LnkParceiro1")
        var lnkParceiro1:String,
        @SerializedName("LnkParceiro2")
        var lnkParceiro2:String,
        @SerializedName("NmInfoImportante")
        var nmInfoImportante:String,
        @SerializedName("IdEmpresa")
        var idEmpresa:Int,
        @SerializedName("Periodo")
        var periodo:MutableList<Periodo>
):Parcelable {
}