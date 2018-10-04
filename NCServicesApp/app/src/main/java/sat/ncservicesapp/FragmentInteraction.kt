package sat.ncservicesapp

class FragmentInteraction{
    interface ServiceInteractionListener{
        fun onServiceSelected(serviceId:Int)
    }
    interface NotificationFragmentListener{
        fun onNotificationClicked(notificationId:Int)
    }
}