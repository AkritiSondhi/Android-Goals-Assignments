package com.example.akriti.listviewdemo

/**
 * Created by Akriti on 7/2/2018.
 */

class Friend {
    var fname: String? = null
    var lname: String? = null
    var last_msg: String? = null
    var time: String? = null
    var contact: String? = null

    constructor(fname: String?, lname: String?, last_msg: String?, time: String?, contact: String?) {
        this.fname = fname
        this.lname = lname
        this.last_msg = last_msg
        this.time = time
        this.contact = contact
    }

    constructor()
}