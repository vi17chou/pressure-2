package com.example.mainactivity

import android.media.metrics.Event
import com.google.firebase.firestore.Exclude

data class Diary_DB(var Today:String="",var content:String="", var Diary_id:Int=0){
    private var _event:ArrayList<Event> = ArrayList<Event>()
            var events:ArrayList<Event>
            @Exclude get(){
                return _event
            }
    set(value) {_event=value}

    override fun toString(): String {
        return "$Today $content"
    }
}
