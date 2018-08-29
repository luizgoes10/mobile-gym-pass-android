package codeone.com.br.mobile_gym_pass.features.all_objects.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Empresa(
        @SerializedName("IdEmpresa")
        var idEmpresa:Int,
        @SerializedName("ImgLogo")
        var imgLogo:String,
        @SerializedName("NmEmpresa")
        var nmEmpresa:String,
        @SerializedName("AddrEndereco")
        var addrEndereco:String,
        @SerializedName("TelTelefone")
        var telTelefone:String,
        @SerializedName("BoolGostei")
        var boolGostei:Boolean,
        @SerializedName("VlrMinPreco")
        var vlrMinPreco:Float,
        @SerializedName("VlrMaxPreco")
        var vlrMaxPreco:Float,
        @SerializedName("TxtSobre")
        var txtSobre:String,
        @SerializedName("TxtCortesia")
        var txtCortesia:String,
        @SerializedName("TxtLocalizacao")
        var txtLocalizacao:String,
        @SerializedName("IdLocalizacao")
        var idLocalizacao:Int,
        @SerializedName("Box")
        var box:MutableList<Box>
) : Parcelable {
}