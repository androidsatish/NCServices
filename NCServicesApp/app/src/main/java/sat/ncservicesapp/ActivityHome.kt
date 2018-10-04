package sat.ncservicesapp

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.text.TextUtils.replace
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_notifications.*

class ActivityHome : AppCompatActivity(),FragmentInteraction.ServiceInteractionListener,FragmentInteraction.NotificationFragmentListener {
    override fun onServiceSelected(serviceId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onNotificationClicked(notificationId: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var fragment:Fragment
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                  fragment = FragmentServices.newInstance("","")
                  updateFragment(fragment,false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                fragment = FragmentNotificationList.newInstance("","")
                updateFragment(fragment,true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun updateFragment(fragment: Fragment,backStack:Boolean) {
        val ft = supportFragmentManager.beginTransaction()
            ft.replace(R.id.fragmentContainer,fragment)
            if (backStack){
                ft.addToBackStack("")
            }
            ft.commit()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_main)
        setSupportActionBar(toolbar)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_home
    }
}
