/*
 *  Created by Surajit Deka on 25/6/19 12:39 PM
 *  Copyright (c) Letstrack 2019 . All rights reserved.
 *  Last modified 27/4/19 2:38 PM
 *
 */
package com.sainivik.corelibrarymvvm.helper

class EventTask<T> private constructor(
    val task: Task,
    val status: Status,
    val data: T?,
    val msg: String?
) {
    companion object {
        @JvmStatic
        fun <T> success(data: T, task: Task): EventTask<T> {
            return EventTask(task, Status.SUCCESS, data, null)
        }

        @JvmStatic
        fun <T> error(task: Task): EventTask<T?> {
            return EventTask(task, Status.ERROR, null, null)
        }

        fun <T> perform(data: T?, task: Task): EventTask<T?> {
            return EventTask(task, Status.PERFORM, data, null)
        }

        @JvmStatic
        fun <T> loading(task: Task): EventTask<T?> {
            return EventTask(task, Status.LOADING, null, null)
        }

        @JvmStatic
        fun <T> message(data: T, task: Task): EventTask<T> {
            return EventTask(task, Status.SUCCESS, data, null)
        }
    }
}