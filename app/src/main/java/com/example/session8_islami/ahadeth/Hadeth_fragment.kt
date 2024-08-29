package com.example.session8_islami.ahadeth

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.session8_islami.utils.Constants
import com.example.session8_islami.R
import com.example.session8_islami.ahadeth.hadeth_adapter.AhadethAdapter

class Hadeth_fragment: Fragment (){



    lateinit var recyclerView: RecyclerView
    lateinit var hadethAdapter: AhadethAdapter
     var items = mutableListOf<String>(
         " حديث النيات " ,
         " حديث بناء الإسلام على خمس " ,
         " حديث النصيحة " ,
         " حديث فترة الجنين في بطن الأم " ,
         " حديث من أحدث في أمرنا هذا " ,
         " حديث الحلال والحرام " ,
         " حديث الدين النصيحة " ,
         " حديث أمرت أن أقاتل الناس " ,
         " حديث طيب الله لا يقبل إلا طيبا " ,
         " حديث دع ما يريبك إلى ما لا يريبك " ,
         " حديث من حسن إسلام المرء " ,
         " حديث لا يؤمن أحدكم حتى يحب لأخيه ما يحب لنفسه " ,
         " حديث لا يحل دم امرء مسلم " ,
         " حديث من كان يؤمن بالله واليوم الآخر " ,
         " حديث لا تغضب " ,
         " حديث الإحسان على كل شيء " ,
         " حديث إحسان القتل والذبح " ,
         " حديث الاتقاء والأمر بالمعروف والنهي عن المنكر " ,
         " حديث النصيحة النبوية لابن عباس " ,
         " حديث إذا لم تستح فاصنع ما شئت " ,
         " حديث الإيمان والاستقامة " ,
         " حديث الأعمال الصالحة ودخول الجنة " ,
         " حديث فضل الطهور والصلاة والسبحة " ,
         " حديث رسول الله عن الظلم " ,
         " حديث الأجور المتساوية بالنية " ,
         " حديث فضل الصدقة والكلمة الطيبة " ,
         " حديث البر والإثم " ,
         " حديث الوصية بالتقوى والاعتصام بالسنة " ,
         " حديث أعمال الإسلام ورأس الأمر " ,
         " حديث الله فرض فرائض " ,
         " حديث الازهد في الدنيا " ,
         " حديث لا ضرر ولا ضرار " ,
         " حديث البينة على المدعي واليمين على من أنكر " ,
         " حديث من رأى منكم منكرًا " ,
         " حديث لا تحاسدوا " ,
         " حديث من نفس عن مؤمن كربة " ,
         " من عادى لي ولياً " ,
         " تجاوز الله لأمتي " ,
         " كن في الدنيا كأنك غريب " ,
         " هوى الإنسان " ,
         " ما دعوتني ورجوتني " ,
         " ألحقوا الفرائض بأهلها " ,
         " الرضاعة تحرم ما تحرم الولادة " ,
         " حرم الله بيع الخمر والميتة " ,
         " كل مسكر حرام " ,
         " لا يمتلئ بطن الإنسان وعاء شراً " ,
         " أربع من كن فيه كان منافقاً " ,
         " لو أنكم توكلون على الله حق توكله " ,
         " لا يزال لسانك رطباً من ذكر الله " )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hadeth,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        createHadethList()
        createRecyclerView()



    }
    private fun showHadethContent(pos: Int, name : String){
        val intent = Intent(requireContext(), HadethDetailsActivity::class.java)
        intent.putExtra(Constants.HADETH_NAME,name)
        intent.putExtra(Constants.HADETH_POSITION,pos)
        startActivity(intent)
    }

    private fun createRecyclerView() {
        recyclerView = requireView().findViewById(R.id.recyclerView_hadeth)
        hadethAdapter = AhadethAdapter(items)
        recyclerView.adapter= hadethAdapter

        hadethAdapter.onHadethClickListener = object : AhadethAdapter.OnHadethClickListener{
            override fun onHadethClick(position: Int, item: String) {
                showHadethContent(position,item)
            }
        }

    }



}