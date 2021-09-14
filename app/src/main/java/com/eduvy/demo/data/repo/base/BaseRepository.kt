package com.eduvy.demo.data.repo.base

import kotlinx.coroutines.Dispatchers

abstract class BaseRepository  {
    var ioDispatcher = Dispatchers.IO
}