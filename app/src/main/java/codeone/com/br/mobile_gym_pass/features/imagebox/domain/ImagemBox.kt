package codeone.com.br.mobile_gym_pass.features.imagebox.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagemBox(
        @SerializedName("IdImagem")
        var idImagem:Int,
        @SerializedName("NmDescricao")
        var nmDescricao:String,
        @SerializedName("IdBox")
        var idBox:Int
):Parcelable {
}