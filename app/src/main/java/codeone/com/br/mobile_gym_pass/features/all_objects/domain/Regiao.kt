package codeone.com.br.mobile_gym_pass.features.all_objects.domain

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Regiao(
        @SerializedName("IdRegiao")
        var idRegiao:Int,
        @SerializedName("NmRegiao")
        var nmRegiao:String
):Parcelable {
}