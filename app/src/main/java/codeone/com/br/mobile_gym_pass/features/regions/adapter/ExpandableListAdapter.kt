package codeone.com.br.mobile_gym_pass.features.regions.adapter

import android.content.Context
import android.graphics.Typeface
import android.os.Parcel
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView
import codeone.com.br.mobile_gym_pass.R
import codeone.com.br.mobile_gym_pass.features.regions.domain.util.MenuModel

class ExpandableListAdapter(context: Context, listDataHeader:List<MenuModel>,
                            listChildData:HashMap<MenuModel, List<MenuModel>>) : BaseExpandableListAdapter(){
    private val context: Context? = context
    private val listHeaderData: List<MenuModel> = listDataHeader
    private val listDataChild: HashMap<MenuModel, List<MenuModel>> = listChildData

    override fun getChild(groupPosition: Int, childPosition: Int): MenuModel {
        return listDataChild.get(listHeaderData.get(groupPosition))!!.get(childPosition)
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {
        return childPosition.toLong()
    }
    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View? {
        var childText = getChild(groupPosition, childPosition).menuName
        var convert = convertView

        if (convert == null) {
            val infalInflater = this.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
          //  convert = infalInflater.inflate(R.layout.list_group_child, null)
        }

      //  var txtListChild = convert?.findViewById<TextView>(R.id.lblListItem)

      //  txtListChild?.text = childText
        return convert

    }

    override fun getChildrenCount(groupPosition: Int): Int {
        if (this.listDataChild.get(this.listHeaderData.get(groupPosition)) == null)
            return 0;
        else{
            return listDataChild.get(listHeaderData.get(groupPosition))!!.size
        }
    }
    override fun getGroup(groupPosition: Int): MenuModel {
        return listHeaderData.get(groupPosition)
    }

    override fun getGroupId(groupPosition: Int): Long {
        return groupPosition.toLong()
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {

        val headerTitle = getGroup(groupPosition).menuName
        var convert = convertView
        if (convertView == null) {
            val infalInflater = this.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
         //   convert = infalInflater.inflate(R.layout.list_group_header, null)
        }

      //  val lblListHeader = convert?.findViewById<TextView>(R.id.lblListHeader)
    //    lblListHeader?.setTypeface(null, Typeface.BOLD)
    //    lblListHeader?.text = headerTitle

        return convert!!
    }
    override fun hasStableIds(): Boolean {
        return false
    }
    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {
        return true
    }

    override fun getGroupCount(): Int {
        return listHeaderData.size
    }

}