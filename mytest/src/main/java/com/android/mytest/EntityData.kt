package com.android.mytest

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class EntityData {
    @PrimaryKey
    var id = 0
    var title: String? = null
    var text: String? = null

    constructor()
    constructor(title: String?, text: String?) {
        this.title = title
        this.text = text
    }

    override fun toString(): String {
        return "EntityData{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}'
    }
}